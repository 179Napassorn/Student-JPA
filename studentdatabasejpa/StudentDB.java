
package studentdatabasejpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class StudentDB {


    public static void main(String[] args) {
        
        Student stu;
        stu = StudentTable.findStudentById(1);
        if (stu != null) {
            stu.setName("Jack");
            StudentTable.removeStudent(stu);
            StudentTable.updateStudent(stu);
        }
        List<Student> stuList = StudentTable.findStudentByName("Marry");
        
    }

    public static void printAllStudent(List<Student> StudentList) {
        for (Student stu : StudentList) {
            System.out.print(stu.getId() + " ");
            System.out.print(stu.getName() + " ");
            System.out.println(stu.getGpa() + " ");
        }
    }

    // insert code : use entity manager
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}

