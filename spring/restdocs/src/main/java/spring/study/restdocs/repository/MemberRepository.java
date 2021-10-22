package spring.study.restdocs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.restdocs.domain.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
