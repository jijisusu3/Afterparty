package com.ssafy.api.service;

import com.ssafy.api.response.AdminStopUserRes;

import java.util.List;

public interface AdminService {
    List<AdminStopUserRes> getStopUserAllList();
}
