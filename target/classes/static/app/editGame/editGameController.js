(function () {
    'use strict';

    angular
        .module('ScoresManager')
        .controller('editGameController', editgameController);
  
    editgameController.$inject = ['$http'];
  

    function editgameController($http) {
        var viewModel = this;
        viewModel.init = init;
        viewModel.games = {};
        
        function init() {
            $http.get('games')
            .success(function (response) {
                viewModel.games = response;
                
            });
        }
    }
})();

