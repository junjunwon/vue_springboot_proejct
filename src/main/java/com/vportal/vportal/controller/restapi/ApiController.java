package com.vportal.vportal.controller.restapi;

import java.util.List;

import com.vportal.vportal.controller.ApiResult;

import com.vportal.vportal.service.board.Board;
import com.vportal.vportal.service.board.BoardDTO;
import com.vportal.vportal.service.board.BoardService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ApiController {
    
    BoardService boardService;

    @GetMapping("/api/boards")
    public ApiResult<List<Board>> getAll(){
        List<Board> list = boardService.list();

        return ApiResult.<List<Board>>builder()
                    .data(list)
                    .build();
    }

    @GetMapping("/api/boards/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable("id") Long id){
        ResponseEntity<?> entity = null;

        try{
            entity = new ResponseEntity<BoardDTO>(boardService.view(id), HttpStatus.OK);
        } catch (NotFoundException e){
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return entity;

    }

    @PostMapping("/api/boards/post")
    public ResponseEntity<?> create(@RequestBody final BoardDTO boardDTO){
        try{
            return new ResponseEntity<BoardDTO>(boardService.post(boardDTO), HttpStatus.OK);
        } catch (final Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/api/boards/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody BoardDTO boardDTO){
        try{
            return new ResponseEntity<BoardDTO>(boardService.update(boardDTO, id), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/api/boards/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){

        ResponseEntity<?> entity = null;

        try{
            boardService.delete(id);
            entity = new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(Exception e){
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return entity;
    }

}
