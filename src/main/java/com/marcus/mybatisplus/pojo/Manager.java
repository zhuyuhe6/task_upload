package com.marcus.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;


/**
 * @author Yuhe Zhu
 * @version 2.0
 * @date 2020/10/14 11:04
 */

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@ApiModel("项目经理实体")
public class Manager {      // 这里的类名要和数据库中的表名一致（驼峰-->下划线是可以的）
    // 对应数据库中的主键（uuid、自增id、雪花算法、redis、zookeeper）
//    @TableId(type = IdType.AUTO)  // 数据库对应字段必须也是自增的
    @ApiModelProperty("操作人")
    private String Operator;
    @ApiModelProperty("工作时间")
    private String date_time;
    @ApiModelProperty("供应商标注情况")
    private String task_info;
    @ApiModelProperty("供应商被抽检情况")
    private String check_info;

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

    public Manager() {
    }

    public Manager(String Operator, String date_time, String task_info, String check_info, Integer version, Integer deleted, LocalDateTime createTime, LocalDateTime updateTime) {
        this.Operator = Operator;
        this.date_time = date_time;
        this.task_info = task_info;
        this.check_info = check_info;
        this.version = version;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String Operator) {
        this.Operator = Operator;
    }

    public String getDateTime() {
        return date_time;
    }

    public void setDateTime(String date_time) {
        this.date_time = date_time;
    }

    public String getTaskInfo() {
        return task_info;
    }

    public void setTaskInfo(String task_info) {
        this.task_info = task_info;
    }

    public String getCheckInfo() {
        return check_info;
    }

    public void setCheckInfo(String check_info) {
        this.check_info = check_info;
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
        return "Manager{" +
                "Operator=" + Operator + '\'' +
                ", date_time='" + date_time + '\'' +
                ", task_info='" + "[" + task_info + "]" + '\'' +
                ", check_info='" + "[" + check_info + "]" + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
