<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Wollen Sie wirklich die Daten von dem Kunden speichern?</h1>

<form:form method="post" modelAttribute="kundeForm" action="/web/savekunde">
    <table >
        <tr>
            <td>Steuer ID : </td>
            <td>${kundeForm.steuerId}</td>
        </tr>
        <tr>
            <td>Name : </td>
            <td>${kundeForm.name}</td>
        </tr>
        <tr>
            <td>Nachname :</td>
            <td>${kundeForm.nachname}</td>
        </tr>
        <tr>
            <td>Date of Birth :</td>
            <td>${kundeForm.birthDate}</td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" class="ui button"/></td>
        </tr>
    </table>

    <form:hidden path="id" />
    <form:hidden path="steuerId"/>
    <form:hidden path="name"/>
    <form:hidden path="nachname"/>
    <form:hidden path="birthDate"/>
</form:form>
