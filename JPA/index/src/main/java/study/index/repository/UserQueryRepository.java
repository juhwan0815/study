package study.index.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.index.domain.User;

import java.util.List;

import static study.index.domain.QUser.user;

@Repository
@RequiredArgsConstructor
public class UserQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<User> findLegacy(String name, int pageNum, int pageSize){
        List<User> users = queryFactory
                .selectFrom(user)
                .where(user.name.like(name + "%"))
                .orderBy(user.id.desc())
                .limit(pageSize)
                .offset(pageNum * pageSize)
                .fetch();
        return users;
    }

    public List<User> findNoOffset(Long userId, String name, int pageSize){
        List<User> users = queryFactory
                .selectFrom(user)
                .where(ltUserId(userId),
                        user.name.like(name + "%"))
                .orderBy(user.id.desc())
                .limit(pageSize)
                .fetch();
        return users;
    }

    private BooleanExpression ltUserId(Long userId){
        if( userId == null){
            return  null;
        }
        return user.id.lt(userId);
    }
}
