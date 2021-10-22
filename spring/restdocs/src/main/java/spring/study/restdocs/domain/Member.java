package spring.study.restdocs.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private Integer age;

    public static Member createMember(String name,Integer age){
        Member member = new Member();
        member.name = name;
        member.age = age;
        return member;
    }

}
