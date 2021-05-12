package com.example.practicetest.repository;

import com.example.practicetest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByEmail(String email);

    @Query("select distinct m from Member m join fetch m.orderList where m.id =:memberId")
    Optional<Member> findWithOrderById(@Param("memberId") Long memberId);

    @Query("select distinct m from Member m join fetch m.orderList")
    List<Member> findAllWithOrder();

}
