function CommentController($scope, CommentService) {

    $scope.comments = CommentService.query();
    $scope.newComment = {
        title: null,
        description: null
    };

    $scope.save = function(newComment) {
        var service = new CommentService();
        service.title = newComment.title;
        service.comment = newComment.comment;
        service.$save(function(response) {
            $scope.comments.push(response);
        });
    }

    $scope.delete = function(comment, index) {
        comment.$remove(function(response){
            $scope.comments.splice(index, 1);
        });
    }

    $scope.initiator = false;

    $scope.socket = {
        client: null,
        stomp: null
    };


}
