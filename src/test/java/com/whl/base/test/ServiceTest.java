package com.whl.base.test;

import com.whl.base.pojo.User;
import com.whl.base.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Whling
 * @Date: Created in 10:55 2017/1/13
 * @Modified By:
 * @Description:
 */
public class ServiceTest {
    private ApplicationContext applicationContext=null;
    private UserService userService=null;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/applicationContext-*.xml"});
        userService=applicationContext.getBean(UserService.class);
    }

    @Test
    public void testSelect(){
        User user = userService.getByPrimaryKey(12L);
        System.out.println(user.getUsername());
    }
    @Test
    public void testSelectByWhere(){
        //PageInfo<User> pageInfo = userService.getAll(1, 10);
        //List<User> userList = pageInfo.getList();
        //System.out.println(userList.size());
        List<User> userList = userService.getListByWhere(null);
        System.out.println(userList.size());
    }
    @Test
    public void testDelete(){
        List<Object> values=new ArrayList();
        values.add(14);
        values.add(15);
        values.add(16);
        Integer id = userService.deleteByPrimaryKeys(User.class, "id", values);
        System.out.println(id);
    }
    @Test
    public void testInsert(){
        User user=new User();
        user.setUsername("cb");
        user.setPassword("123");
        user.setBirthday(new Date());
        userService.saveSelective(user);
    }
    @Test
    public void testUpdate(){
        User user = userService.getByPrimaryKey(17L);
        user.setDescrible(null);
        user.setBirthday(new Date());
        userService.updateSelective(user);
    }
}
