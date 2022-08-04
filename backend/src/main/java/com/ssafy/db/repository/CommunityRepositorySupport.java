package com.ssafy.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Community;
import com.ssafy.db.entity.QCommunity;
import com.ssafy.db.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 커뮤니티 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class CommunityRepositorySupport{
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QCommunity qCommunity = QCommunity.community;

    public List<Community> findCommunityListByGenre(int genre, int category) {
        List<Community> communities = jpaQueryFactory.select(qCommunity).from(qCommunity)
                .where(qCommunity.article_genre.eq(genre),qCommunity.article_category.eq(category)).fetch();
        if(communities==null) return null;
        return communities;
    }

    public List<Community> findAllCommunityList() {
        List<Community> communities = jpaQueryFactory.select(qCommunity).from(qCommunity).fetch();
        if(communities == null) return null;
        return communities;
    }
}
