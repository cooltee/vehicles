<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 2017/2/12
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="commons/include.jsp" %>
<head>
    <title>spring</title>
    <script>
        $(function () {
            $('#btn').click(function () {
                $.ajax({
                    url: '${CONTEXT_PATH}/json/user',
                    success: function (data) {

                        $('#say').val(data.name);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <h3>hello, world</h3>
    <h3>hollo, vehicles</h3>
    <input type="text" id="say"/><button id="btn">get user info</button>
</body>
</html>
