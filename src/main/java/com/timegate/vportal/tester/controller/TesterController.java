package com.timegate.vportal.tester.controller;

import com.timegate.vportal.tester.domain.TesterDto;
import com.timegate.vportal.tester.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value="/tester")
public class TesterController {

    @Autowired
    TesterService testerService;

    @PostMapping("/saveTester")
    public ResponseEntity<TesterDto> saveTester(@ModelAttribute TesterDto testerDto) {
        TesterDto returnTesterDto = testerService.saveTester(testerDto);

        return ResponseEntity.ok(returnTesterDto);
    }

    @RequestMapping("/removeTester")
    public ResponseEntity<Boolean> removeTester(@ModelAttribute TesterDto testerDto) {
        boolean returnValue = testerService.removeTester(testerDto);

        return ResponseEntity.ok(returnValue);
    }

    @RequestMapping("/getTester")
    public ResponseEntity<List<TesterDto>> getTester(@ModelAttribute TesterDto testerDto) {
       var returnTesterDto = testerService.getTester(testerDto);
       //var returnTesterDto = testerService.findByQuerydsl(testerDto);

        return ResponseEntity.ok(returnTesterDto);
    }

    @RequestMapping("/getTesterName")
    public ResponseEntity<List<TesterDto>> getTesterName(@RequestParam("name") String name) {
        TesterDto testerDto = new TesterDto();
        testerDto.setName(name);
        var returnTesterDto = testerService.getTester(testerDto);
        return ResponseEntity.ok(returnTesterDto);
    }

    @RequestMapping("/getTesterNameEmail")
    public ResponseEntity<List<TesterDto>> getTesterNameEmail(
            @RequestParam("name") String name
            , @RequestParam("email") String email) {
        TesterDto testerDto = new TesterDto();
        testerDto.setName(name);
        testerDto.setEmail(email);
        var returnTesterDto = testerService.getTester(testerDto);
        return ResponseEntity.ok(returnTesterDto);
    }
}
