(function () {
    'use strict';

    angular
        .module('ScoresManager', ['ngRoute', 'ngMessages']);
    angular
        .module('ScoresManager')
        .run(run);

    function run($rootScope, $location) {
        $rootScope.$on('$locationChangeStart', function() {
            $rootScope.location = $location.path();
        });
    }
})();



