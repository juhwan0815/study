package spring.study.replication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.replication.domain.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
