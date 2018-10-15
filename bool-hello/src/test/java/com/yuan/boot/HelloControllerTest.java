package com.yuan.boot;

import com.yuan.boot.utils.LoggerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * HelloController的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //自动配置MockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;
/**
 * 测试hello请求
 */
    @Test
    public void hello() {
        //使用MockMvc类来实现单元测试
        try {
           String response =  mockMvc.perform(MockMvcRequestBuilders.get("http://localhost/hello/index"))
                   .andExpect(status().isOk())//验证状态码
                    .andReturn().getResponse().getContentAsString();
            LoggerUtil.getLogger(HelloControllerTest.class).trace("测试响应的信息--->"+response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}