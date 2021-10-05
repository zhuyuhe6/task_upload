package com.marcus.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author marcus
 * @version 2.0
 * @date 2020/10/5 20:48
 */

@Slf4j
@Component  //一定不要忘记吧处理器加到IOC容器中
public class MyMetaObjectHandler implements MetaObjectHandler {

    //插入时候的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        //log.info("start insert fill ....");  //日志
        // 插入和更新字段都自动填充
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
    }

    //更新时间的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        //log.info("start update fill ....");
        // 自动填充更新字段
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
    }
}

