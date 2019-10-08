<%-- 
    Document   : adminCita
    Created on : 2/10/2019, 11:39:24 PM
    Author     : Durango
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form id="form" method="post" action="./Agendar" onsubmit="return validar()" autocomplete="off" class="col-xs-12 col-sm-12"  style="margin: 10px 0 10px; background: #222;  box-shadow: 5px 5px 5px #999; border-radius: 5px;">
    <fieldset>
        <div class="row">
            <label class="col-sm-12" style="color: #FFF">Fecha</label>
            
            <div class="form-group col-sm-4">
                <select class="form-control" name="mes" id="mes" onchange="cambioMes();"> 
                    <option value="1">Enero</option>
                    <option value="2">Febrero</option>
                    <option value="3">Marzo</option>
                    <option value="4">Abril</option>
                    <option value="5">Mayo</option>
                    <option value="6">Junio</option>
                    <option value="7">Julio</option>
                    <option value="8">Agosto</option>
                    <option value="9">Septiembre</option>
                    <option value="10">Octubre</option>
                    <option value="11">Noviembre</option>
                    <option value="12">Diciembre</option>
                </select>
            </div>
            <div class="form-group col-sm-4">
                <select class="form-control" name="dia" id="dia">

                </select>

            </div>
            <div class="form-group col-sm-4">
                <select class="form-control" name="anio" id="anio">
                </select>
            </div>
        </div>
        <div class="row">
            <label class="col-sm-12" for="horaInicio" style="color: #FFF">Apertura</label>
            <div class="form-group col-sm-6">
                <select class="form-control" name="horaInicio" id="horaInicio">

                </select>

            </div>
            <div class="form-group col-sm-6">
                <select class="form-control" name="amPM" id="amPM"> <!-- seleccionar si es AM o PM-->
                    <option value="0">AM</option>
                    <option value="1">PM</option>
                </select>
            </div>
        </div>

        <div class="row">
            <label class="col-sm-12" for="cierre" style="color: #FFF">Cierre</label>
            <div class="form-group col-sm-6">
                <select class="form-control" name="Cierre" id="Cierre">

                </select>

            </div>
            <div class="form-group col-sm-6">
                <select class="form-control" name="amPM_" id="amPM_">
                    <option value="0">AM</option>
                    <option value="1">PM</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="form-group col">
                <button class="form-control btn" type="submit" style="background: #fff;">Agendar</button>
            </div>
        </div>
    </fieldset>
</form>
<c:if test="${estadoActualizarAgenda == true}">
    <div class="alert alert-success col-12" role="alert">
        Agenda actualizada!
    </div>
</c:if>
<c:if test="${estadoActualizarAgenda == false}">
    <div class="alert alert-danger col-12" role="alert">
        Error! intente nuevamente
    </div>
</c:if>