(function() {
    'use strict';

    angular
        .module('myAppAdmin', [])
        .controller('myAppController', myAppController);

    myAppController.$inject = ['$http'];

    function myAppController($http) {
        var vm = this;
        vm.content = [];
        vm.contents = [];
        vm.columns = [];
        vm.no_of_columns = vm.columns.length;
        vm.getAllUsers = getAllUsers;
        vm.getAllContents = getAllContents;
        vm.getUser = getUser;
        vm.removeUser = removeUser;
        vm.removeContent = removeContent;
        vm.getContent = getContent;


        init();

        function init() {
            getAllUsers();
        }



        function getAllUsers() {
            var url = "/login/admin/users/all";
            var usersURL = $http.get(url);
            usersURL.then(function(response) {
                vm.columns = ["User Name", "Email ID", "Phone Number", "Content Watched","Delete User"];
                vm.no_of_columns = vm.columns.length;
                vm.contents = response.data;
                console.log('got all users');
            });
        }

        function getAllContents() {
            var url = "/login/admin/contents";
            var contentsURL = $http.get(url);
            contentsURL.then(function(response) {
                vm.columns = ["Name", "Year", "Runtime", "Genre", "Ratings", "Cover Image", "Category","Hotstar","Amazon Prime","Netflix","Edit","Delete"];
                vm.no_of_columns = vm.columns.length;
                vm.contents = response.data;
                console.log('got all contents');
            })
        }

        function getUser(id) {
            var url = "/login/admin/user/" + id;
            var userURL = $http.get(url);
            userURL.then(function(response) {
                vm.usersColumns = ["User Name", "Email ID", "Phone Number", "Content Watched"]
                vm.users = response.data;
            })
        }

        function removeUser(id) {
            var url = "/login/admin/remove/user/" + id;
            var userURL = $http.get(url);
            userURL.then(function(response) {
                vm.columns = ["User Name", "Email ID", "Phone Number", "Content Watched","Delete User"];
                vm.no_of_columns = vm.columns.length;
                vm.contents = response.data;
                console.log('got all users');
            })
        }
        
        function removeContent(id) {
            var url = "/login/admin/remove/content/" + id;
            var userURL = $http.get(url);
            userURL.then(function(response) {
                vm.columns = ["Name", "Year", "Runtime", "Genre", "Ratings", "Cover Image", "Category","Hotstar","Amazon Prime","Netflix","Edit","Delete"];
                vm.no_of_columns = vm.columns.length;
                vm.contents = response.data;
                console.log('got all contents');
            })
        }
        
        function getContent(id){
            var url = "/login/admin/get/content/" + id;
            var userURL = $http.get(url);
            userURL.then(function(response) {
                vm.content = response.data;
            })
        }
        
        
        



    }
})();