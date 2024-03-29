<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Wollen Sie wirklich die Daten von dem Kunden speichern?</h1>

<form:form method="post" modelAttribute="kundeForm" action="/web/savekunde">
    <table>
        <tr>
            <td>Steuer ID :</td>
            <td>${kundeForm.steuerId}</td>
        </tr>
        <tr>
            <td>Name :</td>
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
            <td>KundeArt :</td>
            <td>${kundeForm.kundeArt}</td>
        </tr>


        <tr>
            <td>
                <h1>Meldeanschrift</h1>
            </td>
        </tr>
        <tr>
            <td>Land :</td>
            <td>${kundeForm.landVonMeldeanschrift}</td>
        </tr>
        <tr>
            <td>Ort :</td>
            <td>${kundeForm.ortVonMeldeanschrift}</td>
        </tr>
        <tr>
            <td>Strasse :</td>
            <td>${kundeForm.strasseVonMeldeanschrift}</td>
        </tr>
        <tr>
            <td>Haus Nr. :</td>
            <td>${kundeForm.hausNrVonMeldeanschrift}</td>
        </tr>


        <tr>
            <td>
                <h1>Postanschrift</h1>
            </td>
        </tr>
        <tr>
            <td>Land :</td>
            <td>${kundeForm.landVonPostanschrift}</td>
        </tr>
        <tr>
            <td>Ort :</td>
            <td>${kundeForm.ortVonPostanschrift}</td>
        </tr>
        <tr>
            <td>Strasse :</td>
            <td>${kundeForm.strasseVonPostanschrift}</td>
        </tr>
        <tr>
            <td>Haus Nr. :</td>
            <td>${kundeForm.hausNrVonPostanschrift}</td>
        </tr>


        <tr>
            <td>
                <h1>Ausgewaehle Produkte :</h1>
            </td>
        </tr>
        <tr>
            <td>
                <c:forEach items="${kundeForm.produktList}" var="produkt">

                    <ul>
                        <li>${produkt.name}</li>
                    </ul>

                </c:forEach>
            </td>
        </tr>


        <tr>
            <td colspan="2"><input type="submit" value="Save" class="ui button"/></td>
        </tr>
    </table>

    <form:hidden path="name"/>
    <form:hidden path="nachname"/>
    <form:hidden path="steuerId"/>
    <form:hidden path="birthDate"/>
    <form:hidden path="kundeArt"/>

    <form:hidden path="landVonMeldeanschrift"/>
    <form:hidden path="ortVonMeldeanschrift"/>
    <form:hidden path="strasseVonMeldeanschrift"/>
    <form:hidden path="hausNrVonMeldeanschrift"/>

    <form:hidden path="landVonPostanschrift"/>
    <form:hidden path="ortVonPostanschrift"/>
    <form:hidden path="strasseVonPostanschrift"/>
    <form:hidden path="hausNrVonPostanschrift"/>

</form:form>
