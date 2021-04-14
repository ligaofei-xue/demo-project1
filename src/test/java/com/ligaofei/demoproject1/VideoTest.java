package com.ligaofei.demoproject1;


import com.ligaofei.demoproject1.domain.Video;
import com.ligaofei.demoproject1.service.VideoService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;

@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={DemoProject1Application.class})//启动整个springboot工程
@AutoConfigureMockMvc//测试Controller对外提供的接口
public class VideoTest {

    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void testOne(){

        System.out.println("这个是测试 before 开始前执行的操作");
    }




    @Test
    public void testTwo1(){

        System.out.println("这个是测试 test1");

        //判断程序结果是否符合预期
        TestCase.assertEquals(1,3);
    }



    @Test
    public void testTwo2(){

        System.out.println("这个是测试 test2");
    }

    /**
     * Springboot单元测试Service层接口
     */
    @Test
    public void testVideoList(){

        List<Video> videoList = videoService.listVideo();
        //判断程序结果是否符合预期
        TestCase.assertTrue(videoList.size()>0);

    }

    @After
    public void testThree(){

        System.out.println("这个是测试 after 完成后执行的操作");
    }


    @Test
    public void testVideoListApi()throws Exception{

        MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        int status = mvcResult.getResponse().getStatus();

        System.out.println(status);

        //会乱码
        //String result = mvcResult.getResponse().getContentAsString();

        // 使用下面这个，增加 编码 说明，就不会乱码打印
        String result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));

        System.out.println(result);

    }

}
