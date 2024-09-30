<%@include file="common/header.jspf"%>
    <title>Manage your Todo</title>
</head>
<body>
<%@include file="common/navgation.jspf"%>
    <div class="container">
        <h2>Your Todos</h2>
        <%--    <div>${todos}</div>--%>
        <table class="table">
            <thead>
                <tr>
<%--                    <th>id</th>--%>
                    <th>name</th>
                    <th>description</th>
                    <th>targetDate</th>
                    <th>status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
<%--                        <td>${todo.id}</td>--%>
                        <td>${todo.name}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>

<%--                        tried changing date format using below, but not worked--%>
<%--                        <td>--%>
<%--                            <fmt:parseDate value="${todo.targetDate}" pattern="dd-MM-yyyy" var="targetDate" type="date"/>--%>
<%--                            <fmt:formatDate value="${todo.targetDate}" pattern="dd-MM-yyyy" />--%>
<%--                        </td>--%>

                        <td>${todo.status}</td>
                        <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger"> DELETE </a> </td>
<%--                        above line GET request--%>
                        <td><a href="update-todo?id=${todo.id}" class="btn btn-warning"> UPDATE </a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
<%--        <div><a href="add-todo">Add ToDo</a></div>--%>
<%--        wihtout div tag also above line works, div tag is for group up multiple HTML tags--%>
        <a href="add-todo" class="btn btn-success">Add ToDo</a>
    </div>
<%@include file="common/footer.jspf"%>