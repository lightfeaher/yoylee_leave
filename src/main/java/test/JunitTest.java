package test;

import com.qihang.model.Leave;
import com.qihang.serviceImpl.LeaveServiceImpl;
import com.qihang.serviceImpl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
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
    @Autowired
    UserServiceImpl userService;

    @Before
    public void init(){

    }
    @Test
    public void coutMd5Pass() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String newpass = base64en.encode(md5.digest("123123".getBytes("utf-8")));
        System.out.println(newpass);
    }
    //测试方法
    @Test
    public void testCURD(){

        //测试根据user得到对象
        List<Leave> leaves = leaveService.getLeaveByUser("3",1);
        System.out.println(leaves);

        //测试插入Leave对象
//        Date sqlDate = new java.sql.Date(new Date().getTime());
//        Leave leave = new Leave(5,"asf","1","2","1","1","23","wer","w","fw",sqlDate);
//        System.out.println(leaveService.addLeave(leave));
        //测试根据条件得到姓名
//        String[] strings = userService.getUserNameByRiSy(2,1);
//        for (String s :strings){
//            System.out.println(s);
//        }
//        System.out.println( new java.sql.Date(new Date().getTime()) );


        //测试demo
//        List<Leave> leaves = leaveService.GetAllLeave();
//        for (Leave lea :leaves){
//            System.out.println(lea.toString());
//        }

    }
}
