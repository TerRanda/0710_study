package com.tj.edu.practice5.repository;

import com.tj.edu.practice4.aop.dto.User;
import com.tj.edu.practice5.model.Member;
import com.tj.edu.practice5.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class EntityManagerTest {
    @Autowired
    private EntityManagerFactory emf;
    //@Autowired
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Test
    void entityManagerTest() {
        em.createQuery("select u from Member u").getResultList().forEach(s -> System.out.println(s));
    }
    @Test
    @Transactional
    // OSIV (Open Session In View) -> transaction
    //No EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call - Error code
    void entityManagerTest2() {
        Member member = Member.builder()
                .name("aaaa")
                .email("abcde@gmail.com")
                .build();

        em.persist(member);//Jpa 영속성 상태 존재.

        memberRepository.findAll().forEach(System.out::println);
    }
    @Test
    @Transactional
        // OSIV (Open Session In View) -> transaction
        //No EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call - Error code
    @Commit
//    @Rollback(false)
    void entityManagerTest3() {
        Users users = Users.builder()
                .name("둘리")
                .build();

        usersRepository.save(users);
        em.persist(users);//Jpa 영속성 관리 상태로 저장.

//        em.detach(users); //준영속성 상태
        users.setEmail("dool-li@gmail.com");

//        em.flush(); //SQL query문 실행.
        // detach랑 remove랑 같이 못 쓰는 이유.
        // detach는 준영속성 상태. 엔티티가 아닌 상태가 된다.
//        em.clear(); //초기화
//        em.merge(users); // 준영속성 -> 영속성 상태로 변경.
//        em.remove(users); // 비영속성으로 삭제 상태.
//        System.out.println(usersRepository.findByName("둘리").get(0));
        usersRepository.findAll().forEach(System.out::println);
//        구문 빠져나갈 때 데이터 반영
    }
    @Test
//    @Transactional
    void cacheEntityFindTest() {
//        System.out.println(memberRepository.findByEmail("faker13@t1esports.com"));
//        System.out.println(memberRepository.findByEmail("gumayusi@t1esports.com"));
//        System.out.println(memberRepository.findByEmail("faker13@t1esports.com"));

//        System.out.println(memberRepository.findById(8L));
//        System.out.println(memberRepository.findById(8L));
//        System.out.println(memberRepository.findById(8L));

        memberRepository.deleteById(1L);
    }

    @Test
    void cacheEntityFindTest2() {
        Member member = memberRepository.findById(1L).get();
        member.setName("고길동");

//        memberRepository.save(member);
//        memberRepository.flush();
        memberRepository.saveAndFlush(member);
        System.out.println("-----------------------1");

        member.setEmail("goGildong@gmail.com");
//        memberRepository.save(member);
//        memberRepository.flush();
        memberRepository.saveAndFlush(member);
        System.out.println("-----------------------2");
    }

    @Test
    @Transactional
    @Commit //commit을 해야 데이터베이스에 적용.
    void persistCacheDelayInsertUpdateTest() {

        Users user = usersRepository.findById(1L).get();    //select, dirty check(변경감지) -> 쓰기지연 일어남.

        user.setName("비둘기사기단");
        usersRepository.save(user); //select, update

//        user.setEmail("guguFake@esports.com");
//        usersRepository.save(user); //select, update
    }

}
