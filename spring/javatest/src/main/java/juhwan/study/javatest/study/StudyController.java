package juhwan.study.javatest.study;

import juhwan.study.javatest.domain.Study;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyRepository studyRepository;

    @GetMapping("/study/{id}")
    public Study getStudy(@PathVariable Long id){
        return studyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("study not found for" + id ));
    }

    @PostMapping("/study")
    public Study createStudy(@RequestBody Study study){
        return studyRepository.save(study);
    }
}
