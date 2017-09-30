define(['appModule'],function(moduleName) {

    angular.module(moduleName)

        .controller('HeaderCtrl',  [function() {

            this.userInfo = "User Test";
        }])

        .component('wishHeader', {
            templateUrl: "components/header.html",
            controller: 'HeaderCtrl'
        });

});