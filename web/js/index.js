var app = angular.module('ImageSeller', ['ngRoute', 'ngTable']);

rest = "http://localhost:8080/ImageSeller/rest";

app.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "content/home.html",
            controller: 'ControllerHome'
        })

        .when("/login", {
            templateUrl: "content/login.html",
            controller: 'ControllerLogin'
        })

        .when("/register", {
            templateUrl: "content/register.html",
            controller: 'ControllerRegister'
        })

        .when("/adminPanel", {
            templateUrl: "content/admin_panel.html",
            controller: 'ControllerAdminPanel'
        })

        .when("/adminPanel/tables/admins", {
            templateUrl: "content/table_admins.html",
            controller: 'ControllerAdminPanelTablesAdmins'
        })

        .when("/adminPanel/tables/admins/add", {
            templateUrl: "content/admins_add.html",
            controller: 'ControllerAdminPanelTablesAdminsAdd'
        })

        .otherwise({
            redirectTo: "/"
        });
});


app.run(function ($rootScope) {
    $rootScope.$on("$includeContentLoaded", function (event, templateName) {
        //Other JQuery Functionality
        if (templateName === "content/admin_panel_footer.html") {
            (function ($) {
                "use strict"; // Start of use strict
                // Configure tooltips for collapsed side navigation
                $('.navbar-sidenav [data-toggle="tooltip"]').tooltip({
                    template: '<div class="tooltip navbar-sidenav-tooltip" role="tooltip" style="pointer-events: none;"><div class="arrow"></div><div class="tooltip-inner"></div></div>'
                });
                // Toggle the side navigation
                $("#sidenavToggler").click(function (e) {
                    e.preventDefault();
                    $("body").toggleClass("sidenav-toggled");
                    $(".navbar-sidenav .nav-link-collapse").addClass("collapsed");
                    $(".navbar-sidenav .sidenav-second-level, .navbar-sidenav .sidenav-third-level").removeClass("show");
                });
                // Force the toggled class to be removed when a collapsible nav link is clicked
                $(".navbar-sidenav .nav-link-collapse").click(function (e) {
                    e.preventDefault();
                    $("body").removeClass("sidenav-toggled");
                });
                // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
                $('body.fixed-nav .navbar-sidenav, body.fixed-nav .sidenav-toggler, body.fixed-nav .navbar-collapse').on('mousewheel DOMMouseScroll', function (e) {
                    var e0 = e.originalEvent,
                        delta = e0.wheelDelta || -e0.detail;
                    this.scrollTop += (delta < 0 ? 1 : -1) * 30;
                    e.preventDefault();
                });
                // Scroll to top button appear
                $(document).scroll(function () {
                    var scrollDistance = $(this).scrollTop();
                    if (scrollDistance > 100) {
                        $('.scroll-to-top').fadeIn();
                    } else {
                        $('.scroll-to-top').fadeOut();
                    }
                });
                // Configure tooltips globally
                $('[data-toggle="tooltip"]').tooltip();
                // Smooth scrolling using jQuery easing
                $(document).on('click', 'a.scroll-to-top', function (event) {
                    var $anchor = $(this);
                    $('html, body').stop().animate({
                        scrollTop: ($($anchor.attr('href')).offset().top)
                    }, 1000, 'easeInOutExpo');
                    event.preventDefault();
                });
            })(jQuery); // End of use strict
        }
    });
});


//Home Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceHome', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    return service;
});


app.controller('ControllerHome', function ($scope, ServiceHome, $location) {

    $scope.loggedIn = false;

    if (localStorage.getItem("token") !== null) {
        ServiceHome.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;
        })
    }

    $scope.logout = function () {
        localStorage.setItem("token", null);
    };

    $scope.checkIfAdmin = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 1) {
                    result = true;
                    break;
                }
            }


            return result;
        }
        return false;
    }

});


//Login Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceLogin', function ($http) {
    var service = {};

    service.login = function (user) {
        return $http.post(rest + "/users/login", user)
    };

    return service;
});


app.controller('ControllerLogin', function ($scope, ServiceLogin, $location) {

    $scope.loginUser = function () {
        ServiceLogin.login($scope.user).then(function (response) {
            localStorage.setItem("token", response.data.token);
            $location.path("/")
        }, function () {
            alert("Incorrect credentials or unactivated/suspended/blocked account. Please try again.")
        })
    }

});

//Register Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceRegister', function ($http) {
    var service = {};

    service.getAllCountries = function () {
        return $http.get(rest + "/country");
    };

    service.getCountryById = function (id) {
        return $http.get(rest + "/country/" + id);
    };

    service.register = function (user) {
        return $http.post(rest + "/users/register", user)
    };

    return service;
});


app.controller('ControllerRegister', function ($scope, ServiceRegister, $location) {

    ServiceRegister.getAllCountries().then(function (response) {
        $scope.countries = response.data;
    });

    $scope.registerUser = function () {
        $scope.loading = true;
        var user = $scope.user;
        if (!checkPass()) {
            alert("Passwords don't match");
            $scope.loading = false;
            return;
        }

        if (user.country == null) {
            user.country = null;

            ServiceRegister.register(user).then(function (response) {
                alert("We have sent you an activation mail.\n Please activate your account before using it.");
                $location.path("/")
            }, function () {
                alert("User with that username already exists!");
            })
        } else {
            ServiceRegister.getCountryById(user.country).then(function (response) {
                user.country = response.data;

                ServiceRegister.register(user).then(function (response) {
                    alert("We have sent you an activation mail.\n Please activate your account before using it.");
                    $location.path("/")
                }, function () {
                    alert("User with that username already exists!");
                })
            }, function () {
                alert("Unrecognized country!");
            });
        }

        $scope.loading = false;
    }
});

function checkPass() {
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('password');
    var pass2 = document.getElementById('passwordConfirm');

    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field
    //and the confirmation field
    if (pass1.value === pass2.value) {
        //The passwords match.
        //Set the color to the good color and inform
        //the user that they have entered the correct password
        pass2.style.backgroundColor = goodColor;
        return true;
    } else {
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.backgroundColor = badColor;
        return false;
    }
}


//AdminPanel Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanel', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    return service;
});

app.controller('ControllerAdminPanel', function ($scope, ServiceAdminPanel, $location) {

    $scope.loggedIn = false;

    $scope.checkIfAdmin = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 1) {
                    result = true;
                    break;
                }
            }


            return result;
        }
        return false;
    };

    $scope.logout = function () {
        localStorage.setItem("token", null);
        $location.path("/")
    };

    if (localStorage.getItem("token") !== null) {
        ServiceAdminPanel.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        })
    }
});

//AdminPanel Tables Admins Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesAdmins', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getAdmins = function () {
        return $http.get(rest + "/users/admins", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.deleteAdmin = function (admin) {
        return $http.delete(rest + "/users/admins",{data: admin, headers: {'Authorization': 'Bearer ' + localStorage.getItem("token"),'Content-Type':'application/json'}});
    };

    return service;
});


app.controller('ControllerAdminPanelTablesAdmins', function ($scope, NgTableParams, ServiceAdminPanelTablesAdmins, $location) {

    $scope.loggedIn = false;
    $scope.edit = false;
    $scope.view = false;
    $scope.delete = false;

    $scope.checkIfAdmin = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 1) {
                    result = true;
                    break;
                }
            }


            return result;
        }
        return false;
    };

    $scope.logout = function () {
        localStorage.setItem("token", null);
        $location.path("/")
    };

    if (localStorage.getItem("token") !== null) {
        ServiceAdminPanelTablesAdmins.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });

        ServiceAdminPanelTablesAdmins.getAdmins().then(function (response) {
            let data = response.data;
            for (let i = 0; i < data.length; i++) {
                data[i].niceCountryName = ""; //initialization of new property

                data[i].passwordChange = data[i].passwordChange ? "Yes" : "No";
                data[i].suspended = data[i].suspended ? "Yes" : "No";
                data[i].activated = data[i].activated ? "Yes" : "No";
                data[i].blocked = data[i].blocked ? "Yes" : "No";

                if (data[i].country !== null)
                    data[i].niceCountryName = data[i].country.niceName;  //set the data from nested obj into new property
            }
            $scope.tableParams = new NgTableParams({}, {dataset: data});
            $scope.edit = true;
            $scope.delete = true;
            $scope.lastSync = "Last Sync: " + new Date().toLocaleString();
        })
    }

    $scope.editClick = function (user) {
        //Handle edit user
    };

    $scope.viewClick = function (user) {
        //Handle
    };

    $scope.deleteClick = function (user) {
        //Handle
        $scope.selectedAdmin = user;
    };

    $scope.doDelete = function (){
        let user = {};
        Object.assign(user,$scope.selectedAdmin);
        user.passwordChange = user.passwordChange === "Yes";
        user.suspended = user.suspended === "Yes";
        user.activated = user.activated === "Yes";
        user.blocked = user.blocked === "Yes";
        delete user.niceCountryName;
        ServiceAdminPanelTablesAdmins.deleteAdmin(user).then(function () {
            window.location.reload(false);
        }, function () {
            alert("There was an error while deleting admin.");
        })
    };

    $scope.addClick = function () {
        $location.path("/adminPanel/tables/admins/add")
    }


});


/AdminPanel Tables Admins Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesAdminsAdd', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };


    return service;
});


app.controller('ControllerAdminPanelTablesAdminsAdd', function ($scope, NgTableParams, ServiceAdminPanelTablesAdminsAdd, $location) {

    $scope.checkIfAdmin = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 1) {
                    result = true;
                    break;
                }
            }


            return result;
        }
        return false;
    };

    $scope.logout = function () {
        localStorage.setItem("token", null);
        $location.path("/")
    };

    if (localStorage.getItem("token") !== null) {
        ServiceAdminPanelTablesAdminsAdd.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    }



});
