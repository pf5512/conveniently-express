package com.neng.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by nengneng on 2017/5/7.
 */
@Component
public class CustomizationBean
        implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

        container.addErrorPages(error401Page, error404Page, error500Page);
    }
}