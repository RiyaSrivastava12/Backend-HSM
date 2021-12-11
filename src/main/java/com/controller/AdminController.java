package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advices.ResourceNotFoundException;
import com.model.Doctor;
import com.service.AdminService;


@RestController
@RequestMapping(path="/admin")
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@PostMapping("/addDoctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor c)
	{
		Doctor c1=adminservice.addDoctor(c);
		ResponseEntity re=new ResponseEntity<Doctor>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getDoctors")
	public ResponseEntity<List<Doctor>> getDoctors()
	{
		List<Doctor> lc1=adminservice.getDoctors();
		ResponseEntity re=new ResponseEntity<List<Doctor>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getDoctor/{cid}")
	public ResponseEntity<Doctor> getEmpById(@PathVariable int cid) throws Throwable
	{
		Doctor c1=adminservice.getDoctorById(cid);
		
		ResponseEntity re=new ResponseEntity<Doctor>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addDoctors")
	public ResponseEntity<List<Doctor>> addDoctors(@RequestBody List<Doctor> ls)
	{
		List<Doctor> le=adminservice.addDoctors(ls);
		
		ResponseEntity re=new ResponseEntity<List<Doctor>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/updateDoctor/{doctorId}")
	public ResponseEntity<?> updateCustomer(@PathVariable int doctorId, @RequestBody Doctor doctor) throws ResourceNotFoundException {
		Doctor updatedDoctor = adminservice.updateDoctor(doctorId, doctor);
		return new ResponseEntity<Doctor>(updatedDoctor, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/deleteDoctor")
	public ResponseEntity<String> deleteDoctor(@RequestBody Doctor e)
	{
		adminservice.deleteDoctor(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteDoctor/{eid}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable int eid)
	{
		adminservice.deleteDoctorById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	

}