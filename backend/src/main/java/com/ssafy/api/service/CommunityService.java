package com.ssafy.api.service;

import com.ssafy.api.request.CommunityRegistPostReq;
import com.ssafy.api.response.CommunityRes;
import com.ssafy.db.entity.Community;
import com.ssafy.db.entity.User;

import java.util.List;

public interface CommunityService {
    Community createArticle(User userInfo, CommunityRegistPostReq communityRegisterInfo);

    List<CommunityRes> getArticleListByGenre(int genre, int category);

    List<CommunityRes> getAllArticleList();
}
