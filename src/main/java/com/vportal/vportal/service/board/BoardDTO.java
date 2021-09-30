package com.vportal.vportal.service.board;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String title;
    private String content;

    public Board toEntity(){
        return Board.builder()
                    .id(id)
                    .title(title)
                    .content(content)
                    .build();
    }

    public BoardDTO(Board board){
        this.id=board.getId();
        this.title=board.getTitle();
        this.content=board.getContent();
    }

}
