<%-- 
    Document   : listado
    Created on : 6/10/2019, 09:02:51 PM
    Author     : Durango
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="models.agenda"%>
<%@page import="models.agendaDAO"%>

<c:if test="${mostrar == true}">
<form id="form" method="post" action="./Registro" onsubmit="return validarReserva()" autocomplete="off">
    <input type="hidden" name="accion" value="reservar">
    <div class="form-group">
        <label for="celReserva">Para realizar la reserva debe ingresar su numero de celular</label>
        <input class="form-control" id="celReserva" name="celReserva" placeholder="Telefono Celular" type="tel" >
    </div>
    <div id="error"></div>
    <table class="table col-12" style="color: #FFF; background: #222">
        <thead>
            <tr>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Reservar</th>
            </tr>
        </thead>
        
        <%
            ArrayList<agenda> list = (ArrayList<agenda>) request.getAttribute("lista");
            Iterator<agenda> iter = list.iterator(); 
            agenda agen = null;
            while (iter.hasNext()) {
                agen = iter.next();
        %>
        <tbody>
            <tr>
                <td><%=agen.getDia() + " - " + agen.getMes() + " - " + agen.getAnio()%></td>
                <td><%=agen.getHora()%></td>
        
                <td>
                    <button class="form-control btn" type="submit" style="background: #fff;" name="id_Cita" value="<%=agen.getId()%>">Reservar</button>
                </td>
            </tr>
            <%}%>
        </tbody>
    </table>
</form>
</c:if>
<% //System.out.println(request.getAttribute("estadoReserva"));%>
<c:if test="${estadoReserva == true}">
    <div class="alert alert-success" role="alert">
        Se ha reservado su cita, por favor confirme vía WhatsApp!
    </div>
</c:if>
<c:if test="${estadoReserva == false}">
    <div class="alert alert-danger" role="alert">
        Error! por favor revise su datos e intente nuevamente.
    </div>
</c:if>