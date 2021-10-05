package com.marcus.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.marcus.mybatisplus.mapper.UserMapper;
import com.marcus.mybatisplus.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author marcus
 * @version 2.0
 * @date 2020/10/5 19:29
 */

@Api(value = "users接口",description="users服务API根目录")
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    // select *
    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("/user")
    public List<User> user() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        return users;
    }

    // insert
    @ApiOperation(value="用户插入", notes="")
    @GetMapping("/user/insert")
    public User insert(@RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "age", required = false) Integer age,
                       @RequestParam(value = "email", required = false) String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        userMapper.insert(user);
        return user;
    }

    // update
    @ApiOperation(value="用户更新", notes="")
    @GetMapping("/user/update")
    public void update(@RequestParam("id") Integer id,
                       @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "age", required = false) Integer age,
                       @RequestParam(value = "email", required = false) String email) {
        // 需要这么写才能使update自动填充正常执行
        // 如果不自动填充update，User user = userMapper.selectById(id); 再set即可
        User user = new User();                     // 先new一个user
        User userTemp = userMapper.selectById(id);  // 通过userTemp初始化new的user
        user.setName(userTemp.getName());
        user.setAge(userTemp.getAge());
        user.setEmail(userTemp.getEmail());
        user.setId(id);                             // 再将传入的参数覆盖初始化的user
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        userMapper.updateById(user);                // 最后update
    }

    // 测试乐观锁成功
    @ApiOperation(value="乐观锁1", notes="")
    @GetMapping("/version1")
    public void testVersionSuccess(){
        // 1. 查询用户信息
        User user = userMapper.selectById(1);
        // 2. 修改用户信息
        user.setName("fan");
        user.setAge(24);
        // 3. 执行更新操作
        userMapper.updateById(user);
    }

    // 测试乐观锁失败!多线程下
    @ApiOperation(value="乐观锁2", notes="")
    @GetMapping("/version2")
    public void testVersionFall(){
        // 线程1先set了user，但没update
        User user1 = userMapper.selectById(1);
        user1.setName("fan111");
        user1.setAge(14);

        // 线程2 设置值之后就update了
        User user2 = userMapper.selectById(1);
        user2.setName("fan222");
        user2.setAge(24);
        userMapper.updateById(user2);

        // 最后update的结果 下面线程1的update这行不执行 因为上面线程1和2select到的version一样，2已经+1了，1就不行了
        // 回想CAS 通过stamp的原子引用，防止ABA的问题
        // 可以通过自旋锁来多次尝试提交！while (!lock)...
        userMapper.updateById(user1); //如果没有乐观锁就会覆盖插队线程的值
    }

    // 测试查询
    @ApiOperation(value="通过id查询用户", notes="")
    @GetMapping("/user/get/{id}")
    public User testSelectById(@PathVariable("id") Integer id){
        User user = userMapper.selectById(id);
        return user;
    }

    // 批量查询  selectBatchIds(Arrays.asList(1, 2, 3))
    @ApiOperation(value="获取全部用户", notes="")
    @GetMapping("/user/get/all")
    public List<User> testSelectByBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
        return users;
    }

    // 按照条件查询之一使用 map selectByMap(map)
    @ApiOperation(value="按条件查询用户", notes="")
    @GetMapping("/user/get/map")
    public List<User> testSelectByMap(@RequestParam("name") String name,
                                      @RequestParam("age") Integer age){
        Map<String, Object> map = new HashMap<>();
        // 自定义要查询
        map.put("name", name);
        map.put("age", age);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
        return users;
    }

    //测试分页查询
    @ApiOperation(value="测试分页查询", notes="")
    @GetMapping("/pagination")
    public Page<User> testPage(@RequestParam("current") Integer current,
                               @RequestParam("size") Integer size){
        // 参数一：当前页 比如2
        // 参数二：页面大小 比如5
        // 使用了分页插件之后，所有的分页操作也变得简单了
        Page<User> page = new Page<>(current,size);
        // 直接返回第current页，size个数据
        Page<User> userPage = userMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
        //获取总数
        System.out.println(page.getTotal());
        return userPage;
    }

    // 测试删除
    @ApiOperation(value="通过id删除用户", notes="")
    @GetMapping("/user/delete/{id}")
    public void testdelete(@PathVariable("id") Integer id){
        userMapper.deleteById(id);
    }

    // 测试批量删除
    @ApiOperation(value="批量删除", notes="")
    @GetMapping("/user/delete/all")
    public void testdeleteBatchId(){
        userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
    }

    //通过map删除
    @ApiOperation(value="通过map删除", notes="")
    @GetMapping("/user/delete/map")
    public void testDeleteByMap(@RequestParam("name") String name){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        userMapper.deleteByMap(map);
    }

    //




}
