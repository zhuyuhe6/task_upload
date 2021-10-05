package com.marcus.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * @author marcus
 * @version 2.0
 * @date 2020/10/5 19:05
 */

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@ApiModel("用户实体")
public class User {      // 这里的类名要和数据库中的表名一致（驼峰-->下划线是可以的）
    // 对应数据库中的主键（uuid、自增id、雪花算法、redis、zookeeper）
    @TableId(type = IdType.AUTO)  // 数据库对应字段必须也是自增的
    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户年龄")
    private Integer age;
    @ApiModelProperty("用户邮箱")
    private String email;

    @Version // 乐观锁的version注解
    @ApiModelProperty("乐观锁")
    private Integer version;

//    @TableLogic // 逻辑删除 全局配置了逻辑删除字段，这里就不用写注解了
    @ApiModelProperty("是否删除")
    private Integer deleted;

    //字段添加填充内容
    @ApiModelProperty("添加时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    public User() {
    }

    public User(Integer id, String name, Integer age, String email, Integer version, Integer deleted, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.version = version;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
