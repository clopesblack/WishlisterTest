define(['appModule'],function(moduleName) {

    angular.module(moduleName)
        .controller('MenuCtrl', ['$scope', function($scope) {
        }])

        .component('wishMenu', {
            templateUrl: "components/menu.html",
            controller: 'MenuCtrl'
        });

});