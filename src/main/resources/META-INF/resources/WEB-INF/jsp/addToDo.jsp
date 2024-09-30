<%@include file="common/header.jspf"%>
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
    <title>Add ToDo</title>
</head>
<body>
<%@include file="common/navgation.jspf"%>
<div class="container">
    <h4 class="mb-3">Enter your ToDo details below</h4>

<%--    Version 1--%>
<%--    <form method="post">--%>
<%--        ToDo Name: <input type="text" name="todoname">--%>
<%--        Description: <input type="text" name="description"/>--%>
<%--        Target Date: <input type="date" name="targetdate"/>--%>
<%--        Status: <input type="text" name="status"/>--%>
<%--        <hr>--%>
<%--        <input type="submit" class="btn btn-success"/>--%>
<%--    </form>--%>

<%--    Version 2--%>
<%--    <form:form method="post" modelAttribute="todo">--%>
<%--&lt;%&ndash;        Id: <form:input type="number" path="id"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;        Name: <form:input type="text" path="name"/>&ndash;%&gt;--%>
<%--        <form:input type="hidden" path="id"/>--%>
<%--        <form:input type="hidden" path="name"/>--%>
<%--        Description: <form:input type="text" path="description" required="required"/>--%>
<%--                     <form:errors path="description" cssClass="alert-danger"/>--%>
<%--        Target Date: <form:input type="date" path="targetDate"/>--%>
<%--&lt;%&ndash;                        below errors for date is causing error&ndash;%&gt;--%>
<%--&lt;%&ndash;                     <form:errors path="date" cssClass="alert"/>&ndash;%&gt;--%>
<%--        Status: <form:input type="text" path="status"/>--%>
<%--        <hr>--%>
<%--        <input type="submit" class="btn btn-success"/>--%>
<%--    </form:form>--%>


<%--    Version 3 My version working without Bootstrap datepicker dependency. Date error also working--%>
<%--    <form:form method="post" modelAttribute="todo">--%>
<%--        <form:input type="hidden" path="id"/>--%>
<%--        <form:input type="hidden" path="name"/>--%>
<%--        <fieldset class="mb-3">--%>
<%--            <form:label path="description">Description</form:label>--%>
<%--            <form:input type="text" path="description" required="required"/>--%>
<%--            <form:errors path="description" cssClass="alert-danger"/>--%>
<%--        </fieldset>--%>

<%--        <fieldset class="mb-3">--%>
<%--            <form:label path="targetDate">Target Date</form:label>--%>
<%--            <form:input type="date" path="targetDate" required="required"/>--%>
<%--            <form:errors path="targetDate" cssClass="alert-danger"/>--%>
<%--        </fieldset>--%>

<%--        <fieldset class="mb-3">--%>
<%--            <form:label path="status">Status</form:label>--%>
<%--            <form:input type="text" path="status" required="required"/>--%>
<%--            <form:errors path="status" cssClass="alert-danger"/>--%>
<%--        </fieldset>--%>
<%--        <hr>--%>
<%--        <input type="submit" class="btn btn-success"/>--%>
<%--    </form:form>--%>


<%--    Version 4 Lecture Version--%>
<%--    Added <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >--%>
<%--    Added <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>--%>
<%--    Added <script type="text/javascript">--%>
<%--        $('#targetDate').datepicker({--%>
<%--            format: 'yyyy-mm-dd'--%>
<%--        });--%>
<%--        </script>--%>
<%--    Added dependency --%>
<%--    <dependency>--%>
<%--    <groupId>org.webjars</groupId>--%>
<%--    <artifactId>bootstrap-datepicker</artifactId>--%>
<%--    <version>1.9.0</version>--%>
<%--</dependency>--%>
    <form:form method="post" modelAttribute="todo">
        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="name"/>
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required"/>
            <form:errors path="description" cssClass="alert-danger"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" required="required"/>
            <form:errors path="targetDate" cssClass="alert-danger"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="status">Status</form:label>
            <form:input type="text" path="status" required="required"/>
            <form:errors path="status" cssClass="alert-danger"/>
        </fieldset>
        <hr>
        <input type="submit" class="btn btn-success"/>
    </form:form>
</div>
<%@include file="common/footer.jspf"%>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'dd-mm-yyyy'
    });
</script>