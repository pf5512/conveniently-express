
function orderSearch() {

    var number = $("#orderInput").val();
    console.log(number);
    var request = $.ajax({
        url: "/api/order",
        type: "get",
        data: {
            number: number
        }
    });

    request.done(function(response) {
        console.log(response);

        $("#orderError").hide();
        $("#orderSearchShow").hide();
        if (response.code == 100){
            $("#number").text(response.data.number);
            $("#tradeTime").text(response.data.tradeTime);
            $("#allPrice").text(response.data.allPrice);
            $("#orderId").text(response.data.id);
            if (response.data.status == 1) {
                $("#status1").show();
            }else {
                $("#status0").show();
            }
            $("#orderSearchShow").show();
        }else{
            $("#orderError").show();
        }
    });

    request.fail(function(jqXHR, textStatus) {
        alert( "Request failed: " + textStatus );
    });

}




function orderItemShow(id) {


    var request = $.ajax({
        url: "/api/v1/getOrderItems/"+id,
        type: "get"
    });

    request.done(function(response) {
        console.log(response);
        var html = "<table class='table table-bordered table-striped table-sm'>";
        html += "<thead>";
        html += " <tr>";
        html += " <th>创建时间</th>";
        html += " <th>详情</th>";
        html += " <th>价格</th>";
        html += " <th>交易时间</th>";
        html += " </tr>";
        html += " </thead> <tbody> ";
        for (var i = 0; i < response.data.length; i++) {
            html += " <tr>";
            html += " <td>" + response.data[i].createTime + "</td>";
            html += " <td>" + response.data[i].detailName + "</td>";
            html += " <td>" + response.data[i].detailPrice + "</td>";
            html += " <td>" + response.data[i].tradeTime + "</td>";
            html += " </tr>";
        }
        html += "      </tbody> </table>";
        $("#orderItems").innerHTML = html;
        document.getElementById("orderItems").innerHTML=html;
        $("#orderShow").modal('show');
        // $("#username").text(response.data.name);
        // var phone = response.data.phone;
        // console.log(phone)
        // $("#phone").text(phone);
        // $('#userShow').modal('show');


    });

    request.fail(function(jqXHR, textStatus) {
        alert( "Request failed: " + textStatus );
    });

}

