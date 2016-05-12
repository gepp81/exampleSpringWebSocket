function CommentService($resource) {
    return $resource("./comment/:id", {
        id: '@id'
    }, {
        update: {
            method: "PUT"
        },
        remove: {
            method: "DELETE"
        }
    });
}
