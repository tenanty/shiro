<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="/smart_security" %>
<html>
<head>
    <title>我的空间</title>
</head>
<body>

<h1><a href="<c:url value="/"/>">首页</a> - 空间</h1>

<p>用户名：<security:principal/></p>

<security:hasAnyRoles name="admin,user">
    <dl>
        <dt>角色：</dt>
        <security:hasRole name="admin">
            <dd>管理员</dd>
        </security:hasRole>
        <security:hasRole name="user">
            <dd>普通用户</dd>
        </security:hasRole>
    </dl>
</security:hasAnyRoles>

<security:hasAnyPerms name="product.view,product.new,product.edit,product.delete">
    <dl>
        <dt>权限：</dt>
        <security:hasPerm name="product.view">
            <dd>查看产品</dd>
        </security:hasPerm>
        <security:hasPerm name="product.new">
            <dd>新增产品</dd>
        </security:hasPerm>
        <security:hasPerm name="product.edit">
            <dd>编辑产品</dd>
        </security:hasPerm>
        <security:hasPerm name="product.delete">
            <dd>删除产品</dd>
        </security:hasPerm>
    </dl>
</security:hasAnyPerms>

<a href="<c:url value="/logout"/>">退出</a>

</body>
</html>