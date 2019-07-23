<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<h1>
    <c:if test="${empty kundeList}">
        Es gibt keine Kunden zum zeigen
    </c:if>
    <c:if test="${not empty kundeList}">
        Liste von Kunden
    </c:if>
</h1>


    <table >
        <c:forEach var="kunde" items="${kundeList}">
            <tr>
                <td>${kunde.steuerId}</td>
                <td>${kunde.name}</td>
                <td>${kunde.nachname}</td>

                <td><a href="/web/editkunde/${kunde.id}">Edit</a></td>
                <td><a href="/web/deletekunde/${kunde.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
