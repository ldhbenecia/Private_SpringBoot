package hellojpa;

import hellojpa.domain.Child;
import hellojpa.domain.Member;
import hellojpa.domain.Parent;
import hellojpa.domain.Team;
import hellojpa.jpql.JpqlMember;
import hellojpa.training.Address;
import hellojpa.training.OrderMember;
import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Address address = new Address("city", "street", "zipcode");

            JpqlMember member = new JpqlMember();
            member.setName("MemberA");
            member.setAge(25);
            em.persist(member);
            
            TypedQuery<JpqlMember> query = em.createQuery("select m from JpqlMember m where m.name = :username", JpqlMember.class);
            query.setParameter("username", "MemberA");
            JpqlMember singleResult = query.getSingleResult();
            System.out.println("-----------------------------------------------");
            System.out.println("singleResult = " + singleResult);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
