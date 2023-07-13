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
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "WillAccountEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public Student logIn(String identification, int snumber) {
        Query query = em.createQuery("Select c from Student c where c.identification=?1 and c.studentNumber=?2");
        query.setParameter(1, identification);
         query.setParameter(2, snumber);
        Student student = (Student)query.getSingleResult();
        return student;
    }
    
}
