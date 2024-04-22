package com.anji.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anji.test.dto.Emp;
import com.anji.test.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRepository repository;
	
	@Override
	public List<Emp> loadAllEmpDetails() {
	return	repository.findAll();	
	}

	@Override
	public List<Emp> loadById(Integer id1, Integer id2, Integer id3) {
	     return repository.findByEmpNo(id1,id2,id3);
	}

	@Override
	public Emp findbyId(Integer id) {
		
		return repository.findById(id).get();
	}

	@Override
	public Emp addObject(Emp emp) {
		
		if(repository.findById(emp.getEmpId()).isEmpty() == true)
		{
			 emp = repository.save(emp);
			 
		}else {
			emp.setEName("id is already there");
		}
		return emp;
	}

	@Override
	public String updatebyId(Integer id, Double sal) {
		
		String s ;
		  if(repository.findById(id).isEmpty()!= true)
		  {
			  repository.updateById(id,sal);
			  s="Updated";
		  } 
		  else
			 s=" NOT Updated";
		  return s;
		 
	}

	@Override
	public Integer deleteById(Integer id) {
		
		
		Integer i;
		if(repository.findById(id).isEmpty() != true)
		{
			repository.deleteById(id);
			i=1;
		}else {
			 i=2;
		}
	  return i;	 
	}
	
	
	

}
