<%-- 
    Document   : registro
    Created on : 23/09/2019, 01:06:17 PM
    Author     : Durango
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form id="form" method="post" action="./Registro" onsubmit="return validarRegistro()" autocomplete="off" class="col-xs-12 col-sm-12 col-md-4"  style="margin: 10px 0 10px; background: #222;  box-shadow: 5px 5px 5px #999; border-radius: 5px;">
    <fieldset>
        <legend class="col-xs-12" style="color: #FFF; text-align: center;">Registrate</legend>
        <div class="row">
            <div class="form-group col-sm-6">
                <input class="form-control" id="name" name="name" placeholder="Nombre" type="text" pattern="[A-Za-z]{1,45}">
            </div>

            <div class="form-group col-sm-6">
                <input class="form-control" id="lastName" name="lastName" placeholder="Apellido" type="text" pattern="[A-Za-z]{1,45}">
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-8">
                <input class="form-control" id="documento" name="documento" placeholder="Numero de documento" type="text" pattern="[0-9]{1,45}">
            </div>

            <div class="form-group col-sm-4">
                <select class="form-control" name="idTipoDocumento">
                    <option value="1">C.C</option>
                    <option value="2">T.I</option>
                </select>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-sm-12">
                <input class="form-control" id="cel" name="cel" placeholder="Telefono Celular" type="text" pattern="[0-9]{1,45}">
            </div>
        </div>
        
        <div id="errorRegistro" class="form-group col-md-12"></div>
        <div id="small" class="form-text text-muted">
            
        </div>

        
        <!--<div id="resultadoBusqueda" class="form-group col-md-12"></div>-->

        <div class="form-group col-md-12" style="color: #fff;">
            <!--input type="checkbox" id="acepto" > Acepto los <a href="?view=terminos" target="_blank">terminos y condiciones</a-->
        </div>
        <div class="row">
            <div class="form-group col">
                <button class="form-control btn" type="submit" style="background: #fff;" name="accion" value="registrar">Comenzar</button>
            </div>
        </div>
    </fieldset>
</form>
<c:if test="${estadoRegistro == true}">
    <div class="col-md-8"></div>
    <div class="alert alert-success col-xs-12 col-sm-12 col-md-4" role="alert">
        Registro exitoso!
    </div>
</c:if>
<c:if test="${estadoRegistro == false}">
    <div class="col-md-8"></div>
    <div class="alert alert-danger col-xs-12 col-sm-12 col-md-4" role="alert">
        Error! por favor revise su datos e intente nuevamente.
    </div>
</c:if>