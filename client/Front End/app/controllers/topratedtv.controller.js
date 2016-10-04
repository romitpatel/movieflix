(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('TopRatedTvController',TopRatedTvController)

    TopRatedTvController.$inject =['movieService']

    function TopRatedTvController(){
            var topRatedTvVm = this;

            init();
            function init() {
                console.log('inside Top Rated Tv Controller');
                movieService
                    .findTopRatedTv()
                    .then(function (data) {
                        topRatedTvVm.movies = data;
                    },function (error) {
                        console.log(error);
                    })

            }
    }

})();