(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('TopRatedMovieController',TopRatedMovieController)

    TopRatedMovieController.$inject = ['movieService']

    function TopRatedMovieController(movieService){
        var topRatedMovieVm = this;

        init();
        function init() {
            console.log('inside Top Rated Movie Controller');
            movieService
                .findTopRatedMovie()
                .then(function (data) {
                    topRatedMovieVm.movies = data;
                },function (error) {
                    console.log(error);
                })

        }
    }

})();
