package com.ssafy.api.controller;

import com.ssafy.api.response.PerformCarouselRes;
import com.ssafy.api.response.PerformRes;
import com.ssafy.api.service.PerformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 메인페이지 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "메인 API", tags = {"Main"})
@RestController
@RequestMapping("/api/main")
public class MainController {

    @Autowired
    PerformService performService;

    @GetMapping("/performs/ranking")
    @ApiOperation(value = "공연 예매상황판 API 요청", notes = "공연 예매상황판을 가져온다. ")
    public ResponseEntity<List<PerformCarouselRes>> getCarouselList(
            @RequestParam String catecode
    ) {
        //api 호출 -> xml 파싱 -> PerformRes 객체에 담아주기
        List<PerformCarouselRes> res = performService.getCarouselList(catecode);

        return ResponseEntity.status(200).body(res);
    }


}
