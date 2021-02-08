<%-- 
    Document   : index
    Created on : 5 févr. 2021, 20:45:10
    Author     : coulibaly barah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="styleCss.css" />
        <title>Gestionnaire des Comptes Bancaire</title>
    </head>
    <body>
        <h1>Gestionnaire des Comptes Bancaire</h1>


        <!-- Message qui s'affiche lorsque la page est appelé avec un paramètre http message -->
        <c:if test="${!empty param['message']}">
            <h2>Reçu message : ${param.message}</h2>
        </c:if>


        <h2>Menu de gestion des comptes</h2>
        <ul>
            <li><a href="listAccount.jsp?action=listeAccount">Accéder à la liste de tous les comptes</a></li>
            <p>
        </ul>
            <ol>
           
            <li>Créer un compte</li>
            <form action="Servlet" method="get">
                <label> Nom :</label> <input type="text" name="nom"/><br>
                <label>Prénom : </label><input type="text" name="prenom"/><br>
                <label>Numéro de compte :</label> <input type="text" name="numeroC"/><br>
                <label>Balance : </label><input type="text" name="montant"/><br>
                <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->
                <input type="hidden" name="action" value="createAccount"/>
                <input type="submit" value="Créer le compte" name="submit"/>
            </form>
        </ol>

        <!-- Fin du menu -->

       
    </body>
</html>