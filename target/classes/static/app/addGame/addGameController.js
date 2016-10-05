(function () {
    'use strict';

    angular
        .module('ScoresManager')
        .controller('addGameController', addGameController);
  
    addGameController.$inject = ['$http','$location'];
  

    function addGameController($http,$location) {
        var viewModel = this;
        viewModel.save = save;        

        function save() {
            viewModel.game.scorePlayerOne.game=viewModel.game.game;
            viewModel.game.scorePlayerTwo.game=viewModel.game.game;
            $http({
                method: 'POST',
                url: 'games',
                data: viewModel.game,  // pass in data as strings
                headers: { 'Content-Type': 'application/json' }
            })
           .success(function () {
                   $location.path('/');
           });
        }
        
    }
})();