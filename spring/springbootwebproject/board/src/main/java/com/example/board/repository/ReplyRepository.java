package com.example.board.repository;

import com.example.board.entity.Board;
import com.example.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {

    @Modifying
    @Query("delete from Reply r where r.board.bno =:bno")
    void deleteByBno(Long bno);

    List<Reply> getRepliesByBoardOrderByRno(Board board);

}
