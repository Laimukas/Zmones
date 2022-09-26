<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="lt.bit.spring_web.classes.Zmogus"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Zmogus> list = (List<Zmogus>) request.getAttribute("zmones");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zmones Spring</title>
    </head>
    <body>
        <form method="GET" action="zmogus/new">
        <input type="submit" value="ADD Zmogus" >
        </form>
        <hr>
         <div align="center">
         <a> Paieška pagal vardą arba pavardę...</a>
          <table>
                 <tr>
        <form method="GET" action="paieska">
                   <th>Vardas:</th> <td><input type="text" name="vardas" value="${vardas}"></td>
                   <th>Pavarde:</th> <td> <input type="text" name="pavarde" value="${pavarde}"></td>
                   <td><input type="submit" value="Search"></td>
        </form></tr></table>
        <hr>
        <a> Rikiavimas pagal:</a>
        <table>
        <tr>
        <td><form method="GET" action="pagalVarda">
          <input type="submit" value="Vardas">
        </form></td>
        <td><form method="GET" action="pagalPavarde">
          <input type="submit" value="Pavarde">
        </form></td>
        <td><form method="GET" action="<%=application.getContextPath()%>/">
          <input type="submit" value="Unsorted">
        </form></td>
        <ul>
        <table border="1" cellpadding="5">

                <tr>
                    <th>Eil.Nr.</th>
                    <th>Vardas</th>
                    <th>Pavardė</th>
                    <th>Amžius</th>
                    <th>Funkcijos</th>
                </tr>
        <c:forEach var="zmogus" items="${zmones}">

            <tr>
                 <td>${zmogus.id}</td>
                 <td>${zmogus.vardas}</td>
                 <td>${zmogus.pavarde}</td>
                 <td>${zmogus.amzius}</td>
                 <td>
                     <a href="zmogus/${zmogus.id}">edit</a>
                     <a href="zmogus/${zmogus.id}/delete">delete</a>
                     <a href="zmogus/${zmogus.id}/kontaktai">kontaktai</a>
                 </td>
            </tr>

        </c:forEach>
        </ul>

        <hr>
     </div>
    </body>
</html>
