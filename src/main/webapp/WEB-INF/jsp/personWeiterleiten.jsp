<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Wollen Sie wirklich die Daten von der Person speichern?</h1>

<form:form method="post" modelAttribute="personForm" action="/person/saveperson">
    <table >
        <tr>
            <td>Name : </td>
            <td>${personForm.name}</td>
        </tr>
        <tr>
            <td>Nachname :</td>
            <td>${personForm.nachname}</td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>

    <form:hidden path="name"/>
    <form:hidden path="nachname"/>
</form:form>
