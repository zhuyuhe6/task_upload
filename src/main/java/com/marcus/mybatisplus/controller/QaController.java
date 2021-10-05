package com.marcus.mybatisplus.controller;


import com.marcus.mybatisplus.mapper.QaMapper;
import com.marcus.mybatisplus.pojo.Qa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yuhe Zhu
 * @version 2.0
 * @date 2020/10/14 14:06
 */

@Api(value = "qa接口",description="qa服务API根目录")
@RestController
public class QaController {
    @Autowired
    QaMapper qaMapper;

    // select *
    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("/qa")
    public List<Qa> qa() {
        List<Qa> qas = qaMapper.selectList(null);
        qas.forEach(System.out::println);
        return qas;
    }

    // insert
    @ApiOperation(value="QA信息插入", notes="")
    @GetMapping("/qa/insert")
    public Qa insert(@RequestParam(value = "Operator", required = false) String Operator,
                     @RequestParam(value = "date_time", required = false) String date_time,
                     @RequestParam(value = "doublecheck_total", required = false) Integer doublecheck_total,
                     @RequestParam(value = "doublecheck_wrong", required = false) Integer doublecheck_wrong,
                     @RequestParam(value = "argue_success", required = false) Integer argue_success,
                     @RequestParam(value = "other_notcheck", required = false) Float other_notcheck,
                     @RequestParam(value = "other_meeting", required = false) Float other_meeting,
                     @RequestParam(value = "other_manage", required = false) Float other_manage,
                     @RequestParam(value = "other_training", required = false) Float other_training,
                     @RequestParam(value = "other_other[]", required = false) String other_other,
                     @RequestParam(value = "task_info[]", required = false) String task_info) {
        Qa qa = new Qa();
        qa.setOperator(Operator);
        qa.setDateTime(date_time);
        qa.setDoublecheckTotal(doublecheck_total);
        qa.setDoublecheckWrong(doublecheck_wrong);
        qa.setArgueSuccess(argue_success);
        qa.setOtherNotcheck(other_notcheck);
        qa.setOtherMeeting(other_meeting);
        qa.setOtherManage(other_manage);
        qa.setOtherTraining(other_training);
        qa.setOtherOther("["+other_other+"]");
        qa.setTaskInfo("["+task_info+"]");
        qaMapper.insert(qa);
        return qa;
    }


    /*

    // update
    @ApiOperation(value="标注更新", notes="")
    @GetMapping("/biaozhu/update")
    public void update(@RequestParam(value = "Operator", required = false) String Operator,
                       @RequestParam(value = "date_time", required = false) String date_time,
                       @RequestParam(value = "other_program", required = false) Float other_program,
                       @RequestParam(value = "other_manage", required = false) Float other_manage,
                       @RequestParam(value = "other_training", required = false) Float other_training,
                       @RequestParam(value = "other_other", required = false) Float other_other,
                       @RequestParam(value = "task_info", required = false) String task_info,
                       @RequestParam(value = "check_info", required = false) String check_info,
                       @RequestParam(value = "double_info", required = false) String double_info) {
        // 需要这么写才能使update自动填充正常执行
        // 如果不自动填充update，Biaozhu biaozhu = biaozhuMapper.selectByOperator(Operator); 再set即可
        Biaozhu biaozhu = new Biaozhu();                     // 先new一个user
        Biaozhu biaozhuTemp = biaozhuMapper.selectById(Operator);  // 通过userTemp初始化new的user
        biaozhu.setOperator(biaozhuTemp.getOperator());
        biaozhu.setAge(userTemp.getAge());
        biaozhu.setEmail(userTemp.getEmail());
        biaozhu.setId(id);                             // 再将传入的参数覆盖初始化的user
        biaozhu.setName(name);
        biaozhu.setAge(age);
        biaozhu.setEmail(email);
        biaozhuMapper.updateById(biaozhu);                // 最后update
    }

    // 测试乐观锁成功
    @ApiOperation(value="乐观锁1", notes="")
    @GetMapping("/version1")
    public void testVersionSuccess(){
        // 1. 查询用户信息
        Biaozhu biaozhu = biaozhuMapper.selectById(1);
        // 2. 修改用户信息
        biaozhu.setName("fan");
        biaozhu.setAge(24);
        // 3. 执行更新操作
        biaozhuMapper.updateById(user);
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
    */



}
