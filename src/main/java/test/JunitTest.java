package test;

import com.qihang.model.Leave;
import com.qihang.serviceImpl.LeaveServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;


/*
* 测试类
* 对service相关CRUD进行测试
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JunitTest {
    //自动注入对象
    @Autowired
    LeaveServiceImpl leaveService;

    //测试方法
    @Test
    public void testCURD(){

        List<Leave> leaves = leaveService.GetAllLeave();
        for (Leave lea :leaves){
            System.out.println(lea.toString());
        }

    }
}
