<%-- 
    Document   : listAccount
    Created on : 6 févr. 2021, 21:37:17
    Author     : coulibaly barah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="styleCss.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Zone qui affiche les utilisateurs si le paramètre action vaut listerComptes -->
        <c:if test="${param['action'] == 'listeAccount'}" >
            <h2>Liste des Comptes Bancaire</h2>

            <table border="10">
                <!-- La ligne de titre du tableau des comptes -->
                <tr>
                    <td><b>Numéro de Compte</b></td>
                    <td><b>Nom</b></td>
                    <td><b>Prénom</b></td>
                     <td><b>Balance</b></td>
                </tr>

                <!-- Ici on affiche les lignes, une par utilisateur -->
                <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->
                <c:set var="total" value="0"/>

                <c:forEach var="u" items="${requestScope['listeAccount']}">
                    <tr>
                        <td>${u.accountNumber}</td>
                        <td>${u.firstName}</td>
                        <td>${u.lastName}</td>
                        <td>${u.balance}</td>
                        <!-- On compte le nombre de users -->
                        <c:set var="total" value="${total+1}"/>
                    </tr>
                </c:forEach>

                <!-- Affichage du solde total dans la dernière ligne du tableau -->
                <tr><td><b>TOTAL</b></td><td></td><td><b>${total}</b></td><td></td></tr>
            </table>

        </c:if>
            <input type="submit" value="Retour" name="submit"/>
    </body>
</html>
