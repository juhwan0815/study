package spring.study.teststudy.study;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.teststudy.domain.Study;

public interface StudyRepository extends JpaRepository<Study, Long> {

}