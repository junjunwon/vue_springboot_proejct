package com.vportal.vportal.service.board.notice;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoticeService {

    private NoticeRepository noticeRepository;

    public List<Notice> list(){
        List<Notice> list = noticeRepository.findAll();
        return list;
    }

    public NoticeDTO save(NoticeDTO noticeDTO) {
        Notice notice = noticeRepository.save(noticeDTO.toEntity());
        return new NoticeDTO(notice);
    }
}
