package com.ssh.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ouyangyufeng
 */
@Entity
@Data
@Table(name = "student")
@ApiModel(value = "用户表实体", description = "实体类")
public class Student{

    @Id
    @Column(
            name = "objId",
            columnDefinition = "bigint comment \'主键ID\'"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long objId;

    @ApiModelProperty(value = "学生姓名")
    @Column(columnDefinition = "varchar(20) comment '学生姓名'")
    private String sname;

    @ApiModelProperty(value = "学生年龄")
    @Column(columnDefinition = "int(11) comment '学生年龄'")
    private int sage;

}