<%-- 
    Document   : inserir
    Created on : 16/09/2019, 10:21:01
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir JSP</title>
    </head>
    <body>
        <% 
            String logado = (String) session.getAttribute("logado");
            String msg = "Página Indisponível, favor logar.";
            if(logado == null){ 
                request.setAttribute("msg",msg);
                request.setAttribute("page","index.html");
                RequestDispatcher rd = getServletContext().
                getRequestDispatcher("/ErroServlet");
                rd.forward(request, response);           
            }
            else {
                out.print(logado);
            }
            
        %>
        
       <form method="post" action="CadastrarUsuarioServlet">
            
            <br/>Nome:<input type="text" name="nome"/>
            <br/>Usuario:<input type="text" name="login"/>
            <br/>Senha:<input type="text" name="senha"/>
        
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
