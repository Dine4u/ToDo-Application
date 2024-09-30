<%@include file="common/header.jspf"%>
    <title>ToDo Application</title>
</head>
<body>
<%@include file="common/navgation.jspf"%>
    <div class="container">
        <h2>Welcome Back ${name}!</h2>
    <%--    <div>Your name is ${name}</div>--%>
    <%--    <div>Your password is ${password}</div>--%>
        <div><a href="todo-list"> List of the todos </a></div>
    </div>
<%@include file="common/footer.jspf"%>