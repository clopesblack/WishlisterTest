define([], function(require){
    var moduleName = 'wish';
    angular
        .module(moduleName, [
            'ui.router'
        ]);
    return moduleName;
});