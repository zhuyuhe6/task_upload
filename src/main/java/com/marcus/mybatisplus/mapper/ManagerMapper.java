package com.marcus.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.marcus.mybatisplus.pojo.Manager;
import org.springframework.stereotype.Repository;

/**
 * @author Yuhe Zhu
 * @version 2.0
 * @date 2020/10/14 13:55
 */

// 在对应的Mapper上面继承基本的接口 BaseMapper
@Repository // 代表持久层
public interface ManagerMapper extends BaseMapper<Manager> {
    // 所有的CRUD操作都已经基本完成了
    // 你不需要像以前的配置一大堆文件了
}

