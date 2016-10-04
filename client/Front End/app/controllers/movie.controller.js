(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('MovieController',MovieController);

    MovieController.$inject = ['movieService'];

    function MovieController(movieService){


       var movieVm = this;

        init();

        function init() {
            movieService
                .findAll()
                .then(function(data) {
                    movieVm.movies = data;
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();