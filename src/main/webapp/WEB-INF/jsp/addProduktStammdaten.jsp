<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Füge neuen Produktstammdaten hinzu</h1>

<style>
    .error {
        color: red
    }
</style>

<form:form method="post" modelAttribute="produktStammdatenForm" action="/web/produktstammdatenweiterleiten">
    <table>

        <tr>
            <td>Name :</td>
            <td>
                <div class="ui input"><form:input path="name"/></div>
            </td>
            <td>
                <form:errors path="name" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Preis :</td>
            <td>
                <div class="ui input"><form:input path="preis"/></div>
            </td>
            <td>
                <form:errors path="preis" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Is Aktiv ? :</td>
            <td>
                <form:checkbox path="aktiv" cssClass="ui checkbox"/>
            </td>
            <td>
                <form:errors path="aktiv" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save" class="ui button"/></td>
        </tr>
    </table>

</form:form>