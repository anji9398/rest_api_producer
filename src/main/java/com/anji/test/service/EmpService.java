package com.anji.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anji.test.dto.Emp;

@Service
public interface EmpService {

	List<Emp> loadAllEmpDetails();

	List<Emp> loadById(Integer id1, Integer id2, Integer id3);

	Emp findbyId(Integer id);

	Emp addObject(Emp emp);

	String updatebyId(Integer id, Double sal);

	Integer deleteById(Integer id);
	
}
