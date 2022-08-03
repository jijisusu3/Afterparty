package com.ssafy.api.service;

import com.ssafy.api.request.CommunityRegistPostReq;
import com.ssafy.db.entity.Community;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService{
    //차송희 커뮤니티 시작-------------------------------------------
    @Autowired
    CommunityRepository communityRepository;

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
    //차송희 커뮤니티 끝-------------------------------------------
}
