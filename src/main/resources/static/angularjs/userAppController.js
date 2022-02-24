(function() {
    'use strict';

    angular
        .module('userApp', [])
        .controller('userAppController', userAppController);

    userAppController.$inject = ['$http'];

    function userAppController($http) {
        var vm = this;
        vm.contents = [];
        vm.getAllContents = getAllContents;
        
        init();

        function init() {
            getAllContents();
        }
        

        function getAllContents() {
            var url = "/login/admin/contents";
            var contentsURL = $http.get(url);
            contentsURL.then(function(response) {
                vm.contents = response.data;
            })
        }
    }
    
})();

