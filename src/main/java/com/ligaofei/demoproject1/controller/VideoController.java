package com.ligaofei.demoproject1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ligaofei.demoproject1.domain.Video;
import com.ligaofei.demoproject1.service.VideoService;
import com.ligaofei.demoproject1.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 视频控制器
 */

//@Controller
@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    //@RequestMapping("list")
    @GetMapping("list")
    //@PostMapping("list")
    //@ResponseBody
    //@RequestMapping(value = "list",method = RequestMethod.GET)
    public JsonData list() throws JsonProcessingException {
        List<Video> list = videoService.listVideo();

        //序列化操作
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(list);
        System.out.println(jsonStr);
        //反序列化操作
        List<Video> temp = objectMapper.readValue(jsonStr,List.class);

        return JsonData.buildSuccess(temp);
    }

    /**
     * 数组对象提交
     * 请求协议application/json
     * 例如：
     * {
     *     "id":1,
     *     "title":"dsdsd",
     *     "summary":"summary",
     *     "price":"11",
     *     "coverImg":"coverImg",
     *     "chapterList":[
     *         {
     *             "videoId":1,
     *             "title":"title"
     *         },
     *          {
     *             "videoId":2,
     *             "title":"title"
     *         },
     *         ]
     * }
     * @param video
     * @return
     */
    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video){
        System.out.println(video.toString());
        return JsonData.buildSuccess(video);
    }
}
