package com.ssafy.api.service;

import com.ssafy.api.response.ConferenceRes;
import com.ssafy.db.entity.Conference;
import com.ssafy.db.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ConferenceService")
public class ConferenceServiceImpl implements ConferenceService{

    @Autowired
    ConferenceRepository conferenceRepository;

    @Override
    public List<ConferenceRes> getConferenceAllList() {
        List<Conference> conferenceList = conferenceRepository.findAll();

        List<ConferenceRes> res = new ArrayList<>();

        for (Conference conference : conferenceList) {
            //db에서 불러온 conference 정보에서 필요한 정보만 conferenceRes에 담아 목록 만들어주기
            res.add(ConferenceRes.of(conference));
        }

        return res;
    }
}
