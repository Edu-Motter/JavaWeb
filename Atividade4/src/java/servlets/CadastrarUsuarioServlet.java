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
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

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
                String nome = (String) request.getParameter("nome");
                String login = (String) request.getParameter("login");
                String senha = (String) request.getParameter("senha");

                Usuario p = new Usuario();
                // set de todos os dados
                p.setNome(nome);
                p.setUsuario(login);
                p.setSenha(senha);
                PessoaDAO dao = new PessoaDAO();
                dao.inserirPessoa(p);
               
               
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet CadastrarUsuarioServlet</title>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">");
                out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>");
                out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
                out.println("<style>h1 {\n" +
                            "  text-align: center;\n" +
                            "}\n" +
                            "\n" +
                            "p {\n" +
                            "  text-align: center;\n" +
                            "}</style>");
                out.println("</head>");            
                out.println("<body>");
                out.println("<h1>Usuário Cadastrado com Sucesso</h1>");
                //Aqui ira ser a Portal! Não PortalServlet 
                out.println("<p><a href=" + getServletContext().getContextPath() + "/portal.jsp" + ">Portal</a></p>");
                out.println("</body>");
                out.println("</html>");
            }
            catch(Exception e){

            } 
            
            
        }
        
        else {
            request.setAttribute("msg",msg);
            request.setAttribute("page","index.html");
            RequestDispatcher rd = getServletContext().
            getRequestDispatcher("/erro.jsp");
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
