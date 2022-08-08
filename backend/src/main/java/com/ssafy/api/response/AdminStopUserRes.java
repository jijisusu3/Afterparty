package com.ssafy.api.response;

import com.ssafy.db.entity.UserReport;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ApiModel("AdminStopUserListResponse")
public class AdminStopUserRes {
    //신고당한 유저 아이디
    String user_id;
    //신고된 유저 네임
    String name;
    //신고된 횟수
    long report_cnt;
    //유저의 정지 여부
    Boolean is_ban;
    //마지막 신고 날짜
    LocalDateTime latest_report_day;

//    public AdminStopUserRes() {}
//
//    public AdminStopUserRes(String user_id, String name, Boolean is_ban, LocalDateTime latest_report_day) {
//        this.user_id = user_id;
//        this.name = name;
//        this.is_ban = is_ban;
//        this.latest_report_day = latest_report_day;
//    }
}
