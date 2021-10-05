package com.marcus.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
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
@ApiModel("用户实体")
public class Biaozhu {      // 这里的类名要和数据库中的表名一致（驼峰-->下划线是可以的）
    // 对应数据库中的主键（uuid、自增id、雪花算法、redis、zookeeper）
//    @TableId(type = IdType.AUTO)  // 数据库对应字段必须也是自增的
    @ApiModelProperty("操作人")
    private String Operator;
    @ApiModelProperty("工作时间")
    private String date_time;
    @ApiModelProperty("其他工作时间——项目相关工作")
    private Float other_program;
    @ApiModelProperty("其他工作时间——其他管理工作")
    private Float other_manage;
    @ApiModelProperty("其他工作时间——其他培训工作")
    private Float other_training;
    @ApiModelProperty("其他工作时间——其他")
    private Float other_other;
    @ApiModelProperty("标注工作情况")
    private String task_info;
    @ApiModelProperty("被抽检情况")
    private String check_info;
    @ApiModelProperty("被盲检情况")
    private String double_info;

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

    public Biaozhu() {
    }

    public Biaozhu(String Operator, String date_time, Float other_program, Float other_manage, Float other_training, Float other_other, String task_info, String check_info, String double_info, Integer version, Integer deleted, LocalDateTime createTime, LocalDateTime updateTime) {
        this.Operator = Operator;
        this.date_time = date_time;
        this.other_program = other_program;
        this.other_manage = other_manage;
        this.other_training = other_training;
        this.other_other = other_other;
        this.task_info = task_info;
        this.check_info = check_info;
        this.double_info = double_info;
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

    public Float getOtherProgram() {
        return other_program;
    }

    public void setOtherProgram(Float other_program) {
        this.other_program = other_program;
    }

    public Float getOtherManage() {
        return other_manage;
    }

    public void setOtherManage(Float other_manage) {
        this.other_manage = other_manage;
    }

    public Float getOtherTraining() {
        return other_training;
    }

    public void setOtherTraining(Float other_training) {
        this.other_training = other_training;
    }

    public Float getOtherOther() {
        return other_other;
    }

    public void setOtherOther(Float other_other) {
        this.other_other = other_other;
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

    public String getDoubleInfo() {
        return double_info;
    }

    public void setDoubleInfo(String double_info) {
        this.double_info = double_info;
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
        return "Biaozhu{" +
                "Operator=" + Operator + '\'' +
                ", date_time='" + date_time + '\'' +
                ", other_program=" + other_program +
                ", other_manage=" + other_manage +
                ", other_training=" + other_training +
                ", other_other=" + other_other +
                ", task_info='" + "[" + task_info + "]" + '\'' +
                ", check_info='" + "[" + check_info + "]" + '\'' +
                ", double_info='" + "[" + double_info + "]" + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
