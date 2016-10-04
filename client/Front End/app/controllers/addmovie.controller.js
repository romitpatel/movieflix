(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('AddMovieController',AddMovieController);

    AddMovieController.$inject = ['movieService','$location']

    function AddMovieController(movieService,$location){
        var movieVm = this;

        addMovieVm.create = addMovie;

        init();

        function init() {
            console.log('in AddMovieController');
        }

        function addMovie() {

            console.log(addMovieVm.newMovie)
            titleService
                .create(addMovieVm.newMovie)
                .then(function(data) {
                    $location.path('/movie');
                }, function(error) {
                    console.log(error);
                })
        }

    }
})();
