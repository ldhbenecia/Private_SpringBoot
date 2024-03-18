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

            em.flush();
            em.clear();

            em.createQuery("select m from JpqlMember m order by m.age desc", JpqlMember.class)
                    .setFirstResult(0) // 조회 시작 위치
                    .setMaxResults(10) // 조회할 데이터 수
                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
