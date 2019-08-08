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
            <td>
                <h1>Meldeanschrift</h1>
            </td>
        </tr>

        <tr>
            <td>Land :</td>
            <td>
                <div class="ui input"><form:input path="landVonMeldeanschrift"/></div>
            </td>
        </tr>
        <tr>
            <td>Ort :</td>
            <td>
                <div class="ui input"><form:input path="ortVonMeldeanschrift"/></div>
            </td>
        </tr>
        <tr>
            <td>Strasse :</td>
            <td>
                <div class="ui input"><form:input path="strasseVonMeldeanschrift"/></div>
            </td>
        </tr>
        <tr>
            <td>Haus Nr. :</td>
            <td>
                <div class="ui input"><form:input path="hausNrVonMeldeanschrift"/></div>
            </td>
        </tr>

        <tr>
            <td>
                <h1>Postanschrift</h1>
            </td>
        </tr>

        <tr>
            <td>Land :</td>
            <td>
                <div class="ui input"><form:input path="landVonPostanschrift"/></div>
            </td>
        </tr>
        <tr>
            <td>Ort :</td>
            <td>
                <div class="ui input"><form:input path="ortVonPostanschrift"/></div>
            </td>
        </tr>
        <tr>
            <td>Strasse :</td>
            <td>
                <div class="ui input"><form:input path="strasseVonPostanschrift"/></div>
            </td>
        </tr>
        <tr>
            <td>Haus Nr. :</td>
            <td>
                <div class="ui input"><form:input path="hausNrVonPostanschrift"/></div>
            </td>
        </tr>

        
        <tr>
            <td> </td>
            <td><input type="submit" value="Update" /></td>
        </tr>
    </table>
</form:form>
