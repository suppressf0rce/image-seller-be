var app = angular.module('ImageSeller', ['ngRoute']);

rest = "http://localhost:8080/ImageSeller/rest";

app.config(function($routeProvider){
    $routeProvider
        .when("/",{
            templateUrl: "content/home.html",
            controller: 'ControllerHome'
        })

        .when("/login",{
            templateUrl: "content/login.html",
            controller: 'ControllerLogin'
        })

        .when("/register",{
            templateUrl: "content/register.html",
            controller: 'ControllerRegister'
        })


        .otherwise({
            redirectTo: "/"
        });
});



//Home Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceHome', function($http){
    var service = {};

    service.getAuthUser = function(){
        return  $http.get(rest+"/users/token", { headers: {'Authorization': 'Bearer '+localStorage.getItem("token")}});
    };

    return service;
});


app.controller('ControllerHome',function($scope, ServiceHome, $location){

    $scope.loggedIn = false;

    if(localStorage.getItem("token") !== null){
        ServiceHome.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;
        })
    }

    $scope.logout = function () {
        localStorage.setItem("token", null);
    }

});



//Login Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceLogin', function($http){
    var service = {};

    service.login = function(user){
        return $http.post(rest+"/users/login", user)
    };

    return service;
});


app.controller('ControllerLogin',function($scope, ServiceLogin, $location){

    $scope.loginUser = function () {
        ServiceLogin.login($scope.user).then(function (response) {
            localStorage.setItem("token", response.data.token);
            $location.path("/")
        }, function () {
            alert("Incorrect credentials. Please try again.")
        })
    }

});

//Register Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceRegister', function($http){
    var service = {};

    service.getAllCountries = function(){
        return  $http.get(rest+"/country");
    };

    service.getCountryById = function(id){
        return $http.get(rest+"/country/"+id);
    };

    service.register = function(user){
        return $http.post(rest+"/users/register", user)
    };

    return service;
});


app.controller('ControllerRegister',function($scope, ServiceRegister, $location){

    ServiceRegister.getAllCountries().then(function (response) {
        $scope.countries = response.data;
    });

    $scope.registerUser = function () {
        var user = $scope.user;
        if(!checkPass()){
            alert("Passwords don't match");
            return;
        }

        if(user.country == null){
            user.country = null;

            ServiceRegister.register(user).then(function (response) {
                localStorage.setItem("token", response.data.token);
                $location.path("/")
            }, function () {
                alert("User with that username already exists!");
            })
        }else {
            ServiceRegister.getCountryById(user.country).then(function (response) {
                user.country = response.data;

                ServiceRegister.register(user).then(function (response) {
                    localStorage.setItem("token", response.data.token);
                    $location.path("/")
                }, function () {
                    alert("User with that username already exists!");
                })
            }, function () {
                alert("Unrecognized country!");
            });
        }
    }
});

function checkPass()
{
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('password');
    var pass2 = document.getElementById('passwordConfirm');

    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field
    //and the confirmation field
    if(pass1.value === pass2.value){
        //The passwords match.
        //Set the color to the good color and inform
        //the user that they have entered the correct password
        pass2.style.backgroundColor = goodColor;
        return true;
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.backgroundColor = badColor;
        return false;
    }
}

