package com.ssafy.db.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.api.response.AdminStopUserRes;
import com.ssafy.db.entity.QUser;
import com.ssafy.db.entity.QUserReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepositorySupport {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    QUserReport qUserReport = QUserReport.userReport;
    QUser qUser = QUser.user;

    public List<AdminStopUserRes> findAllGroupByUserSerial() {
        List<AdminStopUserRes> userReports= jpaQueryFactory.select(Projections.fields (AdminStopUserRes.class,
                        qUserReport.user_id.as("user_id"),
                        qUser.name.as("name"),
                        qUserReport.latest_report_day.max().as("latest_report_day"),
                        qUser.is_ban.as("is_ban")))
                .from(qUserReport, qUser)
                .where(qUserReport.user_id.eq(qUser.userId))
                .groupBy(qUserReport.user_id)
                .fetch();

        userReports.forEach(System.out::println);

        return userReports;
    }

    public long countByUserId(String user_id) {
        if(user_id==null) return 0;

        long cnt = jpaQueryFactory.select(qUserReport).from(qUserReport)
                .where(qUserReport.user_id.eq(user_id))
                .fetchCount();

        return cnt;
    }
}
