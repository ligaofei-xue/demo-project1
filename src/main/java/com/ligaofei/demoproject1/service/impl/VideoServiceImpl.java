package com.ligaofei.demoproject1.service.impl;


import com.ligaofei.demoproject1.domain.Video;
import com.ligaofei.demoproject1.mapper.VideoMapper;
import com.ligaofei.demoproject1.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper VideoMapper;

    @Override
    public List<Video> listVideo() {
        return VideoMapper.listVideo();
    }
}
