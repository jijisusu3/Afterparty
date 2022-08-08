package com.ssafy.api.controller;

import com.ssafy.api.response.AdminStopUserRes;
import com.ssafy.api.response.ConferenceRes;
import com.ssafy.api.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 관리자 페이지 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "관리자 API", tags = {"Admin"})
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/users")
    @ApiOperation(value = "정지된 유저 전체 목록 조회", notes = "정지된 유저의 전체 목록을 가져온다. ")
    public ResponseEntity<List<AdminStopUserRes>> getStopUserAllList() {

        List<AdminStopUserRes> res = adminService.getStopUserAllList();

        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/users/{userId}")
    @ApiOperation(value = "정지된 유저 전체 목록 조회", notes = "정지된 유저의 전체 목록을 가져온다. ")
    public ResponseEntity<List<AdminStopUserRes>> searchStopUserList(@PathVariable String userId) {

        List<AdminStopUserRes> res = adminService.searchStopUserList(userId);

        return ResponseEntity.status(200).body(res);
    }
}
