/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Morganne
 */
@Stateless
public class JobPostFacade extends AbstractFacade<JobPost> implements JobPostFacadeLocal {

    @PersistenceContext(unitName = "WillAccountEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobPostFacade() {
        super(JobPost.class);
    }
    
}
