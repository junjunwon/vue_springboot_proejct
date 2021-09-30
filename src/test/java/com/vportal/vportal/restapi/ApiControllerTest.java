package com.vportal.vportal.restapi;


import com.vportal.vportal.service.board.Board;
import com.vportal.vportal.service.board.BoardDTO;
import com.vportal.vportal.service.board.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApiControllerTest {


    @Autowired
    private BoardService boardService;

    @Test
    public void testRead() throws Exception{
        Long id = Long.valueOf(1);
        boardService.view(id);
    }

    @Test
    public void testList() throws Exception{
        List<Board> list = boardService.list();
        System.out.print(list.size());

        assertEquals(2, list.size());
    }

    @Test
    public void testSave(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("test title1");
        boardDTO.setContent("test content1");

        BoardDTO result = boardService.post(boardDTO);

        assertEquals("test title1", result.getTitle());
        assertEquals("test content1", result.getContent());
    }

    @Test
    public void testUpdate() throws  Exception{
        List<Board> list = boardService.list();
        Long id = list.get(0).getId();

        BoardDTO boardDTO = new BoardDTO();

        boardDTO.setTitle("test modify22 title");
        boardDTO.setContent("test modify22 content");

        BoardDTO result = boardService.update(boardDTO, id);

        assertEquals("test modify22 title", result.getTitle());
        assertEquals("test modify22 content", result.getContent());
    }

    @Test
    public void testDelete() throws Exception{
        List<Board> list = boardService.list();
        Long id = list.get(0).getId();

        boardService.delete(id);
    }
}
