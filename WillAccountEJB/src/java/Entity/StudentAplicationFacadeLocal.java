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
public interface StudentAplicationFacadeLocal {

    void create(StudentAplication studentAplication);

    void edit(StudentAplication studentAplication);

    void remove(StudentAplication studentAplication);

    StudentAplication find(Object id);

    List<StudentAplication> findAll();

    List<StudentAplication> findRange(int[] range);

    int count();
    
}
