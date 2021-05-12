package com.example.practicetest.repository;

import com.example.practicetest.domain.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static com.example.practicetest.domain.QOrder.*;
import static org.assertj.core.api.Assertions.assertThat;
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 데이터베이스

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // 내장 데이터베이스
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EntityManager em;

    private JPAQueryFactory queryFactory;

    @BeforeEach
    public void setUp(){
        queryFactory = new JPAQueryFactory(em);
    }

    @AfterEach
    public void afterEach(){
        orderRepository.deleteAll();
        memberRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    @DisplayName("회원 저장")
    void saveMember(){
        Member member = Member.createMember("juwom0831@naver.com", "황주환", "010-2058-4660");

        Member savedMember = memberRepository.save(member);

        assertThat(member).isEqualTo(savedMember);
        assertThat(savedMember.getId()).isNotNull();
    }

    @Test
    @DisplayName("회원 수정")
    void updateMember(){
        Member member = Member.createMember("juwom0831@naver.com", "황주환", "010-2058-4660");
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId()).get();
        findMember.changeMember("황철원","010-3598-1748");

        assertThat(findMember.getId()).isEqualTo(savedMember.getId());
        assertThat(findMember.getName()).isEqualTo("황철원");
        assertThat(findMember.getPhoneNumber()).isEqualTo("010-3598-1748");
    }

    @Test
    @DisplayName("회원-주문리스트 조회")
    void findMemberById(){
        Member member = Member.createMember("juwom0831@naver.com", "황주환", "010-2058-4660");
        Member savedMember = memberRepository.save(member);

        Product product = Product.createProduct("라면", 100, 500);
        productRepository.save(product);

        Order order1 = Order.createOrder(5, member, product);
        Order order2 = Order.createOrder(5, member, product);
        orderRepository.save(order1);
        orderRepository.save(order2);

        em.flush();
        em.clear();

        Member findMember = memberRepository.findWithOrderById(savedMember.getId()).get();
        assertThat(findMember.getOrderList().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("회원리스트 - 주문 리스트 조회")
    void findMembers(){
        Member member = Member.createMember("juwom0831@naver.com", "황주환", "010-2058-4660");
        Member savedMember = memberRepository.save(member);

        Member member2 = Member.createMember("juwom0815@naver.com", "황철원", "010-3598-1748");
        Member savedMember2 = memberRepository.save(member2);

        Product product = Product.createProduct("라면", 100, 500);
        productRepository.save(product);

        Order order1 = Order.createOrder(5, member, product);
        Order order2 = Order.createOrder(5, member, product);
        orderRepository.save(order1);
        orderRepository.save(order2);

        Order order3 = Order.createOrder(5, member2, product);
        Order order4 = Order.createOrder(5, member2, product);
        orderRepository.save(order3);
        orderRepository.save(order4);

        em.flush();
        em.clear();

        List<Member> memberList = memberRepository.findAllWithOrder();
        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList.get(0).getOrderList().size()).isEqualTo(2);
        assertThat(memberList.get(1).getOrderList().size()).isEqualTo(2);
    }




}