<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="/smart_security" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<h1><a href="<c:url value="/"/>">首页</a> - 登录</h1>

<security:notAuthenticated>
    <form action="<c:url value="/login"/>" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <label><input type="checkbox" name="rememberMe"/>记住我</label>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">登录</button>
                </td>
            </tr>
        </table>
    </form>
    <c:if test="${requestScope['exception'] == 'LoginException'}">
        <p>登录失败！</p>
    </c:if>
</security:notAuthenticated>

<security:authenticated>
    <c:redirect url="/space"/>
</security:authenticated>

</body>
</html>