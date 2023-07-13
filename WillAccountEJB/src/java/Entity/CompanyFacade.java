/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Morganne
 */
@Stateless
public class CompanyFacade extends AbstractFacade<Company> implements CompanyFacadeLocal {

    @PersistenceContext(unitName = "WillAccountEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompanyFacade() {
        super(Company.class);
    }

    @Override
    public Company getCompanny(String code, String fname) {
               Query query = em.createQuery("Select c from Company c where c.code=?1 and c.name=?2");
        query.setParameter(1, code);
         query.setParameter(2, fname);
        Company company = (Company)query.getSingleResult();
        return company;
    }
    
}
