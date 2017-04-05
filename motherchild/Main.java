package motherchild;

import java.util.List;
import javax.persistence.*;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MotherChildPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        // C R E A T E
        Mother mother = new Mother();
        em.persist(mother);
        
        Child child = new Child(mother);
        em.persist(child);
        
        // U P D A T E
        mother.setName("Maria");
        child.setName("Jesus");        

        // D E L E T E       
        em.remove(child); 
        em.remove(mother);
        
        em.getTransaction().commit();

        // R E A D
        Query query = em.createQuery("SELECT Mother FROM Mother mother"); // JPQL
        List<Mother> mothers = query.getResultList();

        em.close();
        emf.close();
    }    
}
