package control;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Cliente;
import models.ClienteDAO;
import models.agenda;
import models.agendaDAO;

public class AdminCliente extends HttpServlet { 
    
    ClienteDAO perDAO = new ClienteDAO();
    Cliente per = new Cliente();
    
    agendaDAO agenDAO = new agendaDAO();
    agenda agen = new agenda();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("documento");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String cel = request.getParameter("cel");
        String tipoDocumento = request.getParameter("idTipoDocumento");
        String accion = request.getParameter("accion");

        
        if (accion.equals("registrar")){
            per.setId(id);
            per.setName(name);
            per.setLastName(lastName);
            per.setCel(cel);
            per.setTipoDocumento(tipoDocumento);

            boolean estadoRegistro = perDAO.agregar(per);
            request.setAttribute("estadoRegistro", estadoRegistro);
        }
        
        if (accion.equals("buscar")){
            String dia = request.getParameter("dia");
            String mes = request.getParameter("mes");
            String anio = request.getParameter("anio");
            
            ArrayList<agenda> list = (ArrayList<agenda>) agenDAO.listar(dia, mes, anio);
            request.setAttribute("lista", list);
            request.setAttribute("mostrar", true);
        }
        
        if (accion.equals("reservar")){
            String celReserva = request.getParameter("celReserva");
            String id_Cita = request.getParameter("id_Cita");
            boolean estadoReserva = agenDAO.reservar(id_Cita, celReserva);
            request.setAttribute("estadoReserva", estadoReserva);
        }
        
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

}
