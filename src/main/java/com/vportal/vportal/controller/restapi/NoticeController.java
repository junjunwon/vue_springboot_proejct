package com.vportal.vportal.controller.restapi;


import com.vportal.vportal.controller.ApiResult;
import com.vportal.vportal.service.board.notice.Notice;
import com.vportal.vportal.service.board.notice.NoticeDTO;
import com.vportal.vportal.service.board.notice.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class NoticeController {

    NoticeService noticeService;

    @GetMapping("/api/notices")
    public ApiResult<List<Notice>> getAll(){
        List<Notice> list = noticeService.list();

        return ApiResult.<List<Notice>>builder()
                .data(list)
                .build();
    }

    @PostMapping("/api/notices/save")
    public ResponseEntity<?> save(@PathVariable("noticeId") int noticeId, NoticeDTO noticeDTO){
        try{
            return new ResponseEntity<NoticeDTO>(noticeService.save(noticeDTO), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }



}
