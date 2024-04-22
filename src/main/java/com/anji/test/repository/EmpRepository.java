package com.anji.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anji.test.dto.Emp;

@Transactional
@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer>{

	@Query(value = "select * from emp where empno=?1 or empno=?2 or empno=?3", nativeQuery = true)
	List<Emp> findByEmpNo(Integer id1,Integer id2,Integer id3);

	@Modifying
	@Query(value = "update emp set sal =:sal where empno=:id", nativeQuery = true)
	Integer updateById(@Param("id") Integer id,@Param("sal") Double sal);
	
	

	

}
