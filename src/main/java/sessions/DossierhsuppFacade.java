/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Dossierhsupp;

/**
 *
 * @author Mounir
 */
@Stateless
public class DossierhsuppFacade extends AbstractFacade<Dossierhsupp> {

    @PersistenceContext(unitName = "AppFinanciere")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DossierhsuppFacade() {
        super(Dossierhsupp.class);
    }
    
}