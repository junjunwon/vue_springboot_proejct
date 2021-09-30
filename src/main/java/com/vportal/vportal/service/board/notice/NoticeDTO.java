package com.vportal.vportal.service.board.notice;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeDTO {

    private int noticeId;
    private String title;
    private String contents;

    public Notice toEntity(){
        return Notice.builder()
                .noticeId(noticeId)
                .title(title)
                .contents(contents)
                .build();
    }

    public NoticeDTO(Notice notice){
        this.noticeId=notice.getNoticeId();
        this.title=notice.getTitle();
        this.contents=notice.getContents();
    }
}
