var app = angular.module('Example', ['ui.bootstrap', 'ngResource', 'ui.router'])
    .config(function($urlRouterProvider, $stateProvider, $httpProvider) {
        $stateProvider
            .state("home", {
                url: "/home"
            });
        $urlRouterProvider.otherwise('/home');
        $httpProvider.defaults.headers.common.Authorization = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE0NjQ5NzQwNzYxNTUsImV4cCI6MTQ2NTU3ODg3Nn0.Hs5SDkGIio3rIPJOReTNNkyOdM-LOWSx9j3_lD-783LFa37njbEPwf1485776riDNT_ii0paEfk_Nm5oikQ25g';
    });

app.service('CommentService', CommentService);
app.controller('CommentController', CommentController);