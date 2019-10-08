<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="template/header.jsp" %>


<%@include file="template/slideshow.html" %>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h1 style="text-align: center">Consultar Agenda</h1>
            <%@include file="template/listarAgenda.jsp" %>
        </div>
        
        <%@include file="template/registro.jsp" %>
    </div>
    <div class="row">
        <div class="col-md-8">
            <%@include file="template/listado.jsp" %>
        </div>
    </div>
</div>
<%@include file="template/footer.jsp" %>
