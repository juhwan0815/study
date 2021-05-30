package juhwan.study.javatest.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Study {

    @Id @GeneratedValue
    private Long id;
    private StudyStatus status = StudyStatus.DRAFT;
    private int limitCount;
    private String name;

    private LocalDateTime openedDateTime;
    private Long ownerId;

    public Study(int limit, String name) {
        this.limitCount = limit;
        this.name = name;
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야 한다.");
        }
        this.limitCount = limit;
    }

    public void open() {
        this.openedDateTime = LocalDateTime.now();
        this.status = StudyStatus.OPENED;
    }

}