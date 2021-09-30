package com.vportal.vportal.service.board.notice;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="vweb_board_notice")
@Getter
@NoArgsConstructor
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int noticeId;

    private String title;

    private String contents;

    private Date createDate;

    private Date updateDate;

    private String writerId;

    private String writerName;

    private String isImportant;

    private String popupPosition;

    private Date popupFirstDate;

    private Date popupLastDate;

    private String popupWidth;

    private String popupHeight;

    @Transient
    private String fileList;

    @Transient
    private List<MultipartFile> files;

    @Transient
    private List<FileInfo> fileInfos;

    @Builder
    public Notice(int noticeId, String title, String contents, Date createDate,
                  Date updateDate, String writerId, String writerName,
                  String isImportant, String popupPosition, Date popupFirstDate, Date popupLastDate,
                  String popupWidth, String popupHeight, String fileList, List<MultipartFile> files, List<FileInfo> fileInfos){
        this.noticeId=noticeId;
        this.title=title;
        this.contents=contents;
        this.createDate=createDate;
        this.updateDate=updateDate;
        this.writerId=writerId;
        this.writerName=writerName;
        this.isImportant=isImportant;
        this.popupPosition=popupPosition;
        this.popupFirstDate=popupFirstDate;
        this.popupLastDate=popupLastDate;
        this.popupWidth=popupWidth;
        this.popupHeight=popupHeight;
        this.fileList=fileList;
        this.files=files;
        this.fileInfos=fileInfos;
    }
}
