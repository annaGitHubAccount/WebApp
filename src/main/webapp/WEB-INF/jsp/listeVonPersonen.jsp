<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<h1>
    <c:if test="${empty personList}">
        Es gibt keine Personen zum zeigen
    </c:if>
    <c:if test="${not empty personList}">
        Liste von Personen
    </c:if>
</h1>


    <table >
        <c:forEach var="person" items="${personList}">
            <tr>
                <td>${person.name}</td>
                <td>${person.nachname}</td>

                <td><a href="/person/editperson/${person.id}">Edit</a></td>
                <td><a href="/person/deleteperson/${person.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
