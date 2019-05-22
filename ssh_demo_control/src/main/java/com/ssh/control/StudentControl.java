package com.ssh.control;

import com.ssh.control.response.StudentResponse;
import com.ssh.control.vo.StudentVo;
import com.ssh.error.exception.BaseResponse;
import com.ssh.model.Student;
import com.ssh.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyangyufeng
 * @date 2019/5/22
 */
@Api(description = "学生信息查询接口")
@RequestMapping("/student")
@RestController
public class StudentControl {

    @Autowired
    private StudentService stuService;


    @ApiOperation(value = "查询学生所有信息")
    @GetMapping("/findAllStudent")
    public StudentResponse findAllStudent() {
        StudentResponse stuResp = new StudentResponse();
        StudentVo stuVo = null;
        List<Student> listStu = stuService.findAll();
        if (listStu != null) {
            List<StudentVo> listStuVo = new ArrayList<>();
            for (Student stu : listStu) {
                stuVo = new StudentVo();
                BeanUtils.copyProperties(stu, stuVo);
                listStuVo.add(stuVo);
            }
            stuResp.setStudentVo(listStuVo);
        }
        return stuResp;
    }


    /**
     * <p>添加学生信息</p>
     *
     * @param stu
     * @return
     */
    @ApiOperation(value = "添加学生信息")
    @PostMapping("insertStudent")
    public BaseResponse insertStudent(@RequestBody Student stu) {
        System.out.println(stu);
        stuService.addOrUpdStudent(stu);
        return new BaseResponse();
    }

    /**
     * <p>删除学生信息</p>
     *
     * @param objId
     * @return
     */
    @ApiOperation(value = "删除学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "objId", value = "学生id", required = true, dataType = "Long", paramType = "query")})
    @DeleteMapping("deleteStudent")
    public BaseResponse deleteStudent(Long objId) {
        stuService.deleteStudent(objId);
        return new BaseResponse();
    }

    /**
     * <p>修改学生信息</p>
     *
     * @param stu
     * @return
     */
    @ApiOperation(value = "修改学生信息")
    @PutMapping("updateStudent")
    public BaseResponse updateStudent(@RequestBody Student stu) {
        stuService.addOrUpdStudent(stu);
        return new BaseResponse();
    }
}
