$(document).ready(function () {
    checkAccount();
});

function checkAccount() {
    $("#btnLogIn").click(function () {
        var account = {
            email: $("#email").val(),
            password: $("#password").val(),
        };
        console.table(account);
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://" + ipAddress + "/user/login",
            dataType: "json",
            data: JSON.stringify(account),
            success: function (data) {
                if (data.code == "000") {
                    createCookie("pageActionList", JSON.stringify(data.pageActionList), 30);
                    createCookie("token", data.token, 30);
                    createCookie("idUser", data.user.idUser, 30);
                    createCookie("username", data.user.username, 30);
                    createCookie("idGroup", data.user.idGroup, 30);
                    location.assign("index.html");
                } else if (data.code == "003") {
                    $.notify(data.message, {
                        position: "top center",
                        className: "error"
                    });
                } else {
                    $.notify(data.message, {
                        position: "top center",
                        className: "error"
                    });
                }
            },
            error: function (e) {
                console.log(e);
            },
        });
    });
}