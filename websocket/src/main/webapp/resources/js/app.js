var app = angular.module('Example', ['ui.bootstrap', 'ngResource', 'ui.router'])
    .config(function($urlRouterProvider, $stateProvider) {
        $stateProvider
            .state("home", {
                url: "/home"
            });
        $urlRouterProvider.otherwise('/home');
    });

app.service('CommentService', CommentService);
app.controller('CommentController', CommentController)
