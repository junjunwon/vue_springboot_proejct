package com.vportal.vportal.service.board;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.vportal.vportal.service.auditor.Auditor;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board extends Auditor<String> {
    
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    
    private String content;

    @Builder
    public Board(Long id, String title, String content){
        this.id = id;
        this.title =title;
        this.content = content;
    }

}
