(function() {
    'use strict';

    angular
        .module('userApp', [])
        .controller('userAppController', userAppController);

    userAppController.$inject = ['$scope','$http'];

    function userAppController($scope,$http) {
        var vm = this;
        vm.id = 0;
        vm.contents = [];
        vm.content = [];
        vm.getAllContents = getAllContents;
       	vm.getContent = getContent;
        var userId = document.getElementById("userId").value;
        //console.log(userId);
        init();

        function init() {
            getAllContents();
        }
        

        function getAllContents() {
        	var url;
        	if(userId)
        	{
        		url = "/login/admin/contentsForUser/" + userId;
            }else
            {
            	url = "/login/admin/contents";
            }
            var contentsURL = $http.get(url);
            contentsURL.then(function(response) {
                vm.contents = response.data;
            })
       } 
       
       
       function getContent(ele){
       		console.log(ele);
       		var id = ele.currentTarget.id;
       		console.log(id);
       		vm.id = id;
            
        }
           
	}
})();
