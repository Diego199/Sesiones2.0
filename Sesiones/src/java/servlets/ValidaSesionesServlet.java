/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidaSesionesServlet extends HttpServlet {
   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

      response.setContentType("text/html");
      HttpSession sesion = request.getSession();
      String titulo = null;
            String msj = null;
       String SESION = null;


      //Pedimos el atributo, y verificamos si existe
      String claveSesion = (String) sesion.getAttribute("claveSesion");

      if(claveSesion.equals("DiegoMartinez")){
        titulo = "llave correcta continua la sesion";
        msj ="<p align=\"CENTER\"><a href=\"/EjemploSession/index.jsp\">Sesion cerrada con invalidate regresar </a></P>";
                sesion.invalidate();
                SESION = sesion.getId();
      }
      else
      {
          titulo = "llave incorrecta inicie nuevamente sesion";
          msj ="<p align=\"CENTER\"><a href=\"/EjemploSession/index.jsp\">Sesion INVALIDA REGRESO</a></P>";
        sesion.invalidate(); 
        SESION = "NO ES VALIDA";
      }


      //Mostramos los  valores en el cliente
      PrintWriter out = response.getWriter();
      out.println("<body bgcolor=\"#E6E8FA\" ALIGN=\"CENTER\">");
      out.println("<p align=\"CENTER\">");
      out.println("¿Continua la Sesion y es valida?: " + titulo);
      out.println(msj);   
      out.println("<br>");
      out.println(SESION);
  
    }

}
