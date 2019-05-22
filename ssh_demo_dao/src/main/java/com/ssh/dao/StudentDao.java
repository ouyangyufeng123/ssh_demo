package com.ssh.dao;

import com.ssh.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ouyangyufeng
 * @date 2019/5/22
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Student WHERE objId=:objId")
    public void deleteStudent(@Param("objId") Long objId);

}
