<div class="container" id="search">
    <div class="row center text-center">
        <h2>Ejemplo</h2>
    </div>
    <div class="row" ng-controller="CommentController">
        <div class="col-md-6">
            <div class="row">
                <h4>Agregar un comentario</h4>
                <hr/>
                <form>
                    <div class="input-group" style="width:90%; margin-bottom: 1%;">
                        <input class="form-control" ng-model="newComment.title" placeholder="Inserte el t&iacute;tulo" type="text"/>
                    </div>
                    <div class="input-group" style="width:90%; margin-bottom: 1%;">
                        <textarea class="form-control" ng-model="newComment.comment" placeholder="Inserte el comentario"></textarea>
                    </div>
                    <button type="submit" class="btn btn-info" ng-click="save(newComment)">Guardar</button>
                </form>
            </div>
        </div>
        <div class="col-md-6">
            <div class="row">
                <h4>Listar comentarios</h4>
                <hr/>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>T&iacute;tulo</th>
                            <th>Comentario</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="comment in comments">
                            <td>{{comment.title}}</td>
                            <td>{{comment.comment}}</td>
                            <td><button ng-click="delete(comment, $index)">Eliminar</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
</div>