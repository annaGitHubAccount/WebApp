<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Edit Person</h1>

<form:form modelAttribute="personForm" action="/person/personweiterleitenedit">
    <table >
        <tr>
            <td><form:hidden  path="id" /></td>
        </tr>
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
            <td><input type="submit" value="Update" /></td>
        </tr>
    </table>
</form:form>
