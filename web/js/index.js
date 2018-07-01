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



    return service;
});


app.controller('ControllerHome',function($scope, ServiceHome, $location){



});



//Login Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceLogin', function($http){
    var service = {};



    return service;
});


app.controller('ControllerLogin',function($scope, ServiceLogin){

});


//Register Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceRegister', function($http){
    var service = {};

    service.getAllCountries = function(){
        return  $http.get(rest+"/country");
    };

    return service;
});


app.controller('ControllerRegister',function($scope, ServiceRegister){

    ServiceRegister.getAllCountries().then(function (response) {
        $scope.countries = response.data;
    });

});
