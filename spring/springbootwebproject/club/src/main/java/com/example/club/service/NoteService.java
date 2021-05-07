package com.example.club.service;

import com.example.club.dto.NoteDto;
import com.example.club.entity.ClubMember;
import com.example.club.entity.Note;

import java.util.List;

public interface NoteService {

    Long register(NoteDto noteDto);

    NoteDto get(Long num);

    void modify(NoteDto noteDto);

    void remove(Long num);

    List<NoteDto> getAllWithWriter(String writerEmail);

    default Note dtoToEntity(NoteDto noteDto){
        Note note = Note.builder()
                .num(noteDto.getNum())
                .title(noteDto.getTitle())
                .content(noteDto.getContent())
                .writer(ClubMember.builder()
                        .email(noteDto.getWriterEmail())
                        .build())
                .build();

        return note;
    }

    default NoteDto entityToDto(Note note){
        NoteDto noteDto = NoteDto.builder()
                .num(note.getNum())
                .title(note.getTitle())
                .content(note.getContent())
                .writerEmail(note.getWriter().getEmail())
                .regDate(note.getRegDate())
                .modDate(note.getModDate())
                .build();

        return noteDto;
    }

}
