package com.vportal.vportal.restapi;

import com.vportal.vportal.controller.restapi.NoticeController;
import com.vportal.vportal.service.board.notice.Notice;
import com.vportal.vportal.service.board.notice.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NoticeControllerTest {

    @Autowired
    NoticeService noticeService;

    @Test
    public void testList(){
        List<Notice> list = noticeService.list();

        assertEquals(4, list.size());
    }

}
