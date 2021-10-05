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
 * @date 2020/10/16 11:24
 */

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@ApiModel("用户实体")
public class Qa {      // 这里的类名要和数据库中的表名一致（驼峰-->下划线是可以的）
    // 对应数据库中的主键（uuid、自增id、雪花算法、redis、zookeeper）
//    @TableId(type = IdType.AUTO)  // 数据库对应字段必须也是自增的
    @ApiModelProperty("操作人")
    private String Operator;
    @ApiModelProperty("工作时间")
    private String date_time;
    @ApiModelProperty("被抽检数据量（再质检）")
    private Integer doublecheck_total;
    @ApiModelProperty("被抽检错误数据量（再质检）")
    private Integer doublecheck_wrong;
    @ApiModelProperty("今日被申诉成功数据量")
    private Integer argue_success;
    @ApiModelProperty("其他工作时间——非审核任务")
    private Float other_notcheck;
    @ApiModelProperty("其他工作时间——开会")
    private Float other_meeting;
    @ApiModelProperty("其他工作时间——组内管理")
    private Float other_manage;
    @ApiModelProperty("其他工作时间——培训")
    private Float other_training;
    @ApiModelProperty("其他工作时间——其他")
    private String other_other;
    @ApiModelProperty("抽检工作情况")
    private String task_info;

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

    public Qa() {
    }

    public Qa(String Operator, String date_time, Integer doublecheck_total, Integer doublecheck_wrong, Integer argue_success, Float other_notcheck, Float other_meeting, Float other_manage, Float other_training, String other_other, String task_info, Integer version, Integer deleted, LocalDateTime createTime, LocalDateTime updateTime) {
        this.Operator = Operator;
        this.date_time = date_time;
        this.doublecheck_total = doublecheck_total;
        this.doublecheck_wrong = doublecheck_wrong;
        this.argue_success = argue_success;
        this.other_notcheck = other_notcheck;
        this.other_meeting = other_meeting;
        this.other_manage = other_manage;
        this.other_training = other_training;
        this.other_other = other_other;
        this.task_info = task_info;
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

    public Integer getDoublecheckTotal() {
        return doublecheck_total;
    }

    public void setDoublecheckTotal(Integer doublecheck_total) {
        this.doublecheck_total = doublecheck_total;
    }

    public Integer getDoublecheckWrong() {
        return doublecheck_wrong;
    }

    public void setDoublecheckWrong(Integer doublecheck_wrong) {
        this.doublecheck_wrong = doublecheck_wrong;
    }

    public Integer getArgueSuccess() {
        return argue_success;
    }

    public void setArgueSuccess(Integer argue_success) {
        this.argue_success = argue_success;
    }

    public Float getOtherNotcheck() {
        return other_notcheck;
    }

    public void setOtherNotcheck(Float other_notcheck) {
        this.other_notcheck = other_notcheck;
    }

    public Float getOtherMeeting() {
        return other_meeting;
    }

    public void setOtherMeeting(Float other_meeting) {
        this.other_meeting = other_meeting;
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

    public String getOtherOther() {
        return other_other;
    }

    public void setOtherOther(String other_other) {
        this.other_other = other_other;
    }

    public String getTaskInfo() {
        return task_info;
    }

    public void setTaskInfo(String task_info) {
        this.task_info = task_info;
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
        return "Qa{" +
                "Operator=" + Operator + '\'' +
                ", date_time='" + date_time + '\'' +
                ", doublecheck_total=" + doublecheck_total +
                ", doublecheck_wrong=" + doublecheck_wrong +
                ", argue_success=" + argue_success +
                ", other_notcheck=" + other_notcheck +
                ", other_meeting=" + other_meeting +
                ", other_manage=" + other_manage +
                ", other_training=" + other_training +
                ", other_other=" + "[" + other_other + "]" + '\'' +
                ", task_info='" + "[" + task_info + "]" + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
