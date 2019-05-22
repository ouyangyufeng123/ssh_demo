package com.ssh.service;

import com.ssh.dao.StudentDao;
import com.ssh.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author ouyangyufeng
 * @date 2019/5/22
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> findAll() {
        List<Student> listStu = studentDao.findAll();
        return listStu.size() > 0 ? listStu : null;
    }


    @Transactional(rollbackOn = Exception.class)
    public void addOrUpdStudent(Student stu) {
       studentDao.save(stu);
    }

    @Transactional(rollbackOn = Exception.class)
    public void deleteStudent(Long objId) {
        studentDao.deleteStudent(objId);
    }

}
