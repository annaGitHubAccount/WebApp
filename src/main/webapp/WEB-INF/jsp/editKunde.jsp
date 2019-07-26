<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Edit Kunde</h1>

<form:form modelAttribute="kundeForm" action="/web/kundeweiterleitenedit">
    <table >
        <tr>
            <td><form:hidden  path="id" /></td>
        </tr>
        <tr>
            <td>Steuer ID : </td>
            <td><form:input path="steuerId"  /></td>
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
            <td>Date of Birth :</td>
            <td><form:input path="birthDate" id="datepickereditkunde" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Update" /></td>
        </tr>
    </table>
</form:form>
