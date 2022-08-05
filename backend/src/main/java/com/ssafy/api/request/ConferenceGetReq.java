package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 화상회의 목록 검색 ([GET] /conferences/search) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("ConferenceGetRequest")
public class ConferenceGetReq {
    //입력해서 넘기는 request body = type(title와 prfnm 중 무엇인지), keyword(입력된 단어), sido, sigungu, is_after

//    @ApiModelProperty(name="회상회의방 제목", example = "레베카 본 사람 여기 다 모여")
//    String title;
//    @ApiModelProperty(name="공연 제목", example = "레베카")
//    String prfnm;
    @ApiModelProperty(name="선택타입", example = "0(공연제목)")
    int type;
    @ApiModelProperty(name="검색단어", example = "레베카")
    String keyword;
    @ApiModelProperty(name="시/도", example = "11 (서울특별시)")
    String sido;
    @ApiModelProperty(name="시/군/구", example = "1114 (중구)")
    String sigungu;
    @ApiModelProperty(name="모두/관람자", example = "관람자만")
    boolean is_after;
}
