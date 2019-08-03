<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Füge neuen Kunden hinzu</h1>

<style>
    .error{color:red}
</style>

<form:form method="post" modelAttribute="kundeForm" action="/web/kundeweiterleiten">
    <table>

        <tr>
            <td>Steuer ID :</td>
            <td>
                <div class="ui input"><form:input path="steuerId" /></div>
            </td>
            <td>
                <form:errors path="steuerId" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Name :</td>
            <td>
                <div class="ui input"><form:input path="name" /></div>
            </td>
            <td>
                <form:errors path="name" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Nachname :</td>
            <td>
                <div class="ui input"><form:input path="nachname"/></div>
            </td>
            <td>
                <form:errors path="nachname" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Geburtsdatum :</td>
            <td>
                <div class="ui input"><form:input path="birthDate" id="datepickeraddkunde" /></div>
            </td>
            <td>
                <form:errors path="birthDate" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>KundeArt :</td>
            <td>
                <form:select path="kundeArt" cssClass="ui dropdown" items="${kundeArtMap}" />
            </td>
            <td>
                <form:errors path="kundeArt" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save" class="ui button"/></td>
        </tr>

    </table>
</form:form>
