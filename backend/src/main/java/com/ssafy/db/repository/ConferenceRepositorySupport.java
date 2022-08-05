package com.ssafy.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.api.request.ConferenceGetReq;
import com.ssafy.db.entity.Conference;
import com.ssafy.db.entity.QConference;
import com.ssafy.db.entity.QUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConferenceRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    QConference qConference = QConference.conference;

    public List<Conference> findByPrfnmContaining(ConferenceGetReq searchInfo) {

        List<Conference> conferences = jpaQueryFactory.select(qConference).from(qConference)
                .where(qConference.sido.eq(searchInfo.getSido()))
                .where(qConference.sigungu.eq(searchInfo.getSigungu()))
                .where(qConference.is_after.eq(searchInfo.is_after()))
                .where(qConference.prfnm.like("%"+searchInfo.getKeyword()+"%"))
                .fetch();

        if(conferences == null) {
            System.out.println("findByPrfnmContaining::::null");
            return null;
        }

        return conferences;
    }

    public List<Conference> findByTitleContaining(ConferenceGetReq searchInfo) {
        List<Conference> conferences = jpaQueryFactory.select(qConference).from(qConference)
                .where(qConference.sido.eq(searchInfo.getSido()))
                .where(qConference.sigungu.eq(searchInfo.getSigungu()))
                .where(qConference.is_after.eq(searchInfo.is_after()))
                .where(qConference.title.like("%"+searchInfo.getKeyword()+"%"))
                .fetch();

        if(conferences == null) {
            System.out.println("findByTitleContaining::::null");
            return null;
        }

        return conferences;
    }
}
