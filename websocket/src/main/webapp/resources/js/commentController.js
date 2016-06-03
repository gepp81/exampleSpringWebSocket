function CommentController($scope, dateFilter, CommentService) {

    $scope.comments = CommentService.query();
    $scope.newComment = {
        title: null,
        description: null
    };

    $scope.alerts = [];

    $scope.addAlert = function(message) {
        var date = dateFilter(message.date, 'HH:mm');
        var type;
        var msg;
        switch (message.action) {
            case 'save':
                type = "info";
                msg = "Se agrego un comentario ";
                break;
            case 'update':
                type = "warning";
                msg = "Se actualizo un comentario ";
                break;
            case 'delete':
                type = "danger"
                msg = "Se elimino un comentario ";
                break;
        }
        var msg = {
            type: type,
            msg: msg + date
        };
        $scope.alerts.push(msg);
    }

    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    }

    $scope.save = function(newComment) {
        $scope.initiator = true;
        var service = new CommentService();
        service.title = newComment.title;
        service.comment = newComment.comment;
        service.$save(function(response) {
            $scope.comments.push(response);
        });
        $scope.newComment = {
            title: null,
            description: null
        };
    }

    $scope.vote = function(comment, index, vote) {
        $scope.initiator = true;
        comment.votes = comment.votes + vote;
        if (comment.votes < 0) {
            comment.votes = 0;
        }
        comment.$update(function(response) {
            $scope.comments[index] = response;
        });
    }

    $scope.delete = function(comment, index) {
        $scope.initiator = true;
        comment.$remove(function(response) {
            $scope.comments.splice(index, 1);
        });
    }

    $scope.initiator = false;

    $scope.socket = {
        client: null,
        stomp: null
    };

    $scope.notify = function(message) {
        if (!$scope.initiator) {
            CommentService.query(function(comments) {
                $scope.comments = comments;
                $scope.addAlert(JSON.parse(message.body));
            });
        }
        $scope.initiator = false;
    };

    $scope.reconnect = function() {
        setTimeout($scope.initSockets, 10000);
    };

    $scope.initSockets = function() {
        $scope.socket.client = new SockJS('/websocket/notify');
        $scope.socket.stomp = Stomp.over($scope.socket.client);
        var headers = {
        		Authorization:
        			"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE0NjQ5NzQwNzYxNTUsImV4cCI6MTQ2NTU3ODg3Nn0.Hs5SDkGIio3rIPJOReTNNkyOdM-LOWSx9j3_lD-783LFa37njbEPwf1485776riDNT_ii0paEfk_Nm5oikQ25g",
        	    };        
        $scope.socket.stomp.connect(headers, function() {
            $scope.socket.stomp.subscribe("/topic/comment", $scope.notify);
        });
        $scope.socket.client.onclose = $scope.reconnect;
    };

    $scope.initSockets();


}
