package com.ssh.control.vo;

import com.ssh.control.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by ouyangyufeng on 2019/1/24.
 */
@Data
@ApiModel(value = "用户表实体Vo", description = "实体类Vo")
public class StudentVo extends BaseVo{

    @ApiModelProperty(value = "学生id")
    private long objId;

    @ApiModelProperty(value = "学生姓名")
    private String sname;

    @ApiModelProperty(value = "学生年龄")
    private Integer sage;
}
