<%-- 
    Document   : portal
    Created on : 16/09/2019, 10:21:26
    Author     : eduardo
--%>

<%@page import="beans.ConfigBean"%>
<%@page import="classes.MyBean"%>
<%@page import="java.util.List"%>
<%@page import="classes.Usuario"%>
<%@page import="dao.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <style>
            div.fixed {
  position: fixed;
  width: 50%;
  bottom: 10px;
  border: 3px solid #8AC007;
} 
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Jsp</title>
                <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">
                <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>
                <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>
                <link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\" />
                <style>
                    .rodape{
                        position: absolute;
                        top: 95%;
                        left: 35%;
                    }
                </style>
    </head>
    <body>
           <%   
                String logado = (String) session.getAttribute("logado");
                out.print(logado);
                String msg= "Página Indisponível, favor logar.";
                
                if(logado != null){
                    PessoaDAO dao = new PessoaDAO();
                    List<Usuario> lista = dao.buscarTodos();
                    
                }
                else {
                    request.setAttribute("msg",msg);
                    request.setAttribute("page","index.html");
                    RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);           
                }
                
           %>
          <jsp:useBean id="configuracao" class="beans.ConfigBean" scope="application" />
        <p class="rodape">Em caso de problemas contactar o administrador:
            Email:<jsp:getProperty name="configuracao" property="email"/>   
            
        </p>
        </p>  <br>  <br>
      
                      

        <a href="PortalServlet" align="center"><button type="button" class="btn btn-success">Portal Servlet</button></a> <br>
            <a href="inserir.jsp" align="center"><button type="button" class="btn btn-success">Inserir Jsp</button></a>
    </body>
</html>         
