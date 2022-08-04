package com.ssafy.api.controller;

import com.ssafy.api.response.ConferenceRes;
import com.ssafy.api.response.PerformRes;
import com.ssafy.api.service.ConferenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 화상회의 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "화상회의채팅방 API", tags = {"Conference"})
@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {

    @Autowired
    ConferenceService conferenceService;

    @GetMapping("")
    @ApiOperation(value = "화상회의 전체 목록 조회 API 요청", notes = "전체 화상회의 목록을 가져온다. ")
    public ResponseEntity<List<ConferenceRes>> getConferenceAllList() {

       List<ConferenceRes> res = conferenceService.getConferenceAllList();

        return ResponseEntity.status(200).body(res);
    }
}
