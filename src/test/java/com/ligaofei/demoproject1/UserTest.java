package com.ligaofei.demoproject1;


import com.ligaofei.demoproject1.controller.UserController;
import com.ligaofei.demoproject1.domain.User;
import com.ligaofei.demoproject1.utils.JsonData;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={DemoProject1Application.class})//启动整个springboot工程
public class UserTest {

    @Autowired
    private UserController userController;

    /**
     * Springboot单元测试Controller层接口
     */
    @Test
    public void loginTest(){

        User user = new User();
        user.setUsername("jack");
        user.setPwd("123");

        JsonData jsonData  = userController.login2(user);

        System.out.println(jsonData.toString());

        //断言测试 判断程序结果是否符合预期
        TestCase.assertEquals(0,jsonData.getCode());

    }

}
