<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Wollen Sie wirklich die Daten von dem Kunden speichert?</h1>

<form:form method="post" modelAttribute="kundeForm" action="/web/listevonkunden">
    <table >
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
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>