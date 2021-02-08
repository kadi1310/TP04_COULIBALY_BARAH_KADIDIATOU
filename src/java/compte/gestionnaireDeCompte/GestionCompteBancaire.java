/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compte.gestionnaireDeCompte;

import compte.modeles.CompteBancaire;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author coulibaly barah
 */
@Stateless
public class GestionCompteBancaire {
    @PersistenceContext(unitName = "TP04_COULIBALY_BARAH_KADIDIATOUPU")
    private EntityManager em;

   
    public void creerCompteBancaireDeTest(){
        creerCompteBancaire("coulibaly","barah","cb",21.0);
        creerCompteBancaire("yeo","arielle","ya",22.0);
        creerCompteBancaire("yao","grace","yg",23.0);
        creerCompteBancaire("N'guetta","emmanuel","ne",24.0);
    }
    
     public CompteBancaire creerCompteBancaire(String nom, String prenom,String numeroC,double balance){
        CompteBancaire u = new CompteBancaire(nom, prenom, numeroC,balance);
        em.persist(u);
        return u;
    }
     
   
     public Collection<CompteBancaire> getAllCompte(){
        Query q = em.createQuery("select u from CompteBancaire u");
        return q.getResultList();
    }
     
     
     
      public void persist(Object object) {
        em.persist(object);
    }
}
