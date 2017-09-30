define(['appModule', 'startup/routes', 'components'], function(moduleName) {
    angular.element(document).ready(function () {

        angular.bootstrap(document, [moduleName]);
    });

});