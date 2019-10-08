package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.agenda;
import models.agendaDAO;

/**
 *
 * @author Duran
 */
public class adminAgenda extends HttpServlet{
    agendaDAO agenDAO = new agendaDAO();
    agenda agen = new agenda();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
        view.forward(request, response);
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        int inicio = Integer.parseInt(request.getParameter("horaInicio"));
        int cierre = Integer.parseInt(request.getParameter("Cierre"));
        
        int amORpm = Integer.parseInt(request.getParameter("amPM"));
        int amORpm_ = Integer.parseInt(request.getParameter("amPM_"));
        
        if (amORpm==1) {
            inicio = inicio+12;
        }
        if (amORpm_==1) {
            cierre = cierre+12;
        }
        agen.setAnio(request.getParameter("anio"));
        agen.setMes(request.getParameter("mes"));
        agen.setDia(request.getParameter("dia"));
        System.out.println(request.getParameter("dia"));
        
        for (int i = inicio; i < (cierre); i++) {
            for (int j = 0; j<=1; j++){
                agen.setHora(Integer.toString(i)+":"+Integer.toString(j*3)+"0");
                agenDAO.agregar(agen);
            }
        }

        RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
        request.setAttribute("estadoActualizarAgenda", true);
        view.forward(request, response);
    }
}
