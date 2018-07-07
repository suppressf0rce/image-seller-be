var app = angular.module('ImageSeller', ['ngRoute', 'ngTable']);

rest = "http://localhost:8080/ImageSeller/rest";

app.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "content/home.html",
            controller: 'ControllerHome'
        })

        .when("/pricing", {
            templateUrl: "content/pricing.html",
            controller: 'ControllerPricing'
        })

        .when("/exam/:userID", {
            templateUrl: "content/exam.html",
            controller: 'ControllerExam'
        })

        .when("/resetPasswordRequest", {
            templateUrl: "content/reset_password_request.html",
            controller: 'ControllerPasswordResetRequest'
        })

        .when("/reset/:requestID", {
            templateUrl: "content/password_reset.html",
            controller: 'ControllerPasswordReset'
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
            templateUrl: "content/admin_panel/admin_panel.html",
            controller: 'ControllerAdminPanel'
        })

        .when("/adminPanel/tables/admins", {
            templateUrl: "content/admin_panel/table_admins.html",
            controller: 'ControllerAdminPanelTablesAdmins'
        })

        .when("/adminPanel/tables/admins/add", {
            templateUrl: "content/admin_panel/admins_add.html",
            controller: 'ControllerAdminPanelTablesAdminsAdd'
        })

        .when("/adminPanel/tables/admins/edit/:id", {
            templateUrl: "content/admin_panel/admins_edit.html",
            controller: 'ControllerAdminPanelTablesAdminsEdit'
        })

        //
        .when("/adminPanel/tables/operators", {
            templateUrl: "content/admin_panel/table_operators.html",
            controller: 'ControllerAdminPanelTablesOperators'
        })

        .when("/adminPanel/tables/operators/add", {
            templateUrl: "content/admin_panel/operators_add.html",
            controller: 'ControllerAdminPanelTablesOperatorsAdd'
        })

        .when("/adminPanel/tables/operators/edit/:id", {
            templateUrl: "content/admin_panel/admins_edit.html",
            controller: 'ControllerAdminPanelTablesAdminsEdit'
        })

        //

        .when("/adminPanel/tables/sellers", {
            templateUrl: "content/admin_panel/table_sellers.html",
            controller: 'ControllerAdminPanelTablesSellers'
        })

        .when("/adminPanel/tables/sellers/add", {
            templateUrl: "content/admin_panel/sellers_add.html",
            controller: 'ControllerAdminPanelTablesSellersAdd'
        })

        .when("/adminPanel/tables/sellers/edit/:id", {
            templateUrl: "content/admin_panel/admins_edit.html",
            controller: 'ControllerAdminPanelTablesAdminsEdit'
        })

        //

        .when("/adminPanel/tables/users", {
            templateUrl: "content/admin_panel/table_users.html",
            controller: 'ControllerAdminPanelTablesUsers'
        })

        .when("/adminPanel/tables/users/add", {
            templateUrl: "content/admin_panel/users_add.html",
            controller: 'ControllerAdminPanelTablesUsersAdd'
        })

        .when("/adminPanel/tables/users/edit/:id", {
            templateUrl: "content/admin_panel/admins_edit.html",
            controller: 'ControllerAdminPanelTablesAdminsEdit'
        })


        //
        .when("/adminPanel/tables/countries", {
            templateUrl: "content/admin_panel/table_countries.html",
            controller: 'ControllerAdminPanelTablesCountries'
        })

        .when("/adminPanel/tables/countries/add", {
            templateUrl: "content/admin_panel/country_add.html",
            controller: 'ControllerAdminPanelTablesCountryAdd'
        })

        .when("/adminPanel/tables/countries/edit/:id", {
            templateUrl: "content/admin_panel/country_edit.html",
            controller: 'ControllerAdminPanelTablesCountryEdit'
        })

        //
        .when("/adminPanel/tables/categories", {
            templateUrl: "content/admin_panel/table_categories.html",
            controller: 'ControllerAdminPanelTablesCategories'
        })

        .when("/adminPanel/tables/categories/add", {
            templateUrl: "content/admin_panel/category_add.html",
            controller: 'ControllerAdminPanelTablesCategoryAdd'
        })

        .when("/adminPanel/tables/categories/edit/:id", {
            templateUrl: "content/admin_panel/category_edit.html",
            controller: 'ControllerAdminPanelTablesCategoryEdit'
        })

        //
        .when("/adminPanel/tables/resolutions", {
            templateUrl: "content/admin_panel/table_resolutions.html",
            controller: 'ControllerAdminPanelTablesResolutions'
        })

        .when("/adminPanel/tables/resolutions/add", {
            templateUrl: "content/admin_panel/resolution_add.html",
            controller: 'ControllerAdminPanelTablesResolutionsAdd'
        })

        .when("/adminPanel/tables/resolutions/edit/:id", {
            templateUrl: "content/admin_panel/resolution_edit.html",
            controller: 'ControllerAdminPanelTablesResolutionsEdit'
        })


        //Operator Panel//
        //------------------------------------------------------------------------------------------------------------//
        .when("/operatorPanel", {
            templateUrl: "content/operator_panel/operator_panel.html",
            controller: 'ControllerOperatorPanel'
        })

        .when("/operatorPanel/tables/users", {
            templateUrl: "content/operator_panel/table_users.html",
            controller: 'ControllerOperatorPanelTablesUsers'
        })

        .when("/operatorPanel/tables/sellers", {
            templateUrl: "content/operator_panel/table_sellers.html",
            controller: 'ControllerOperatorPanelTablesSellers'
        })

        .otherwise({
            redirectTo: "/"
        });
});

app.filter('range', function () {
    return function (input, total) {
        total = parseInt(total);
        for (var i = 0; i < total; i++)
            input.push(i);
        return input;
    };
});

app.directive('appFilereader', function($q) {
    var slice = Array.prototype.slice;

    return {
        restrict: 'A',
        require: '?ngModel',
        link: function(scope, element, attrs, ngModel) {
            if (!ngModel) return;

            ngModel.$render = function() {};

            element.bind('change', function(e) {
                var element = e.target;

                $q.all(slice.call(element.files, 0).map(readFile))
                    .then(function(values) {
                        if (element.multiple) ngModel.$setViewValue(values);
                        else ngModel.$setViewValue(values.length ? values[0] : null);
                    });

                function readFile(file) {
                    var deferred = $q.defer();

                    var reader = new FileReader();
                    reader.onload = function(e) {
                        deferred.resolve(e.target.result);
                    };
                    reader.onerror = function(e) {
                        deferred.reject(e);
                    };
                    reader.readAsDataURL(file);

                    return deferred.promise;
                }

            }); //change

        } //link
    }; //return
});

app.run(function ($rootScope) {
    $rootScope.$on("$includeContentLoaded", function (event, templateName) {
        //Other JQuery Functionality
        if (templateName === "content/admin_panel/admin_panel_footer.html" || templateName === "content/operator_panel/operator_panel_footer.html") {
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

    service.getResetLink = function () {
        return $http.get(rest + "/users/reset", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getCategories = function () {
        return $http.get(rest + "/category", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.updateUser = function (user) {
        return $http.put(rest + "/users/", user, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerHome', function ($scope, ServiceHome, $location) {

    $scope.loggedIn = false;

    if (localStorage.getItem("token") !== null) {
        ServiceHome.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            if ($scope.loggedUser.passwordChange) {
                ServiceHome.getResetLink().then(function (response) {
                    $location.path("/reset/" + response.data.requestID)
                })
            }
        })
    }

    $scope.logout = function () {
        localStorage.setItem("token", null);
        window.location.reload(false);
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
    };

    $scope.checkIfOperator = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 2) {
                    result = true;
                    break;
                }
            }


            return result;
        }
        return false;
    };

    $scope.checkIfSeller = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 3) {
                    result = true;
                    break;
                }
            }


            return result;
        }
        return false;
    };

    $scope.checkIfUser = function () {
        if ($scope.loggedIn) {

            let result = true;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                result = false;
            }


            return result;
        }
        return false;
    };

    $scope.changePassword = function () {
        ServiceHome.getResetLink().then(function (response) {
            $location.path("/reset/" + response.data.requestID)
        })
    };

    $scope.suspend = function () {
        $scope.loggedUser.suspended = true;
        ServiceHome.updateUser($scope.loggedUser).then(function (response) {
            localStorage.setItem("token", null);
            window.location.reload(false);
        })
    };

    ServiceHome.getCategories().then(function (response) {
        $scope.categories = response.data;
    })
});


//Pricing Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServicePricing', function ($http) {
    var service = {};


    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getResetLink = function () {
        return $http.get(rest + "/users/reset", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getResolutions = function () {
        return $http.get(rest + "/resolution", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.updateUser = function (user) {
        return $http.put(rest + "/users/", user, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});

app.controller('ControllerPricing', function ($scope, ServicePricing, $location) {
    $scope.loggedIn = false;

    if (localStorage.getItem("token") !== null) {
        ServicePricing.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            if ($scope.loggedUser.passwordChange) {
                ServicePricing.getResetLink().then(function (response) {
                    $location.path("/reset/" + response.data.requestID)
                })
            }
        })
    }

    $scope.logout = function () {
        localStorage.setItem("token", null);
        window.location.reload(false);
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
    };

    $scope.checkIfOperator = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 2) {
                    result = true;
                    break;
                }
            }


            return result;
        }
        return false;
    };

    $scope.checkIfSeller = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 3) {
                    result = true;
                    break;
                }
            }


            return result;
        }
        return false;
    };

    $scope.checkIfUser = function () {
        if ($scope.loggedIn) {

            let result = true;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                result = false;
            }


            return result;
        }
        return false;
    };

    $scope.changePassword = function () {
        ServicePricing.getResetLink().then(function (response) {
            $location.path("/reset/" + response.data.requestID)
        })
    };

    $scope.suspend = function () {
        $scope.loggedUser.suspended = true;
        ServiceHome.updateUser($scope.loggedUser).then(function (response) {
            localStorage.setItem("token", null);
            window.location.reload(false);
        })
    };

    $scope.seeImages = function (resolution) {
        //TODO: Filter Images
        alert("Implement this filter for resolution: " + resolution.description)
    };


    ServicePricing.getResolutions().then(function (response) {
        $scope.resolutions = response.data;
        $scope.num = Math.ceil($scope.resolutions.length / 3)
    })
});


//Exam Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceExam', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getResetLink = function () {
        return $http.get(rest + "/users/reset", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getCategories = function () {
        return $http.get(rest + "/category", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.updateUser = function (user) {
        return $http.put(rest + "/users/", user, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    service.checkIfCanDoExam = function(){
        return $http.get(rest + "/exam", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.doExam = function (images) {
        return $http.post(rest + "/exam", images, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    return service;
});


app.controller('ControllerExam', function ($scope, ServiceExam, $location, $routeParams) {

    $scope.loggedIn = false;

    if (localStorage.getItem("token") !== null) {
        ServiceExam.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            if ($scope.loggedUser.passwordChange) {
                ServiceExam.getResetLink().then(function (response) {
                    $location.path("/reset/" + response.data.requestID)
                })
            }

            if(!$scope.checkIfUser())
                $location.path("/");

            if($scope.loggedUser.id != $routeParams.userID)
                $location.path("/");

            ServiceExam.checkIfCanDoExam().then(function (re) {

            }, function () {
                alert("You have pending exams for review!");
                $location.path("/")
            })

        }, function () {
            $location.path("/")
        })
    }else{
        $location.path("/")
    }

    $scope.logout = function () {
        localStorage.setItem("token", null);
        window.location.reload(false);
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
    };

    $scope.checkIfOperator = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 2) {
                    result = true;
                    break;
                }
            }


            return result;
        }
        return false;
    };

    $scope.checkIfSeller = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 3) {
                    result = true;
                    break;
                }
            }


            return result;
        }
        return false;
    };

    $scope.checkIfUser = function () {
        if ($scope.loggedIn) {

            let result = true;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                result = false;
            }


            return result;
        }
        return false;
    };

    $scope.changePassword = function () {
        ServiceExam.getResetLink().then(function (response) {
            $location.path("/reset/" + response.data.requestID)
        })
    };

    $scope.suspend = function () {
        $scope.loggedUser.suspended = true;
        ServiceExam.updateUser($scope.loggedUser).then(function (response) {
            localStorage.setItem("token", null);
            window.location.reload(false);
        })
    };

    ServiceExam.getCategories().then(function (response) {
        $scope.categories = response.data;
    });

    $(document).ready(function () {

        var navListItems = $('div.setup-panel div a'),
            allWells = $('.setup-content'),
            allNextBtn = $('.nextBtn');

        allWells.hide();

        navListItems.click(function (e) {
            e.preventDefault();
            var $target = $($(this).attr('href')),
                $item = $(this);

            if (!$item.hasClass('disabled')) {
                navListItems.removeClass('btn-primary').addClass('btn-default');
                $item.addClass('btn-primary');
                allWells.hide();
                $target.show();
                $target.find('input:eq(0)').focus();
            }
        });

        allNextBtn.click(function () {
            var curStep = $(this).closest(".setup-content"),
                curStepBtn = curStep.attr("id"),
                nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
                curInputs = curStep.find("input[type='text'],input[type='url']"),
                isValid = true;

            $(".form-group").removeClass("has-error");
            for (var i = 0; i < curInputs.length; i++) {
                if (!curInputs[i].validity.valid) {
                    isValid = false;
                    $(curInputs[i]).closest(".form-group").addClass("has-error");
                }
            }

            if (isValid) {
                nextStepWizard.removeAttr('disabled').trigger('click');
                $scope.resetValid = true;
            }else{
                console.log($scope);
                $scope.resetValid = false;
            }
        });

        $('div.setup-panel div a.btn-primary').trigger('click');


        //Image load
        $(document).on('change', '.btn-file :file', function() {
            var input = $(this),
                label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
            input.trigger('fileselect', [label]);
        });

        $('.btn-file :file').on('fileselect', function(event, label) {

            var input = $(this).parents('.input-group').find(':text'),
                log = label;

            if( input.length ) {
                input.val(log);
            } else {
                if( log ) alert(log);
            }

        });

        function readURL(input, id) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#img-upload-'+id).attr('src', e.target.result);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }

        for(let i = 0;  i < 10; i++) {
            $("#imgInp-"+(i+1)).change(function () {
                readURL(this, i+1);
            });

            $("#clear-"+(i+1)).click(function () {
                $('#img-upload-'+(i+1)).attr('src', '');
                $('#urlname-'+(i+1)).val('');
                $scope.images[i].image = ""
            });
        }

    });

    $scope.images = [];
    for(let i = 0; i < 10; i++){
        $scope.images.push(image = {})
    }

    $scope.sendTest = function () {
        console.log($scope.images);
        if($scope.examForm.$valid) {
            ServiceExam.doExam($scope.images).then(function (response) {
                alert("Exam successfully submitted");
                $location.path("/")
            }, function () {
                alert("Something went wrong! Please try again")
            })
        }
        else
            alert("Uh-Oh, There are some empty fields \nPlease check previous steps you might have missed some")
    };
});


//Password Reset Request Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServicePasswordResetRequest', function ($http) {
    var service = {};

    service.request = function (user) {
        return $http.post(rest + "/users/reset/", user)
    };

    return service;
});


app.controller('ControllerPasswordResetRequest', function ($scope, ServicePasswordResetRequest, $location) {

    $scope.sendRequest = function () {
        ServicePasswordResetRequest.request($scope.user).then(function () {
            alert("We have sent you password reset link to your mail\nPlease check it out to proceed");
            $location.path("/")
        }, function () {
            alert("Incorrect email request. Please try again.")
        })
    }

});


//Password Reset Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServicePasswordReset', function ($http) {
    var service = {};

    service.sendReset = function (user, requestID) {
        return $http.post(rest + "/users/reset/" + requestID, user)
    };

    return service;
});


app.controller('ControllerPasswordReset', function ($scope, ServicePasswordReset, $location, $routeParams) {

    $scope.resetPassword = function () {
        if (!checkPass()) {
            alert("Passwords don't match");
            return;
        }

        ServicePasswordReset.sendReset($scope.user, $routeParams.requestID).then(function (response) {
            localStorage.setItem("token", response.data.token);
            console.log(response.data);
            $location.path("/")
        }, function () {
            alert("Bad password reset request!");
            $location.path("/")
        })
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
            ServiceRegister.getCountryById(user.country.id).then(function (response) {
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
    } else {
        $location.path("/")
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
        return $http.delete(rest + "/users/admins", {
            data: admin,
            headers: {'Authorization': 'Bearer ' + localStorage.getItem("token"), 'Content-Type': 'application/json'}
        });
    };

    return service;
});


app.controller('ControllerAdminPanelTablesAdmins', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesAdmins, $location) {

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
    } else {
        $location.path("/")
    }

    $scope.editClick = function (user) {
        //Handle edit user
        $rootScope.lastReturnLink = "/adminPanel/tables/admins";
        $location.path("/adminPanel/tables/admins/edit/" + user.id);
    };

    $scope.viewClick = function (user) {
        //Handle
    };

    $scope.deleteClick = function (user) {
        //Handle
        $scope.selectedAdmin = user;
    };

    $scope.doDelete = function () {
        let user = {};
        Object.assign(user, $scope.selectedAdmin);
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


//AdminPanel Tables Admins Add Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesAdminsAdd', function ($http) {
    var service = {};

    service.getAllCountries = function () {
        return $http.get(rest + "/country");
    };

    service.getCountryById = function (id) {
        return $http.get(rest + "/country/" + id);
    };

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (user) {
        return $http.post(rest + "/users/admins", user, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
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
    } else {
        $location.path("/")
    }

    ServiceAdminPanelTablesAdminsAdd.getAllCountries().then(function (response) {
        $scope.countries = response.data;
    });

    $scope.add = function () {
        var user = $scope.user;
        if (!checkPass()) {
            alert("Passwords don't match");
            $scope.loading = false;
            return;
        }

        user.passwordChange = user.passwordChange === 'Yes';

        if (user.country == null) {
            user.country = null;

            ServiceAdminPanelTablesAdminsAdd.add(user).then(function (response) {
                $location.path("/adminPanel/tables/admins")
            }, function () {
                alert("Error while creating admin, please try again!");
            })
        } else {
            ServiceAdminPanelTablesAdminsAdd.getCountryById(user.country.id).then(function (response) {
                user.country = response.data;

                ServiceAdminPanelTablesAdminsAdd.add(user).then(function (response) {
                    $location.path("/adminPanel/tables/admins")
                }, function () {
                    alert("Error while creating admin, please try again!");
                })
            }, function () {
                alert("Unrecognized country!");
            });
        }
    };

    $scope.cancel = function () {
        $location.path("/adminPanel/tables/admins")
    }

});


//AdminPanel Tables Admins Edit Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesAdminsEdit', function ($http) {
    var service = {};

    service.getAllCountries = function () {
        return $http.get(rest + "/country");
    };

    service.getCountryById = function (id) {
        return $http.get(rest + "/country/" + id);
    };

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (user) {
        return $http.put(rest + "/users/", user, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    service.getAdmin = function (id) {
        return $http.get(rest + "/users/" + id, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerAdminPanelTablesAdminsEdit', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesAdminsEdit, $location, $routeParams) {

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
        ServiceAdminPanelTablesAdminsEdit.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    } else {
        $location.path("/")
    }

    ServiceAdminPanelTablesAdminsEdit.getAllCountries().then(function (response) {
        $scope.countries = response.data;
    });

    ServiceAdminPanelTablesAdminsEdit.getAdmin($routeParams.id).then(function (response) {
        $scope.user = response.data;
        $scope.confirmPassword = $scope.user.password;
        $scope.user.passwordChange = $scope.user.passwordChange ? 'Yes' : 'No';
        $scope.user.blocked = $scope.user.blocked ? 'Yes' : 'No';
        $scope.user.suspended = $scope.user.suspended ? 'Yes' : 'No';
        $scope.user.activated = $scope.user.activated ? 'Yes' : 'No';
    });

    $scope.add = function () {
        var user = {};
        Object.assign(user, $scope.user);
        if (!checkPass()) {
            alert("Passwords don't match");
            $scope.loading = false;
            return;
        }

        user.passwordChange = user.passwordChange === 'Yes';
        user.blocked = user.blocked === 'Yes';
        user.suspended = user.suspended === 'Yes';
        user.activated = user.activated === 'Yes';
        if (user.password === "Secret")
            delete user.password;

        if (user.country == null) {
            user.country = null;

            ServiceAdminPanelTablesAdminsEdit.add(user).then(function (response) {
                $location.path($rootScope.lastReturnLink)
            }, function () {
                alert("Error while editing admin, please try again!");
            })
        } else {
            ServiceAdminPanelTablesAdminsEdit.getCountryById(user.country.id).then(function (response) {
                user.country = response.data;

                ServiceAdminPanelTablesAdminsEdit.add(user).then(function (response) {
                    $location.path($rootScope.lastReturnLink)
                }, function () {
                    alert("Error while editing admin, please try again!");
                })
            }, function () {
                alert("Unrecognized country!");
            });
        }
    };

    $scope.cancel = function () {
        $location.path($rootScope.lastReturnLink)
    }

});


//AdminPanel Tables Operators Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesOperators', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getAdmins = function () {
        return $http.get(rest + "/users/operators", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.deleteAdmin = function (admin) {
        return $http.delete(rest + "/users/operators", {
            data: admin,
            headers: {'Authorization': 'Bearer ' + localStorage.getItem("token"), 'Content-Type': 'application/json'}
        });
    };

    return service;
});


app.controller('ControllerAdminPanelTablesOperators', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesOperators, $location) {

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
        ServiceAdminPanelTablesOperators.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });

        ServiceAdminPanelTablesOperators.getAdmins().then(function (response) {
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
    } else {
        $location.path("/")
    }

    $scope.editClick = function (user) {
        //Handle edit user
        $rootScope.lastReturnLink = "/adminPanel/tables/operators";
        $location.path("/adminPanel/tables/operators/edit/" + user.id);
    };

    $scope.viewClick = function (user) {
        //Handle
    };

    $scope.deleteClick = function (user) {
        //Handle
        $scope.selectedAdmin = user;
    };

    $scope.doDelete = function () {
        let user = {};
        Object.assign(user, $scope.selectedAdmin);
        user.passwordChange = user.passwordChange === "Yes";
        user.suspended = user.suspended === "Yes";
        user.activated = user.activated === "Yes";
        user.blocked = user.blocked === "Yes";
        delete user.niceCountryName;
        ServiceAdminPanelTablesOperators.deleteAdmin(user).then(function () {
            window.location.reload(false);
        }, function () {
            alert("There was an error while deleting admin.");
        })
    };

    $scope.addClick = function () {
        $location.path("/adminPanel/tables/operators/add")
    }


});


//AdminPanel Tables Operators Add Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesOperatorsAdd', function ($http) {
    var service = {};

    service.getAllCountries = function () {
        return $http.get(rest + "/country");
    };

    service.getCountryById = function (id) {
        return $http.get(rest + "/country/" + id);
    };

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (user) {
        return $http.post(rest + "/users/operators", user, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerAdminPanelTablesOperatorsAdd', function ($scope, NgTableParams, ServiceAdminPanelTablesOperatorsAdd, $location) {

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
        ServiceAdminPanelTablesOperatorsAdd.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    } else {
        $location.path("/")
    }

    ServiceAdminPanelTablesOperatorsAdd.getAllCountries().then(function (response) {
        $scope.countries = response.data;
    });

    $scope.add = function () {
        var user = $scope.user;
        if (!checkPass()) {
            alert("Passwords don't match");
            $scope.loading = false;
            return;
        }

        user.passwordChange = user.passwordChange === 'Yes';

        if (user.country == null) {
            user.country = null;

            ServiceAdminPanelTablesOperatorsAdd.add(user).then(function (response) {
                $location.path("/adminPanel/tables/operators")
            }, function () {
                alert("Error while creating operator, please try again!");
            })
        } else {
            ServiceAdminPanelTablesOperatorsAdd.getCountryById(user.country.id).then(function (response) {
                user.country = response.data;

                ServiceAdminPanelTablesOperatorsAdd.add(user).then(function (response) {
                    $location.path("/adminPanel/tables/operators")
                }, function () {
                    alert("Error while creating operator, please try again!");
                })
            }, function () {
                alert("Unrecognized country!");
            });
        }
    };

    $scope.cancel = function () {
        $location.path("/adminPanel/tables/operators")
    }

});


//AdminPanel Tables Sellers Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesSellers', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getAdmins = function () {
        return $http.get(rest + "/users/sellers", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.deleteAdmin = function (admin) {
        return $http.delete(rest + "/users/sellers", {
            data: admin,
            headers: {'Authorization': 'Bearer ' + localStorage.getItem("token"), 'Content-Type': 'application/json'}
        });
    };

    return service;
});


app.controller('ControllerAdminPanelTablesSellers', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesSellers, $location) {

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
        ServiceAdminPanelTablesSellers.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });

        ServiceAdminPanelTablesSellers.getAdmins().then(function (response) {
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
    } else {
        $location.path("/")
    }

    $scope.editClick = function (user) {
        //Handle edit user
        $rootScope.lastReturnLink = "/adminPanel/tables/sellers";
        $location.path("/adminPanel/tables/sellers/edit/" + user.id);
    };

    $scope.viewClick = function (user) {
        //Handle
    };

    $scope.deleteClick = function (user) {
        //Handle
        $scope.selectedAdmin = user;
    };

    $scope.doDelete = function () {
        let user = {};
        Object.assign(user, $scope.selectedAdmin);
        user.passwordChange = user.passwordChange === "Yes";
        user.suspended = user.suspended === "Yes";
        user.activated = user.activated === "Yes";
        user.blocked = user.blocked === "Yes";
        delete user.niceCountryName;
        ServiceAdminPanelTablesSellers.deleteAdmin(user).then(function () {
            window.location.reload(false);
        }, function () {
            alert("There was an error while deleting admin.");
        })
    };

    $scope.addClick = function () {
        $location.path("/adminPanel/tables/sellers/add")
    }


});

//AdminPanel Tables Sellers Add Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesSellersAdd', function ($http) {
    var service = {};

    service.getAllCountries = function () {
        return $http.get(rest + "/country");
    };

    service.getCountryById = function (id) {
        return $http.get(rest + "/country/" + id);
    };

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (user) {
        return $http.post(rest + "/users/sellers", user, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerAdminPanelTablesSellersAdd', function ($scope, NgTableParams, ServiceAdminPanelTablesSellersAdd, $location) {

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
        ServiceAdminPanelTablesSellersAdd.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    } else {
        $location.path("/")
    }

    ServiceAdminPanelTablesSellersAdd.getAllCountries().then(function (response) {
        $scope.countries = response.data;
    });

    $scope.add = function () {
        var user = $scope.user;
        if (!checkPass()) {
            alert("Passwords don't match");
            $scope.loading = false;
            return;
        }

        user.passwordChange = user.passwordChange === 'Yes';

        if (user.country == null) {
            user.country = null;

            ServiceAdminPanelTablesSellersAdd.add(user).then(function (response) {
                $location.path("/adminPanel/tables/sellers")
            }, function () {
                alert("Error while creating seller, please try again!");
            })
        } else {
            ServiceAdminPanelTablesSellersAdd.getCountryById(user.country.id).then(function (response) {
                user.country = response.data;

                ServiceAdminPanelTablesSellersAdd.add(user).then(function (response) {
                    $location.path("/adminPanel/tables/sellers")
                }, function () {
                    alert("Error while creating seller, please try again!");
                })
            }, function () {
                alert("Unrecognized country!");
            });
        }
    };

    $scope.cancel = function () {
        $location.path("/adminPanel/tables/sellers")
    }

});


//AdminPanel Tables Users Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesUsers', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getAdmins = function () {
        return $http.get(rest + "/users/", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.deleteAdmin = function (admin) {
        return $http.delete(rest + "/users/", {
            data: admin,
            headers: {'Authorization': 'Bearer ' + localStorage.getItem("token"), 'Content-Type': 'application/json'}
        });
    };

    return service;
});


app.controller('ControllerAdminPanelTablesUsers', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesUsers, $location) {

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
        ServiceAdminPanelTablesUsers.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });

        ServiceAdminPanelTablesUsers.getAdmins().then(function (response) {
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
    } else {
        $location.path("/")
    }

    $scope.editClick = function (user) {
        //Handle edit user
        $rootScope.lastReturnLink = "/adminPanel/tables/users";
        $location.path("/adminPanel/tables/users/edit/" + user.id);
    };

    $scope.viewClick = function (user) {
        //Handle
    };

    $scope.deleteClick = function (user) {
        //Handle
        $scope.selectedAdmin = user;
    };

    $scope.doDelete = function () {
        let user = {};
        Object.assign(user, $scope.selectedAdmin);
        user.passwordChange = user.passwordChange === "Yes";
        user.suspended = user.suspended === "Yes";
        user.activated = user.activated === "Yes";
        user.blocked = user.blocked === "Yes";
        delete user.niceCountryName;
        ServiceAdminPanelTablesUsers.deleteAdmin(user).then(function () {
            window.location.reload(false);
        }, function () {
            alert("There was an error while deleting admin.");
        })
    };

    $scope.addClick = function () {
        $location.path("/adminPanel/tables/users/add")
    }


});

//AdminPanel Tables Users Add Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesUsersAdd', function ($http) {
    var service = {};

    service.getAllCountries = function () {
        return $http.get(rest + "/country");
    };

    service.getCountryById = function (id) {
        return $http.get(rest + "/country/" + id);
    };

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (user) {
        return $http.post(rest + "/users", user, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerAdminPanelTablesUsersAdd', function ($scope, NgTableParams, ServiceAdminPanelTablesUsersAdd, $location) {

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
        ServiceAdminPanelTablesUsersAdd.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    } else {
        $location.path("/")
    }

    ServiceAdminPanelTablesUsersAdd.getAllCountries().then(function (response) {
        $scope.countries = response.data;
    });

    $scope.add = function () {
        var user = $scope.user;
        if (!checkPass()) {
            alert("Passwords don't match");
            $scope.loading = false;
            return;
        }

        user.passwordChange = user.passwordChange === 'Yes';

        if (user.country == null) {
            user.country = null;

            ServiceAdminPanelTablesUsersAdd.add(user).then(function (response) {
                $location.path("/adminPanel/tables/users")
            }, function () {
                alert("Error while creating user, please try again!");
            })
        } else {
            ServiceAdminPanelTablesUsersAdd.getCountryById(user.country.id).then(function (response) {
                user.country = response.data;

                ServiceAdminPanelTablesUsersAdd.add(user).then(function (response) {
                    $location.path("/adminPanel/tables/users")
                }, function () {
                    alert("Error while creating user, please try again!");
                })
            }, function () {
                alert("Unrecognized country!");
            });
        }
    };

    $scope.cancel = function () {
        $location.path("/adminPanel/tables/users")
    }

});


//AdminPanel Tables Countries Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesCountries', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getCountries = function () {
        return $http.get(rest + "/country", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.deleteCountry = function (country) {
        return $http.delete(rest + "/country", {
            data: country,
            headers: {'Authorization': 'Bearer ' + localStorage.getItem("token"), 'Content-Type': 'application/json'}
        });
    };

    return service;
});


app.controller('ControllerAdminPanelTablesCountries', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesCountries, $location) {

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
        ServiceAdminPanelTablesCountries.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });

        ServiceAdminPanelTablesCountries.getCountries().then(function (response) {
            let data = response.data;
            $scope.tableParams = new NgTableParams({}, {dataset: data});
            $scope.edit = true;
            $scope.delete = true;
            $scope.lastSync = "Last Sync: " + new Date().toLocaleString();
        })
    } else {
        $location.path("/")
    }

    $scope.editClick = function (country) {
        //Handle edit country
        $rootScope.lastReturnLink = "/adminPanel/tables/countries";
        $location.path("/adminPanel/tables/countries/edit/" + country.id);
    };

    $scope.viewClick = function (country) {
        //Handle
    };

    $scope.deleteClick = function (country) {
        //Handle
        $scope.selectedCountry = country;
    };

    $scope.doDelete = function () {
        let country = {};
        Object.assign(country, $scope.selectedCountry);
        ServiceAdminPanelTablesCountries.deleteCountry(country).then(function () {
            window.location.reload(false);
        }, function () {
            alert("There was an error while deleting country.");
        })
    };

    $scope.addClick = function () {
        $location.path("/adminPanel/tables/countries/add")
    }


});


//AdminPanel Tables Countries Add Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesCountryAdd', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (country) {
        return $http.post(rest + "/country", country, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerAdminPanelTablesCountryAdd', function ($scope, NgTableParams, ServiceAdminPanelTablesCountryAdd, $location) {

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
        ServiceAdminPanelTablesCountryAdd.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    } else {
        $location.path("/")
    }

    $scope.add = function () {
        var country = $scope.country;


        ServiceAdminPanelTablesCountryAdd.add(country).then(function (response) {
            $location.path("/adminPanel/tables/countries")
        }, function () {
            alert("Error while creating country, please try again!");
        });

        $scope.cancel = function () {
            $location.path("/adminPanel/tables/countries")
        }

    }
});


//AdminPanel Tables Admins Edit Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesCountryEdit', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (country) {
        return $http.put(rest + "/country", country, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    service.getCountry = function (id) {
        return $http.get(rest + "/country/" + id, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerAdminPanelTablesCountryEdit', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesCountryEdit, $location, $routeParams) {

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
        ServiceAdminPanelTablesCountryEdit.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    } else {
        $location.path("/")
    }

    ServiceAdminPanelTablesCountryEdit.getCountry($routeParams.id).then(function (response) {
        $scope.country = response.data;
    });

    $scope.add = function () {
        var country = {};
        Object.assign(country, $scope.country);


        ServiceAdminPanelTablesCountryEdit.add(country).then(function (response) {
            $location.path($rootScope.lastReturnLink)
        }, function () {
            alert("Error while editing country, please try again!");
        })
    };

    $scope.cancel = function () {
        $location.path($rootScope.lastReturnLink)
    }

});


//AdminPanel Tables Categories Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesCategories', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getCategories = function () {
        return $http.get(rest + "/category", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.deleteCategory = function (category) {
        return $http.delete(rest + "/category", {
            data: category,
            headers: {'Authorization': 'Bearer ' + localStorage.getItem("token"), 'Content-Type': 'application/json'}
        });
    };

    return service;
});


app.controller('ControllerAdminPanelTablesCategories', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesCategories, $location) {

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
        ServiceAdminPanelTablesCategories.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });

        ServiceAdminPanelTablesCategories.getCategories().then(function (response) {
            let data = response.data;
            $scope.tableParams = new NgTableParams({}, {dataset: data});
            $scope.edit = true;
            $scope.delete = true;
            $scope.lastSync = "Last Sync: " + new Date().toLocaleString();
        })
    } else {
        $location.path("/")
    }

    $scope.editClick = function (category) {
        //Handle edit category
        $rootScope.lastReturnLink = "/adminPanel/tables/categories";
        $location.path("/adminPanel/tables/categories/edit/" + category.id);
    };

    $scope.viewClick = function (category) {
        //Handle
    };

    $scope.deleteClick = function (category) {
        //Handle
        $scope.selectedCategory = category;
    };

    $scope.doDelete = function () {
        let category = {};
        Object.assign(category, $scope.selectedCategory);
        ServiceAdminPanelTablesCategories.deleteCategory(category).then(function () {
            window.location.reload(false);
        }, function () {
            alert("There was an error while deleting category.");
        })
    };

    $scope.addClick = function () {
        $location.path("/adminPanel/tables/categories/add")
    }


});


//AdminPanel Tables Categories Add Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesCategoryAdd', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (category) {
        return $http.post(rest + "/category", category, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerAdminPanelTablesCategoryAdd', function ($scope, NgTableParams, ServiceAdminPanelTablesCategoryAdd, $location) {

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
        ServiceAdminPanelTablesCategoryAdd.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    } else {
        $location.path("/")
    }

    $scope.add = function () {
        var category = $scope.category;


        ServiceAdminPanelTablesCategoryAdd.add(category).then(function (response) {
            $location.path("/adminPanel/tables/categories")
        }, function () {
            alert("Error while creating category, please try again!");
        });

        $scope.cancel = function () {
            $location.path("/adminPanel/tables/categories")
        }

    }
});


//AdminPanel Tables Category Edit Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesCategoryEdit', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (category) {
        return $http.put(rest + "/category", category, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    service.getCategory = function (id) {
        return $http.get(rest + "/category/" + id, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerAdminPanelTablesCategoryEdit', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesCategoryEdit, $location, $routeParams) {

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
        ServiceAdminPanelTablesCategoryEdit.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    } else {
        $location.path("/")
    }

    ServiceAdminPanelTablesCategoryEdit.getCategory($routeParams.id).then(function (response) {
        $scope.category = response.data;
    });

    $scope.add = function () {
        var category = {};
        Object.assign(category, $scope.category);


        ServiceAdminPanelTablesCategoryEdit.add(category).then(function (response) {
            $location.path($rootScope.lastReturnLink)
        }, function () {
            alert("Error while editing category, please try again!");
        })
    };

    $scope.cancel = function () {
        $location.path($rootScope.lastReturnLink)
    }

});


//AdminPanel Tables Resolution Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesResolutions', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getResolutions = function () {
        return $http.get(rest + "/resolution", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.deleteResolution = function (resolution) {
        return $http.delete(rest + "/resolution", {
            data: resolution,
            headers: {'Authorization': 'Bearer ' + localStorage.getItem("token"), 'Content-Type': 'application/json'}
        });
    };

    return service;
});


app.controller('ControllerAdminPanelTablesResolutions', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesResolutions, $location) {

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
        ServiceAdminPanelTablesResolutions.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });

        ServiceAdminPanelTablesResolutions.getResolutions().then(function (response) {
            let data = response.data;
            $scope.tableParams = new NgTableParams({}, {dataset: data});
            $scope.edit = true;
            $scope.delete = true;
            $scope.lastSync = "Last Sync: " + new Date().toLocaleString();
        })
    } else {
        $location.path("/")
    }

    $scope.editClick = function (resolution) {
        //Handle edit resolution
        $rootScope.lastReturnLink = "/adminPanel/tables/resolutions";
        $location.path("/adminPanel/tables/resolutions/edit/" + resolution.id);
    };

    $scope.viewClick = function (resolution) {
        //Handle
    };

    $scope.deleteClick = function (resolution) {
        //Handle
        $scope.selectedResolution = resolution;
    };

    $scope.doDelete = function () {
        let resoltuion = {};
        Object.assign(resoltuion, $scope.selectedResolution);
        ServiceAdminPanelTablesResolutions.deleteResolution(resoltuion).then(function () {
            window.location.reload(false);
        }, function () {
            alert("There was an error while deleting resolution.");
        })
    };

    $scope.addClick = function () {
        $location.path("/adminPanel/tables/resolutions/add")
    }


});


//AdminPanel Tables Resolutions Add Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesResolutionsAdd', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (resolution) {
        return $http.post(rest + "/resolution", resolution, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerAdminPanelTablesResolutionsAdd', function ($scope, NgTableParams, ServiceAdminPanelTablesResolutionsAdd, $location) {

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
        ServiceAdminPanelTablesResolutionsAdd.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    } else {
        $location.path("/")
    }

    $scope.add = function () {
        var resolution = $scope.resolution;


        ServiceAdminPanelTablesResolutionsAdd.add(resolution).then(function (response) {
            $location.path("/adminPanel/tables/resolutions")
        }, function () {
            alert("Error while creating resolution, please try again!");
        });

        $scope.cancel = function () {
            $location.path("/adminPanel/tables/resolutions")
        }

    }
});


//AdminPanel Tables Resolutions Edit Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceAdminPanelTablesResolutionsEdit', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.add = function (resolution) {
        return $http.put(rest + "/resolution", resolution, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    service.getResolution = function (id) {
        return $http.get(rest + "/resolution/" + id, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerAdminPanelTablesResolutionsEdit', function ($scope, $rootScope, NgTableParams, ServiceAdminPanelTablesResolutionsEdit, $location, $routeParams) {

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
        ServiceAdminPanelTablesResolutionsEdit.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfAdmin();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });
    } else {
        $location.path("/")
    }

    ServiceAdminPanelTablesResolutionsEdit.getResolution($routeParams.id).then(function (response) {
        $scope.resolution = response.data;
    });

    $scope.add = function () {
        var resolution = {};
        Object.assign(resolution, $scope.resolution);


        ServiceAdminPanelTablesResolutionsEdit.add(resolution).then(function (response) {
            $location.path($rootScope.lastReturnLink)
        }, function () {
            alert("Error while editing resolution, please try again!");
        })
    };

    $scope.cancel = function () {
        $location.path($rootScope.lastReturnLink)
    }

});


//OperatorPanel Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceOperatorPanel', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    return service;
});

app.controller('ControllerOperatorPanel', function ($scope, ServiceOperatorPanel, $location) {

    $scope.loggedIn = false;

    $scope.checkIfOperator = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 2) {
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
        ServiceOperatorPanel.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfOperator();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        })
    } else {
        $location.path("/")
    }
});


//OperatorPanel Tables Sellers Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceOperatorPanelTablesSellers', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getUsers = function () {
        return $http.get(rest + "/users/sellers", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.blockUser = function (user) {
        return $http.put(rest + "/users/block", user, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerOperatorPanelTablesSellers', function ($scope, $rootScope, NgTableParams, ServiceOperatorPanelTablesSellers, $location) {

    $scope.loggedIn = false;
    $scope.edit = false;
    $scope.view = true;
    $scope.delete = false;

    $scope.checkIfOperator = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 2) {
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
        ServiceOperatorPanelTablesSellers.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfOperator();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });

        ServiceOperatorPanelTablesSellers.getUsers().then(function (response) {
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
            $scope.view = true;
            $scope.lastSync = "Last Sync: " + new Date().toLocaleString();
        })
    } else {
        $location.path("/")
    }

    $scope.editClick = function (user) {
        //Handle edit user
    };

    $scope.viewClick = function (user) {
        //Handle
        $scope.selectedUser = user;
    };

    $scope.deleteClick = function (user) {
        //Handle
    };

    $scope.doBlock = function () {
        let user = {};
        user.id = $scope.selectedUser.id;
        ServiceOperatorPanelTablesSellers.blockUser(user).then(function (response) {
            window.location.reload(false);
        }, function () {
            alert("Error has occurred while trying to block user");
        })
    };

    $scope.addClick = function () {
        //Handles
    }


});


//OperatorPanel Tables Users Page//
//--------------------------------------------------------------------------------------------------------------------//
app.factory('ServiceOperatorPanelTablesUsers', function ($http) {
    var service = {};

    service.getAuthUser = function () {
        return $http.get(rest + "/users/token", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.getUsers = function () {
        return $http.get(rest + "/users", {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}});
    };

    service.blockUser = function (user) {
        return $http.put(rest + "/users/block", user, {headers: {'Authorization': 'Bearer ' + localStorage.getItem("token")}})
    };

    return service;
});


app.controller('ControllerOperatorPanelTablesUsers', function ($scope, $rootScope, NgTableParams, ServiceOperatorPanelTablesUsers, $location) {

    $scope.loggedIn = false;
    $scope.edit = false;
    $scope.view = true;
    $scope.delete = false;

    $scope.checkIfOperator = function () {
        if ($scope.loggedIn) {

            let result = false;
            for (let i = 0; i < $scope.loggedUser.types.length; i++) {
                if ($scope.loggedUser.types[i].id === 2) {
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
        ServiceOperatorPanelTablesUsers.getAuthUser().then(function (response) {
            $scope.loggedUser = response.data;
            $scope.loggedIn = true;

            $scope.loggedIn = $scope.checkIfOperator();

            if (!$scope.loggedIn) {
                $location.path("/")
            }
        }, function () {
            $location.path("/")
        });

        ServiceOperatorPanelTablesUsers.getUsers().then(function (response) {
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
            $scope.view = true;
            $scope.lastSync = "Last Sync: " + new Date().toLocaleString();
        })
    } else {
        $location.path("/")
    }

    $scope.editClick = function (user) {
        //Handle edit user
    };

    $scope.viewClick = function (user) {
        //Handle
        $scope.selectedUser = user;
    };

    $scope.deleteClick = function (user) {
        //Handle
    };

    $scope.doBlock = function () {
        let user = {};
        user.id = $scope.selectedUser.id;
        ServiceOperatorPanelTablesUsers.blockUser(user).then(function (response) {
            window.location.reload(false);
        }, function () {
            alert("Error has occurred while trying to block user");
        })
    };

    $scope.addClick = function () {
        //Handle
    }


});
