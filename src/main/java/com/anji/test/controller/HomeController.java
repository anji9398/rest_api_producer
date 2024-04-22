package com.anji.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anji.test.dto.Emp;
import com.anji.test.service.EmpService;

@RestController
public class HomeController {

	@Autowired
	private EmpService service;
	
	//get
	@GetMapping("/load/all")
	public ResponseEntity<List<Emp>> loadAllEmpDetails()
	{
		List<Emp> allEmpDetails = service.loadAllEmpDetails();
		 return new ResponseEntity<List<Emp>>(allEmpDetails,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/load/by/id")
	public ResponseEntity<List<Emp>> loadById(@RequestParam(name = "id1") String id1,@RequestParam(name = "id2") String id2,@RequestParam(name = "id3") String id3)
	{
		 List<Emp> empData = service.loadById(Integer.parseInt(id1),Integer.parseInt(id2),Integer.parseInt(id3));
		 return new ResponseEntity<List<Emp>>(empData,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/single/object/{id}")
	public ResponseEntity<Emp> getSingleObject(@PathVariable Integer id)
	{
         Emp emp = service.findbyId(id);
	       return new ResponseEntity<Emp>(emp, HttpStatusCode.valueOf(200));
	
	}
	
	@PostMapping("/add/object")
	public ResponseEntity<Emp> addEmpObject(@RequestBody Emp emp)
	{
		  Emp i = service.addObject(emp);
		  return new ResponseEntity<Emp>(i,HttpStatus.ACCEPTED);	
    }
	
	
	@PutMapping("/update/emp/salary/{id}/{sal}")
	public ResponseEntity<String> updateEmp(@PathVariable  Integer id,@PathVariable  Double sal)
	{
			String i  = service.updatebyId(id,sal);
			return new ResponseEntity<String>(i,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/emp/{id}")
	public ResponseEntity<String> deleteEmpRecord(@PathVariable("id") Integer id)
	{
	     Integer i =  service.deleteById(id);
	     if(i==1)
	        return new ResponseEntity<>("Deleted object "+id, HttpStatus.ACCEPTED);
	     return new ResponseEntity<>("Not Fount object "+id, HttpStatus.ACCEPTED);
	}
	
	 
}
