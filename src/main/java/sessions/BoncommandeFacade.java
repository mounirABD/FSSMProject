/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Boncommande;

/**
 *
 * @author Mounir
 */
@Stateless
public class BoncommandeFacade extends AbstractFacade<Boncommande> {

    @PersistenceContext(unitName = "AppFinanciere")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoncommandeFacade() {
        super(Boncommande.class);
    }
    
}
