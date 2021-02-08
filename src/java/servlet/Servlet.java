/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import compte.gestionnaireDeCompte.GestionCompteBancaire;
import compte.modeles.CompteBancaire;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author coulibaly barah
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
     @EJB
    private GestionCompteBancaire GestionCompteBancaire;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String action = request.getParameter("action");
        String montantS = request.getParameter("montant");
        double balance = Double.valueOf(montantS);
        String forwardTo = "";
        String message = "";
        
        if(action != null){
            if(action.equals("listeAccount")){
                Collection<CompteBancaire> liste = GestionCompteBancaire.getAllCompte();
                request.setAttribute("listeAccount", liste);
                forwardTo = "listAccount.jsp?action=listeAccount";
                message = "Liste des compte bancaire";
                
            }
            else if(action.equals("creerCompteBancaireDeTest")){
                GestionCompteBancaire.creerCompteBancaireDeTest();
                Collection<CompteBancaire> liste = GestionCompteBancaire.getAllCompte();
                request.setAttribute("listeAccount", liste);
                forwardTo = "listAccount.jsp?action=listeAccount";
                message = "Liste des compte bancaire";
            }
            else if(action.equals("createAccount")){
                
               GestionCompteBancaire.creerCompteBancaire(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("numeroC"),balance);
               Collection<CompteBancaire> liste = GestionCompteBancaire.getAllCompte();
                request.setAttribute("listeAccount", liste);
                forwardTo = "listAccount.jsp?action=listeAccount";
                message = "Liste des compte bancaire";
            }
            
            else{
                forwardTo = "index.jsp?action=todo";
                message = "La fonctionnalité pour les paramètre" + action + "est à implémenter !";
                
                
            }
        }
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
        dp.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
