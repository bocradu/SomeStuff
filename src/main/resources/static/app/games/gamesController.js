(function () {
    'use strict';

    angular
            .module('ScoresManager')
            .controller('gamesController', gamesController);

    gamesController.$inject = ['$http', 'orderByFilter'];


    function gamesController($http, orderByFilter) {
        var viewModel = this;
        viewModel.init = init;
        viewModel.sortBy = sortBy;
        viewModel.deleteGame = deleteGame;
        viewModel.games = [];
        viewModel.propertyName = 'game';
        viewModel.reverse = true;
        viewModel.games = orderByFilter(viewModel.games, viewModel.propertyName, viewModel.reverse);


        function init() {
            $http.get('games')
                    .success(function (response) {
                        viewModel.games = orderByFilter(response, viewModel.propertyName, viewModel.reverse);
                    });
        }

        function deleteGame(game) {
            $http({
                method: 'DELETE',
                url: 'games/' + game.id,
                data: game, // pass in data as strings
                headers: {'Content-Type': 'application/json'}
            })
                    .success(function () {
                        var index = viewModel.games.indexOf(game);
                        viewModel.games.splice(index, 1);
                        viewModel.games = orderByFilter(viewModel.games, viewModel.propertyName, viewModel.reverse);
                    });
        }

        function sortBy(propertyName) {
            viewModel.reverse = (propertyName !== null && viewModel.propertyName === propertyName)
                    ? !viewModel.reverse : false;
            viewModel.propertyName = propertyName;
            viewModel.games = orderByFilter(viewModel.games, viewModel.propertyName, viewModel.reverse);
        }
    }
})();

