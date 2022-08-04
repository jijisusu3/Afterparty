package com.ssafy.api.controller;

import com.ssafy.api.request.CommunityRegistPostReq;
import com.ssafy.api.request.UserInfoFetchReq;
import com.ssafy.api.response.CommunityRes;
import com.ssafy.api.response.UserRes;
import com.ssafy.api.service.CommunityService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Comment;
import com.ssafy.db.entity.Community;
import com.ssafy.db.entity.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 커뮤니치 관련 API 요청 처리를 위한 컨트롤러 정의.
 */

@Api(value = "커뮤니티 API", tags = {"Community"})
@RestController
@RequestMapping("/api/communities")
public class CommunityController {

    @Autowired
    CommunityService communityService;

    //차송희 시작-----------------------------------
    @PostMapping("")
    @ApiOperation(value = "커뮤니티 글 작성", notes = "로그인 후 글 작성 가능")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> alticleRegister(
            @RequestBody @ApiParam(value = "글 작성 정보", required = true) CommunityRegistPostReq communityRegisterInfo
            ,@ApiIgnore Authentication authentication) {

        /**
         * 요청 헤더 액세스 토큰이 포함된 경우에만 실행되는 인증 처리이후, 리턴되는 인증 정보 객체(authentication) 통해서 요청한 유저 식별.
         * 액세스 토큰이 없이 요청하는 경우, 403 에러({"error": "Forbidden", "message": "Access Denied"}) 발생.
         */
        SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
        User user = userDetails.getUser();
        System.out.println("====user==="+user);
//        long userSerial = user.getId();
        Community community = communityService.createArticle(user, communityRegisterInfo);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }


    @GetMapping("/all")
    @ApiOperation(value = "전체 게시글 목록 조회", notes = "전체 게시글 목록을 조회한다.")
    public ResponseEntity<List<CommunityRes>> getAllArticleList(){
        List<CommunityRes> res = communityService.getAllArticleList();
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("")
    @ApiOperation(value = "장르/카테고리별 게시글 목록 조회", notes = "장르/카테고리별 게시글 목록을 조회한다.")
    public ResponseEntity<List<CommunityRes>> getArticleList(
            @RequestParam @ApiParam(required = true) int genre,
            @RequestParam @ApiParam(required = true) int category) {
        List<CommunityRes> res = communityService.getArticleListByGenre(genre,category);
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/{article_id}")
    @ApiOperation(value = "게시글 상세보기", notes="게시글 상세조회를 실행한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = " 사용 가능"),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<Community> getArticleDetails(@PathVariable long article_id){
        Community community = communityService.getArticleByArticleId(article_id);

        return ResponseEntity.status(200).body(community);
    }
    //------------차송희 끝---------------------------------
}
