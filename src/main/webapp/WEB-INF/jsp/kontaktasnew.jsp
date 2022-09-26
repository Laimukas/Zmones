<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>vienas kontaktas</title>
    </head>
    <body>
    <div align="center">
     <table border="1" cellpadding="5">
        <form method="POST" action="saveKont">

            <tr><th>ZmId:</th> <td><input type="number" name="zmId" value="${zmId}"></td> </tr>
            <tr><th>Tipas:</th> <td><input type="text" name="tipas" value="${tipas}"></td> </tr>
            <tr><th>Reiksme:</th> <td><input type="text" name="reiksme" value="${reiksme}"></td> </tr>
            <tr><td><input type="submit" value="save"></td>
            <td><a href="kontaktai">Cancel</a></td> </tr>
        </form>
        </div>
    </body>
</html>