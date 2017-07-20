package com.neng.web.rest;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.neng.config.ApiConf;
import com.neng.pojo.Order;
import com.neng.pojo.config.Api;
import com.neng.utils.Result;
import com.neng.utils.alipay.AliPayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class AliPayController {

    @Value("${ALIPAY.ALIPAY_PUBLIC_KEY}")
    private static String ALIPAY_PUBLIC_KEY;

    private AliPayUtils aliPayUtils;

    /**
     * 回调网关
     *
     * @param request
     * @throws AlipayApiException
     */
    @RequestMapping(value = ApiConf.getWay)
    public void getWayAliPay(HttpServletRequest request) throws AlipayApiException {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean flag = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, "UTF-8", "RSA2");
    }

    @RequestMapping(value = ApiConf.prepareAliPay, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> prepareAliPay(@RequestParam Order order, HttpSession session) {
        Map<String, String> map = new HashMap<>();
        map.put("subject", order.getNeed().getGoodName());
        map.put("body", order.getNeed().getContent());
        map.put("outTradeNo", order.getNumber());
        map.put("totalAmount", String.valueOf(order.getAllPrice()));
        Result<AlipayTradeAppPayResponse> result = new Result<>();
        result.api(Api.SUCCESS);
        aliPayUtils = new AliPayUtils();
        result.setData(aliPayUtils.appPay(map, ApiConf.getWay));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
