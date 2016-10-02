(function () {
    'use strict';

    angular
        .module('ScoresManager')
        .controller('menuController', menuController);

    function menuController() {
        var viewModel = this;
        viewModel.init = init;
        
        function init() {
            viewModel.pages = [
                { title: 'Jobs', url: "#/jobs" },
                { title: 'Timeline', url: "#/timelines" },
                { title: 'Contact Requests', url: "#/contactRequests" }
            ];
        }

        
    }
})();
