define(['appModule'],function(moduleName) {
    angular.module(moduleName)

        .config(['$stateProvider', function($stateProvider) {
            $stateProvider.state('login', {
                url: '/login',
                templateUrl: 'components/login.html',
                controller: 'LoginController'
            });
        }])

        .controller('LoginController', ['$scope', '$http', function($scope, $http) {

            var self = this;

        }]);//Controller
});