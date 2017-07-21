/**
 * Created by nengneng on 2017/4/24.
 */



function userShow(id) {


    var request = $.ajax({
        url: "/api/user/"+id,
        type: "get",
    });

    request.done(function(response) {
        console.log(response.data);


        $("#username").text(response.data.name);
        var phone = response.data.phone;
        console.log(phone)
        $("#phone").text(phone);
        $('#userShow').modal('show');


    });

    request.fail(function(jqXHR, textStatus) {
        alert( "Request failed: " + textStatus );
    });

}



function userSearch() {

    var searchName = $("#prependedInput").val();
    console.log(searchName);
    var request = $.ajax({
        url: "/api/user",
        type: "get",
        data: {
            name: searchName
        }
    });

    request.done(function(response) {
        console.log(response);

        $("#searchShow").hide();
        $("#errorShow").hide();
        if (response.code == 100){
            $("#name").text(response.data.name);
            $("#createDate").text(response.data.createTime);
            $("#phone").text(response.data.phone);
            $("#realName").text(response.data.realName);
            $("#address").text(response.data.address);
            if (response.data.status == 1) {
                $("#status1").show();
            }else {
                $("#status0").show();
            }
            $("#searchShow").show();
        }else{
            $("#errorShow").show();
        }
    });

    request.fail(function(jqXHR, textStatus) {
        alert( "Request failed: " + textStatus );
    });

}

function user_previousState() {
    window.location.href = "/api/consumers";
}






