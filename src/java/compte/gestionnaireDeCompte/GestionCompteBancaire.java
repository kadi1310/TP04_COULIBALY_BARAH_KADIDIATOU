/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compte.gestionnaireDeCompte;

import compte.modeles.compteBancaire;
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

    public void persist(Object object) {
        em.persist(object);
    }
    public void creerUtilisateursDeTest(){
        creerCompteBancaire("coulibaly","barah","cb",21.0);
        creerCompteBancaire("yeo","arielle","ya",22.0);
        creerCompteBancaire("yao","grace","yg",23.0);
        creerCompteBancaire("N'guetta","emmanuel","ne",24.0);
    }
    
     public compteBancaire creerCompteBancaire(String nom, String prenom,String numeroC,Double balance){
        compteBancaire u = new compteBancaire(nom, prenom, numeroC,balance);
        em.persist(u);
        return u;
    }
   
     public Collection<compteBancaire> getAllUsers(){
        Query q = em.createQuery("select u from compteBancaire u");
        return q.getResultList();
    }
}
