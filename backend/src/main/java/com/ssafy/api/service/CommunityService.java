package com.ssafy.api.service;

import com.ssafy.api.request.CommunityRegistPostReq;
import com.ssafy.db.entity.Community;
import com.ssafy.db.entity.User;

public interface CommunityService {
    Community createArticle(User userInfo, CommunityRegistPostReq communityRegisterInfo);
}
