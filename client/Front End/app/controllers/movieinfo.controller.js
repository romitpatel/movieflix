(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('MovieInfoController',MovieInfoController);

    MovieInfoController.$inject = ['movieService','$routeParams'];

    function MovieInfoController(movieService,routeParams){


        var movieInfoVm = this;

        init();

        function init() {
            movieService
                .findOne($routeParams.id)
                .then(function(data) {
                    movieVm.movie = data;
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();