<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
    .error {
        color: red
    }
</style>

<form:form method="post" modelAttribute="kundeForm" action="/web/kundeweiterleiten">

    <table>
        <tr>
            <td>

                <div id="tabs">
                    <ul>
                        <li><a href="#kunde">Fuege neuen Kunden hinzu</a></li>
                        <li><a href="#meldeanschrift">Meldeanschrift</a></li>
                        <li><a href="#postanschrift">Postanschrift</a></li>
                    </ul>

                    <div id="kunde">
                        <table>
                            <tr>
                                <td>Steuer ID :</td>
                                <td>
                                    <div class="ui input"><form:input path="steuerId"/></div>
                                </td>
                                <td>
                                    <form:errors path="steuerId" cssClass="error"/>
                                </td>
                            </tr>
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
                                <td>Nachname :</td>
                                <td>
                                    <div class="ui input"><form:input path="nachname"/></div>
                                </td>
                                <td>
                                    <form:errors path="nachname" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Geburtsdatum :</td>
                                <td>
                                    <div class="ui input"><form:input path="birthDate" id="datepickeraddkunde"/></div>
                                </td>
                                <td>
                                    <form:errors path="birthDate" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>KundeArt :</td>
                                <td>
                                    <form:select path="kundeArt" cssClass="ui dropdown" items="${kundeArtMap}"/>
                                </td>
                                <td>
                                    <form:errors path="kundeArt" cssClass="error"/>
                                </td>
                            </tr>
                        </table>
                    </div>

                    <div id="meldeanschrift">
                        <table>
                            <tr>
                                <td>Land :</td>
                                <td>
                                    <div class="ui input"><form:input path="landVonMeldeanschrift"/></div>
                                </td>
                                <td>
                                    <form:errors path="landVonMeldeanschrift" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Ort :</td>
                                <td>
                                    <div class="ui input"><form:input path="ortVonMeldeanschrift"/></div>
                                </td>
                                <td>
                                    <form:errors path="ortVonMeldeanschrift" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Strasse :</td>
                                <td>
                                    <div class="ui input"><form:input path="strasseVonMeldeanschrift"/></div>
                                </td>
                                <td>
                                    <form:errors path="strasseVonMeldeanschrift" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Haus Nr. :</td>
                                <td>
                                    <div class="ui input"><form:input path="hausNrVonMeldeanschrift"/></div>
                                </td>
                                <td>
                                    <form:errors path="hausNrVonMeldeanschrift" cssClass="error"/>
                                </td>
                            </tr>
                        </table>
                    </div>

                    <div id="postanschrift">
                        <table>
                            <tr>
                                <td><label for="checkboxPostanschriftID">Aktiviere Postanschrift:</label></td>
                                <td><input type="checkbox" id="checkboxPostanschriftID"></td>
                            </tr>
                            <tr>
                                <td>Land :</td>
                                <td>
                                    <div class="ui input"><form:input path="landVonPostanschrift" id="landVonPostanschriftID" disabled="true"/></div>
                                </td>
                                <td>
                                    <form:errors path="landVonPostanschrift" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Ort :</td>
                                <td>
                                    <div class="ui input"><form:input path="ortVonPostanschrift" id="ortVonPostanschriftID" disabled="true"/></div>
                                </td>
                                <td>
                                    <form:errors path="ortVonPostanschrift" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Strasse :</td>
                                <td>
                                    <div class="ui input"><form:input path="strasseVonPostanschrift" id="strasseVonPostanschriftID" disabled="true" /></div>
                                </td>
                                <td>
                                    <form:errors path="strasseVonPostanschrift" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Haus Nr. :</td>
                                <td>
                                    <div class="ui input"><form:input path="hausNrVonPostanschrift" id="hausNrVonPostanschriftID" disabled="true" /></div>
                                </td>
                                <td>
                                    <form:errors path="hausNrVonPostanschrift" cssClass="error"/>
                                </td>
                            </tr>
                        </table>
                    </div>

                </div>

            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="Save" class="ui button"/>
            </td>
        </tr>
    </table>

</form:form>

<script>

    var checkbox = document.getElementById("checkboxPostanschriftID");

    checkbox.addEventListener("change", function () {

        if(checkbox.checked){
            document.getElementById("landVonPostanschriftID").disabled = false;
            document.getElementById("ortVonPostanschriftID").disabled = false;
            document.getElementById("strasseVonPostanschriftID").disabled = false;
            document.getElementById("hausNrVonPostanschriftID").disabled = false;
        }else {
            document.getElementById("landVonPostanschriftID").disabled = true;
            document.getElementById("ortVonPostanschriftID").disabled = true;
            document.getElementById("strasseVonPostanschriftID").disabled = true;
            document.getElementById("hausNrVonPostanschriftID").disabled = true;
        }
    });
</script>
