$(function () {
    var loginModel = kendo.observable({
            username: "admin",
            password: "123456",
            rememberMe: true,

            init: function () {
                loginModel.set("username", "");
                loginModel.set("password", "");
                loginModel.set("rememberMe", true);
            },

            onLogin: function () {
                var $loginForm = $("#login-form"),
                    validator = $loginForm.kendoValidator().data("kendoValidator");

                if (validator.validate()) {
                    $loginForm.submit();
                }
            },

            onReset: function () {
                loginModel.init();
            }
        }),
        $login = $("#login-view"),
        login, bgColor;

    kendo.bind($login, loginModel);

    login = $login.getKendoWindow();
    login.wrapper.css("box-shadow", "1px 1px 7px 1px rgba(0,0,0,.3)");
    login.setOptions({
        resizable: false,
        scrollable: false,
        draggable: false
    });
    login.center().open();
    login.bind('close', function (e) {
        kendo.confirm("退出系统吗?").done(function () {
            kendo.alert(e.userTriggered);
        }).fail(function () {
            kendo.alert("不关闭");
        });
        e.preventDefault();
    });
    bgColor = $login.css("background-color");
    //CHANGE BACKGROUND COLOR FOR CURRENT THEME
    $("body").css("background-color", bgColor ? bgColor : "#fff");
    //CENTER LOGIN WINDOW WHEN BROWSER VIEW CHANGED
    $(window).resize(function () {
        login.center();
    });
});