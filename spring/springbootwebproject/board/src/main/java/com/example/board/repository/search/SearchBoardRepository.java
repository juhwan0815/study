package com.example.board.repository.search;

import com.example.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {

    Board search1();

    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
