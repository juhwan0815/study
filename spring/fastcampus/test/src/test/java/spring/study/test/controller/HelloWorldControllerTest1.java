package spring.study.test.controller;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;
    
    @Mock // 이 클래스를 mock을 생성해서  위에 주입
    private PersonRepository personRepository;

    @Test
    void getPeopleByName(){
        // Mock객체의 행동을 집적정의해준다.
        Mockito.when(personRepository.findByName("martin")) // 만약 이렇게 호출되면
                .thenReturn(Lists.newArrayList(new Person("martin"))); // 이렇게 리턴한다.

        List<Person> result = personService.getPeopleByName("martin");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("martin");
    }

    @Test
    void getPerson(){
        Mockito.when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("martin")));

        Person person = personService.getPerson(1L);

        assertThat(person.getName).isEqualTo("martin");
    }

    @Test
    void put(){
        PersonDto dto = PersonDto("martin");

        personService.put(dto);

        verify(personRepository,times(1)).save(any(Person.class)); // 검증
    }

    @Test
    void modifyIfPersonNotFound(){
        Mockito.when(personRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> personService.modify(1,personUpdateDto()));
    }

}