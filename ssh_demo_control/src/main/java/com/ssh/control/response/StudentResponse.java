package com.ssh.control.response;


import com.ssh.control.vo.StudentVo;
import com.ssh.error.exception.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * Created by ouyangyufeng on 2019/1/24.
 */
@Data
public class StudentResponse extends BaseResponse {

    private List<StudentVo> studentVo;
}
