package com.ssafy.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.QCommunity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * 커뮤니티 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class CommunityRepositorySupport {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    QCommunity qCommunity = QCommunity.community;


}
