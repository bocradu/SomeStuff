(function () {
    'use strict';

    angular
            .module('ScoresManager')
            .controller('editGameController', editgameController);

    editgameController.$inject = ['$http', '$location','$routeParams'];


    function editgameController($http, $location,$routeParams) {
        var viewModel = this;
        viewModel.init = init;
        viewModel.save = save;
        viewModel.game = {};

        function init() {
            $http.get('games/'+$routeParams.id)
                    .success(function (response) {
                        viewModel.game = response;

                    });
        }

        function save() {
            viewModel.game.scorePlayerOne.game = viewModel.game.game;
            viewModel.game.scorePlayerTwo.game = viewModel.game.game;
            $http({
                method: 'PUT',
                url: 'games/'+$routeParams.id,
                data: viewModel.game, // pass in data as strings
                headers: {'Content-Type': 'application/json'}
            })
                    .success(function () {
                        $location.path('/');
                    });
        }
    }
})();

