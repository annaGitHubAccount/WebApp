<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Add new Kunde</h1>

<form:form method="post" modelAttribute="kundeForm" action="/kunde/kundeweiterleiten">
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Nachname :</td>
            <td><form:input path="nachname" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
