fecha = new Date();
llenarSelectEnteros("dia", 1, 31);
llenarSelectEnteros("anio", fecha.getFullYear(), 2100);

select = document.getElementById("horaInicio");
for (i = 1; i <= 12; i++) {
    option = document.createElement("option");
    option.value = i;
    option.text = i + ":00";
    select.appendChild(option);
}
select = document.getElementById("Cierre");
for (i = 1; i <= 12; i++) {
    option = document.createElement("option");
    option.value = i;
    option.text = i + ":00";
    select.appendChild(option);
}



//borrrar los items de la lista dias
function limpiarSelect(id) {
    document.getElementById(id).length = 0;
}

function llenarSelectEnteros(id, inicio, fin) {
    select = document.getElementById(id);

    for (i = inicio; i <= fin; i++) {
        option = document.createElement("option");
        option.value = i;
        option.text = i;
        select.appendChild(option);
    }
}
//funcion para determinar la cantidad de dias por mes
function cambioMes() {
    limpiarSelect("dia");

    mes = document.getElementById("mes").value;

    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
        dias = 31;
    } else if (mes == 2) {
        dias = 29;
    } else {
        dias = 30;
    }
    llenarSelectEnteros("dia", 1, dias);
}

function buscar() {
    var textoNickname = $("input#nickname").val();
 
     if (textoNickname != "") {
        $.post("models/buscar.php", {valorNickname: textoNickname}, function(mensaje) {
            $("#resultadoBusqueda").html(mensaje);
         }); 
     } else {
     	$("#resultadoBusqueda").html('');
     }
};

function validarReserva(){

/*verificamos que el celular sea de tipo numerioco*/
cel = document.getElementById("celReserva").value;
if( cel == null || isNaN(cel) || cel.length < 10 ) {
	document.getElementById("error").innerHTML=
	"<font color='#222'>- Por favor ingrese un telefono válido </font>";
	return false;
}
return true;
}

function validarRegistro(){
/*verificar que el campo nombre no esta vacio s*/
name = document.getElementById("name").value;
if( name.length==0) {
	document.getElementById("errorRegistro").innerHTML=
	"<font color='#FFF'>- Ingrese su nombre </font>>";
        document.getElementById("small").innerHTML=
        "(no use caracteres extraños)";
	return false;
}

lastName = document.getElementById("lastName").value;
if( lastName.length==0) {
	document.getElementById("errorRegistro").innerHTML=
	"<font color='#FFF'>- Ingrese su Apellido </font>>";
        document.getElementById("small").innerHTML=
        "(no use caracteres extraños)";
	return false;
}

/*verificamos que el documento sea numerico*/
doc = document.getElementById("documento").value;
if( doc == null || isNaN(doc) || doc.length < 7 ) {
	document.getElementById("errorRegistro").innerHTML=
	"<font color='#FFF'>- Por favor ingrese un documento válido </font>";
	return false;
}

/*verificamos que el celular sea de tipo numerioco*/
cel = document.getElementById("cel").value;
if( cel == null || isNaN(cel) || cel.length < 10 ) {
	document.getElementById("errorRegistro").innerHTML=
	"<font color='#FFF'>- Por favor ingrese un telefono válido </font>";
	return false;
}
return true;
}

