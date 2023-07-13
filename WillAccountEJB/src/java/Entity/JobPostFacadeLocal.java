/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Morganne
 */
@Local
public interface JobPostFacadeLocal {

    void create(JobPost jobPost);

    void edit(JobPost jobPost);

    void remove(JobPost jobPost);

    JobPost find(Object id);

    List<JobPost> findAll();

    List<JobPost> findRange(int[] range);

    int count();
    
}
