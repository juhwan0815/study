package study.index.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

    @PersistenceContext
    private EntityManager em;

    private JPAQueryFactory queryFactory(){
        return new JPAQueryFactory(em);
    }
}
