package spring.study.restdocs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

    private Long id;

    private String name;
}
