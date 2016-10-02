(function () {
    'use strict';

    angular
        .module('ScoresManager')
        .config(config);

    function config($routeProvider) {
        $routeProvider
            .when('/',
            {
                controller: 'gamesController',
                templateUrl: urlBase + 'games/games.html',
                controllerAs: 'viewModel'
            })
            .when('/addGame',
            {
                controller: 'addGameController',
                templateUrl: urlBase + 'addGame/addGame.html',
                controllerAs: 'viewModel'
            })
            .when('/editGame/:id',
            {
                controller: 'editGameController',
                templateUrl: urlBase + 'editGame/editGame.html',
                controllerAs: 'viewModel'
            })
            .otherwise({ redirectTo: '/' });
    }
})();