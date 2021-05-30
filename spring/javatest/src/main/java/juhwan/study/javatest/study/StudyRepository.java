package juhwan.study.javatest.study;

import juhwan.study.javatest.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {

}
