<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>vienas zmogus</title>
    </head>
    <body>
    <div align="center">
    <table border="1" cellpadding="5">
        <form method="POST" action="../save">
            <c:if test="${zmogus.id != null}">
                <input type="hidden" name="id" value="${zmogus.id}">
            </c:if>
            <tr><th>Vardas:</th> <td> <input type="text" name="vardas" value="${zmogus.vardas}"></td> </tr>
            <tr><th>Pavarde:</th> <td> <input type="text" name="pavarde" value="${zmogus.pavarde}"></td> </tr>
            <tr><th>Amzius:</th> <td> <input type="number" name="amzius" value="${zmogus.amzius}"></td> </tr>
            <tr><td><input type="submit" value="save"></td>
            <td><a href="../">Cancel</a></td> </tr>
        </form>
        </div>
    </body>
</html>