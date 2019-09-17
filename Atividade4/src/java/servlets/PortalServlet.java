/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Usuario;
import dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "PortalServlet", urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession ();
        String logado = (String) session.getAttribute("logado");
        out.print(logado);
        String msg= "Página Indisponível, favor logar.";
        
        if (logado != null){
            try {
                PessoaDAO dao = new PessoaDAO();
                List<Usuario> lista = dao.buscarTodos();

                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet PortalServlet</title>");   
                out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">");
                out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>");
                out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\" />");
                out.println("</head>");
                out.println("<body>");
                 out.println("<div class=\"mover\"> <a href=\""
                    + "LogoutServlet\"><button class=\"btn btn-primary\">LogoutServlet</button></a></div>\n");
                 out.println("<div class=\"login-page\">\n" +
"               <div class=\"alinhado\"> <h1>Cadastro</h1><form name=\"loginForm\" method=\"post\" action=\"CadastrarUsuarioServlet\">\n"
                    + "    Nome: <input class=\"form-control\" type=\"text\" name=\"nome\"/> <br/>\n"
                    + "    Login: <input class=\"form-control\" type=\"text\" name=\"login\"/> <br/>\n"
                    + "    Senha: <input class=\"form-control\" type=\"password\" name=\"senha\"/> <br/>\n"
                    + "    <input type=\"submit\" value=\"Salvar\" />\n"
                    + "</form></div></div>");
                 
               
                 
                 out.println("<h1 align=\"center\">Usuarios:</h1> \n"
                    + "     <div class=\"container\" style=\"width:500px;\"> <table class=\"table table-striped\">  \n"
                    + "         <tr bgcolor=\"00FF7F\"> \n"
                    + "          <th><b>Nome</b></th> \n"
                    + "          <th><b>Login</b></th> \n"
                    + "          <th><b>Senha</b></th> \n"
                    + "         </tr> \n");
                    //Objeto objeto 
                    
                for (Usuario s : lista) {
                    out.println("<tr> \n"
                            + "                <td>" + s.getNome() + "</td> \n"
                            + "                <td>" + s.getUsuario() + "</td> \n"
                            + "                <td>" + s.getSenha() + "</td> \n"
                            + "            </tr> \n");
                }
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
            catch(Exception e){

            }
        }
        else{
            request.setAttribute("msg",msg);
            request.setAttribute("page","index.html");
            RequestDispatcher rd = getServletContext().
            getRequestDispatcher("/ErroServlet");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
