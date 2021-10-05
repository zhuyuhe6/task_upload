package com.marcus.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.marcus.mybatisplus.mapper.UserMapper;
import com.marcus.mybatisplus.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author marcus
 * @version 2.0
 * @date 2020/10/7 0:41
 */

@RestController
public class UserComplexController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/test")
    public List<User> contextLoad() {
        // 查询name不为null的用户，并且邮箱不为null的用户，年龄大于等于20的用户
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 12);
        userMapper.selectList(userQueryWrapper).forEach(System.out::println);
        return userMapper.selectList(userQueryWrapper);   // 查询多个数据 selectList
    }

    @GetMapping("/user/getName/{name}")
    public User getName(@PathVariable("name") String name) {
        // 查询name为输入参数的用户
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", name);
        return userMapper.selectOne(userQueryWrapper);  // 查询一个数据 selectOne
    }

    @GetMapping("/user/getAgeBetween")
    public int getAgeBetween(){
        // 查询年龄在20~30岁之间的用户
        QueryWrapper<User> userQueryWrapper =new QueryWrapper<>();
        userQueryWrapper.between("age",20,30);
        Integer count = userMapper.selectCount(userQueryWrapper);//查询结果数
        return count;
    }

    // 模糊查询
    @GetMapping("/user/like")
    public List<Map<String, Object>>  like(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 模糊查询 like notlike likeRight
        userQueryWrapper
                .notLike("name","s")         // 相当于NOT LIKE '%s%'
                .likeRight("email","test")   // 相当于LIKE 's%'
                .likeLeft("email", "com");   // 相当于LIKE '%s'
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);  // 查询结果数 selectMaps
        maps.forEach(System.out::println);
        return maps;
    }

    @GetMapping("/user/sqlInSql")
    public List<Object> sqlInSql(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 子查询 id在子查询中查询出来
        userQueryWrapper.inSql("id", "select id from user where id < 3");
        List<Object> objects = userMapper.selectObjs(userQueryWrapper); // selectObjs 查询objects 因为返回的就是List<Integer(id)>
        objects.forEach(System.out::println);
        return objects;
    }


    @GetMapping("/user/order")
    public List<User> order(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 通过id进行排序
        userQueryWrapper.orderByAsc("id");  // orderByAsc orderByDesc
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
        return users;
    }
}
