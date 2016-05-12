<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Example</title>
        <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/index.css' />" rel="stylesheet"></link>
    </head>

    <body ng-app="Example">
        <%@include file="view.jsp" %>

        <script src="<c:url value='/resources/js/vendor/angular.min.js' />" type="text/javascript"></script>
        <script src="<c:url value='/resources/js/vendor/angular-bootstrap-1.2.2.min.js' />" type="text/javascript"></script>
        <script src="<c:url value='/resources/js/vendor/angular-resource.min.js' />" type="text/javascript"></script>
        <script src="<c:url value='/resources/js/vendor/angular-route.min.js' />" type="text/javascript"></script>
        <script src="<c:url value='/resources/js/vendor/stomp.min.js' />" type="text/javascript"></script>
        <script src="<c:url value='/resources/js/vendor/sockjs.min.js' />" type="text/javascript"></script>
        <script src="<c:url value='/resources/js/commentService.js' />" type="text/javascript"></script>
        <script src="<c:url value='/resources/js/commentController.js' />" type="text/javascript"></script>
        <script src="<c:url value='/resources/js/app.js' />"></script>
    </body>
</html>
