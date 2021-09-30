package com.vportal.vportal.service.board;


import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {

    private BoardRepository boardRepository;

    public List<Board> list(){
        List<Board> list = boardRepository.findAll();

        return list;
    }

    public void delete(Long id) throws Exception{
        this.view(id);
        boardRepository.deleteById(id);
    }

    public BoardDTO update(BoardDTO model, Long id) throws Exception {
        BoardDTO boardDTO = this.view(id);

        boardDTO.setTitle(model.getTitle());
        boardDTO.setContent(model.getContent());
        boardDTO.setId(id);
        Board result = boardRepository.save(boardDTO.toEntity());
        return new BoardDTO(result);
    }

    public BoardDTO post(BoardDTO model) {
        Board result = boardRepository.save(model.toEntity());
        return new BoardDTO(result);
    }

    public BoardDTO view(Long id) throws Exception{
        Optional<Board> board = boardRepository.findById(id);

        if(board.isPresent()){
            return new BoardDTO(board.get());
        } else{
            throw new NotFoundException("리소스를 찾을 수 없습니다.");
        }
    }
}
