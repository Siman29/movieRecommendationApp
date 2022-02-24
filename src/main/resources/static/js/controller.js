var app = angular.module('loginSignup', []);

app.config(function() {

})

app.controller('ctrl', function($scope) {

    var logged = false;


    $scope.login = function() {
        uname = $scope.uname_login;
        pw = $scope.pw_login;
        console.log(uname)
        if (uname != "" && pw != "") {
            $scope.name = uname;
            logged = true;
            $scope.uname_login = "";
            $scope.pw_login = "";
            document.getElementById("welcome").style.display = "block";
            document.getElementById("login").style.display = "none";
            document.getElementById("signup").style.display = "none";
            document.getElementById("logout").style.display = "block";
            $('#loginmodel').modal('hide')
        }
    }
    $scope.signup = function() {
        uname = $scope.uname_signup;
        pw = $scope.pw_signup;
        if (uname != "" && pw != "") {
            $scope.name = uname;
            logged = true;
            $scope.uname_signup = "";
            $scope.email_signup = "";
            $scope.pw_signup = "";
            $scope.confirm_pw_signup = "";
            document.getElementById("welcome").style.display = "block";
            document.getElementById("login").style.display = "none";
            document.getElementById("signup").style.display = "none";
            document.getElementById("logout").style.display = "block";
            $('#signupmodel').modal('hide')
        }
    }

    $scope.logout = function() {
        logged = false;
        document.getElementById("welcome").style.display = "none";
        document.getElementById("login").style.display = "initial";
        document.getElementById("signup").style.display = "initial";
        document.getElementById("logout").style.display = "none";
    }
});