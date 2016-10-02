(function () {
    'use strict';

    angular
        .module('ScoresManager')
        .controller('gamesController', gamesController);
  
    gamesController.$inject = ['$http'];
  

    function gamesController($http) {
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

