package com.ssafy.api.service;

import com.ssafy.api.response.AdminStopUserRes;
import com.ssafy.db.entity.QUser;
import com.ssafy.db.entity.QUserReport;
import com.ssafy.db.repository.AdminRepository;
import com.ssafy.db.repository.AdminRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("AdminService")
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminRepositorySupport adminRepositorySupport;

    QUserReport qUserReport = QUserReport.userReport;
    QUser qUser = QUser.user;

    @Override
    public List<AdminStopUserRes> getStopUserAllList() {

        List<AdminStopUserRes> userReportList = adminRepositorySupport.findAllGroupByUserSerial();

        List<AdminStopUserRes> res = new ArrayList<>();

        System.out.println(userReportList.size());
        for (AdminStopUserRes report : userReportList) {
            //각 ID에 해당하는 신고당한 횟수 가져온 뒤 같이 저장해주기
            long reportCnt = adminRepositorySupport.countByUserId(report.getUser_id());

            AdminStopUserRes stopRes = new AdminStopUserRes();

            stopRes.setUser_id(report.getUser_id());
            stopRes.setName(report.getName());
            stopRes.setLatest_report_day(report.getLatest_report_day());
            stopRes.setIs_ban(report.getIs_ban());
            stopRes.setReport_cnt(reportCnt);

            res.add(stopRes);
        }

        return res;
    }

    @Override
    public List<AdminStopUserRes> searchStopUserList(String name) {
        List<AdminStopUserRes> userReportList = adminRepositorySupport.findByUserId(name);

        List<AdminStopUserRes> res = new ArrayList<>();

        System.out.println(userReportList.size());
        for (AdminStopUserRes report : userReportList) {
            //각 ID에 해당하는 신고당한 횟수 가져온 뒤 같이 저장해주기
            long reportCnt = adminRepositorySupport.countByUserId(report.getUser_id());

            AdminStopUserRes stopRes = new AdminStopUserRes();

            stopRes.setUser_id(report.getUser_id());
            stopRes.setName(report.getName());
            stopRes.setLatest_report_day(report.getLatest_report_day());
            stopRes.setIs_ban(report.getIs_ban());
            stopRes.setReport_cnt(reportCnt);

            res.add(stopRes);
        }

        return res;
    }
}
