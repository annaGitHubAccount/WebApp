<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Wollen Sie wirklich das Produkt speichern?</h1>

<form:form method="post" modelAttribute="produktStammdatenForm" action="/web/saveproduktstammdaten">
    <table >

        <tr>
            <td>Name : </td>
            <td>${produktStammdatenForm.name}</td>
        </tr>
        <tr>
            <td>Preis :</td>
            <td>${produktStammdatenForm.preis}</td>
        </tr>
        <tr>
            <td>Is Aktiv ? :</td>
            <td>${produktStammdatenForm.aktiv}</td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" class="ui button"/></td>
        </tr>
    </table>

    <form:hidden path="name"/>
    <form:hidden path="preis"/>
    <form:hidden path="aktiv"/>

</form:form>
