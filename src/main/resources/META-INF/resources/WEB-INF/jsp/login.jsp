<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>ToDo Application - Login</title>
</head>
<body>
    <div class="container">
        <h1>ToDo App</h1>
        <hr>
        <h2>Login Page</h2>
    <%--    <div>${errorMessage}</div> --%>
    <%--    above line works fine--%>
        <pre>${errorMessage}</pre>
        <form method="post">
    <%--        <input>Name</input>--%>
    <%--        <input>Password</input>--%>
            Name: <input type="text" name="name"/>
            Password: <input type="password" name="password"/> <input type="submit"/>
        </form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>