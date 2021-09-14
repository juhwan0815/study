package com.redis.study.redis.repository.redis;

import com.redis.study.redis.domain.redis.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void redisHash_Insert() {
        Long studentId = 1L;
        String name = "행복하라";

        Student student = Student
                .builder()
                .studentId(studentId)
                .name(name)
                .build();

        studentRepository.save(student);

        Student cachedStudent = studentRepository.findById(studentId).orElse(null);
        assertThat(cachedStudent).isNotNull();
        assertThat(cachedStudent.getStudentId()).isEqualTo(1L);
        assertThat(cachedStudent.getName()).isEqualTo(name);
    }

    @Test
    public void redisHash_update(){
        Long studentId = 1L;
        String name = "행복하라";
        Student student = Student
                .builder()
                .studentId(studentId)
                .name(name)
                .build();

        student.update("정직하라");
        studentRepository.save(student);

        Student cachedStudent = studentRepository.findById(studentId).orElse(null);
        assertThat(cachedStudent).isNotNull();
        assertThat(cachedStudent.getStudentId()).isEqualTo(1L);
        assertThat(cachedStudent.getName()).isEqualTo("정직하라");
    }
}