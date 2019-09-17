<%-- 
    Document   : portal
    Created on : 16/09/2019, 10:21:26
    Author     : eduardo
--%>

<%@page import="java.util.List"%>
<%@page import="classes.Usuario"%>
<%@page import="dao.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Jsp</title>
                <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">
                <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>
                <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>
                <link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\" />
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
                
           %>
           //Faltam coisas ainda!
           <//jsp:useBean />
        <h1>Hello World!</h1>   
    </body>
</html>         
