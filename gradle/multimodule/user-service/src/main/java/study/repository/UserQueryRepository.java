package study.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.domain.QUser;
import study.domain.User;

import static study.domain.QUser.*;

@Repository
@RequiredArgsConstructor
public class UserQueryRepository {

    private final JPAQueryFactory queryFactory;

    public User findById(Long id) {
        return queryFactory.selectFrom(QUser.user)
                .where(QUser.user.id.eq(id))
                .fetchOne();
    }
}
