package com.marcus.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.marcus.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author marcus
 * @version 2.0
 * @date 2020/10/5 19:07
 */

// 在对应的Mapper上面继承基本的接口 BaseMapper
@Repository // 代表持久层
public interface UserMapper extends BaseMapper<User> {
    // 所有的CRUD操作都已经基本完成了
    // 你不需要像以前的配置一大堆文件了
}

