<%-- 
    Document   : uno
    Created on : 31/01/2023, 11:25:36 AM
    Author     : sdist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP de resultado de la suma</title>
    </head>
    <body>
        <%
            String strA, strB;
            int a,b,c;
            strA = request.getParameter("opA");
            strB = request.getParameter("opB");
            a = Integer.parseInt(strA);
            b = Integer.parseInt(strB);
            c = a + b;
            response.getWriter().print("La suma de " + a + " y " + b + " es " + c);
        %>
    </body>
</html>
