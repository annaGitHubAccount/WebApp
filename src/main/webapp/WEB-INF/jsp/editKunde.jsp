<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Edit Kunde</h1>

<form:form modelAttribute="kundeForm" action="/web/kundeweiterleitenedit">
    <table >
        <tr>
            <td><div class="ui input"><form:hidden  path="id" /></div></td>
        </tr>
        <tr>
            <td>Steuer ID : </td>
            <td><div class="ui input"><form:input path="steuerId"  /></div></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><div class="ui input"><form:input path="name"  /></div></td>
        </tr>
        <tr>
            <td>Nachname :</td>
            <td><div class="ui input"><form:input path="nachname" /></div></td>
        </tr>
        <tr>
            <td>Date of Birth :</td>
            <td><div class="ui input"><form:input path="birthDate" id="datepickereditkunde" /></div></td>
        </tr>
        <tr>
            <td>KundeArt :</td>
            <td><form:select path="kundeArt" cssClass="ui dropdown" items="${kundeArtMap}" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Update" /></td>
        </tr>
    </table>
</form:form>
