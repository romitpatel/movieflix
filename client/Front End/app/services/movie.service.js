(function() {
    'use strict';

    angular.module('movieflix')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q','CONFIG'];

    function movieService($http, $q, CONFIG) {
        var self = this;

        self.findAll = getMovies;
        self.findOne = getMovie;
        self.create =  postMovie;
        self.findTopRatedTv = getTv;
        self.findTopRatedMovie = getMovie;

        function getMovies() {
            return $http
                .get(CONFIG.API_HOST + '/movie')
                .then(function(response) {
                    return response.data;
                }, function(error) {
                    return $q.reject(error);
                });
        }

        function getMovie() {
            return $http
                .get(CONFIG.API_HOST +'/movie/{id}')
                .then(successFn,errorFn);

        }

        function postMovie(movie) {
            return $http.post(CONFIG.API_HOST + '/movie', movie)
                .then(successFn, errorFn);
        }

        function getTv() {
            return $http.get(CONFIG.API_HOST + '/movie/top=series')
                .then(successFn, errorFn);

        }

        function getMovie() {
            return $http.get(CONFIG.API_HOST + '/movie/top=movie')
                .then(successFn, errorFn);

        }
        function successFn(response) {
            console.log(response.data);
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }
})();