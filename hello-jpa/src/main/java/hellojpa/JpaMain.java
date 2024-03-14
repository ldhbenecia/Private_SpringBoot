package hellojpa;

import hellojpa.domain.Child;
import hellojpa.domain.Member;
import hellojpa.domain.Parent;
import hellojpa.domain.Team;
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

            OrderMember member = new OrderMember();
            member.setName("MemberA");
            member.setAddress(address);
            em.persist(member);

            em.flush();

            List<OrderMember> result2 = em.createNativeQuery("select order_member_id, city, street, zipcode, name from OrderMember").getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
