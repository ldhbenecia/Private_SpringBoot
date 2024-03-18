package hellojpa;

import hellojpa.jpql.JpqlMember;
import hellojpa.jpql.JpqlTeam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            JpqlTeam team = new JpqlTeam();
            team.setName("teamA");
            em.persist(team);

            JpqlMember member = new JpqlMember();
            member.setName("MemberA");
            member.setAge(25);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            String innerJoinQuery = "select m from JpqlMember m join m.team t";
            String leftOuterJoinQuery = "select m from JpqlMember m left join m.team t";
            List<JpqlMember> result = em.createQuery(innerJoinQuery, JpqlMember.class)
                    .getResultList();

            List<JpqlMember> result2 = em.createQuery(leftOuterJoinQuery, JpqlMember.class)
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
