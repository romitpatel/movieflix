
(function() {
    'use strict';

    angular.module('movieflix', ['ngRoute'])
        .config(moduleConfig)
        .run(moduleRun);

    moduleConfig.$inject = ['$routeProvider']


    function moduleConfig($routeProvider) {

       $routeProvider
            .when('/movie', {
                templateUrl : 'app/views/home.tmpl.html',
                controller : 'MovieController',
                controllerAs : 'movieVm'
            })
           .when('/movie/{id}',{
               templateUrl : 'app/views/moviedetails.tmpl.html',
               controller : 'MovieInfoController',
               controllerAs : 'movieInfoVm'
           })
           .when('/add-movie',{
               templateUrl : 'app/views/add-movie.tmpl.html',
               controller : 'AddMovieController',
               controllerAs : 'addMovieVm'
           })
           .when('/movie/top/type=series',{
               templateUrl : 'app/views/toprated.tmpl.html',
               controller : 'TopRatedTvController',
               controllerAs : 'topRatedTvVm'
           })
           .otherwise({
               redirectTo:'/movie'
           });



    }
    function moduleRun() {
        console.log('app started');
    }
})();