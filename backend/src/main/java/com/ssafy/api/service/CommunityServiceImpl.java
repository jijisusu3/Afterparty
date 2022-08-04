package com.ssafy.api.service;

import com.ssafy.api.request.CommunityRegistPostReq;
import com.ssafy.api.response.CommunityRes;
import com.ssafy.api.response.FollowingRes;
import com.ssafy.db.entity.Community;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.CommunityRepository;
import com.ssafy.db.repository.CommunityRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService{
    //차송희 커뮤니티 시작-------------------------------------------
    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    CommunityRepositorySupport communityRepositorySupport;

    @Override
    public Community createArticle(User userInfo, CommunityRegistPostReq communityRegisterInfo) {
        Community community = new Community();
        community.setArticle_genre(communityRegisterInfo.getAlticle_genre());
        community.setArticle_category(communityRegisterInfo.getAlticle_category());
        community.setArticle_title(communityRegisterInfo.getAlticle_title());
        community.setArticle_content(communityRegisterInfo.getAlticle_content());
        community.setUser(userInfo);
        return communityRepository.save(community);
    }
    //장르별 글 목록 가져오기
    @Override
    public List<CommunityRes> getArticleListByGenre(int genre, int category) {
        List<Community> communityList = communityRepositorySupport.findCommunityListByGenre(genre, category);
        List<CommunityRes> res = new ArrayList<>();
        for(Community commu : communityList){
            res.add(CommunityRes.of(commu.getArticle_title(),
                    commu.getUser().getUserId(),
                    commu.getView_cnt(),
                    commu.getRecommend()));
        }
        return res;
    }

    //전체 글 목록 가져오기
    @Override
    public List<CommunityRes> getAllArticleList() {
        List<Community> communityList = communityRepositorySupport.findAllCommunityList();
        List<CommunityRes> res = new ArrayList<>();
        for(Community commu: communityList){
            res.add(CommunityRes.of(commu.getArticle_title(),
                    commu.getUser().getUserId(),
                    commu.getView_cnt(),
                    commu.getRecommend()));
        }
        return res;
    }
    //차송희 커뮤니티 끝-------------------------------------------
}
