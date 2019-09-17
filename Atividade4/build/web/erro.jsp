<%-- 
    Document   : erro
    Created on : 16/09/2019, 10:20:35
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro JSP</title>
        <meta charset=\"UTF-8\">
            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
            <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">
            <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>
            <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>
            <style> h1 { 
                        text-align: center;
                    }
                    .container {
                        text-align: center;
                    } 
                    .btn {
                        background-color: white; 
                        color: black;
                        border: 2px solid #e7e7e7;
                    } 
                    .rodape{
                        position: absolute;
                        top: 95%;
                        left: 50%;
                        color: coral;
                    }
            </style>
    </head>
    <body>
        <% 
         String pag = (String)request.getAttribute("page");   
         String msg = (String)request.getAttribute("msg");
        %>
        <!--Pegar email usando beans no scopo aplication -->
        <!--<%= get.email %> -->
        <div class="rodape">Em caso de problemas, contactar o administrador +></div>
    </body>
</html>
