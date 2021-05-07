package com.example.club.service;

import com.example.club.dto.NoteDto;
import com.example.club.entity.Note;
import com.example.club.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;


    @Override
    public Long register(NoteDto noteDto) {
        Note note = dtoToEntity(noteDto);

        log.info("====================");
        log.info("{}",note);

        noteRepository.save(note);

        return note.getNum();
    }

    @Override
    public NoteDto get(Long num) {
        Optional<Note> result = noteRepository.findById(num);

        if(result.isPresent()){
            return entityToDto(result.get());
        }

        return null;
    }

    @Override
    public void modify(NoteDto noteDto) {
        Long num = noteDto.getNum();
        Optional<Note> result = noteRepository.findById(num);

        if(result.isPresent()){
            Note note = result.get();

            note.changeTitle(note.getTitle());
            note.changeContent(note.getContent());

            noteRepository.save(note);
        }
    }

    @Override
    public void remove(Long num) {
        noteRepository.deleteById(num);
    }

    @Override
    public List<NoteDto> getAllWithWriter(String writerEmail) {

        List<Note> noteList = noteRepository.getList(writerEmail);

        return noteList.stream()
                .map(note -> entityToDto(note))
                .collect(Collectors.toList());
    }
}
