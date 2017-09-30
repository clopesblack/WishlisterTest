define(['appModule'], function(moduleName) {
    angular
        .module(moduleName)
        .config(['$stateProvider', '$urlRouterProvider', routeConfig]);

    function routeConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');
    }
});