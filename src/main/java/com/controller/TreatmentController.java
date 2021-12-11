package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advices.ResourceNotFoundException;
import com.model.Treatment;
import com.service.TreatmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TreatmentController {
	
	@Autowired
	TreatmentService treatmentservice;
	
	@PostMapping("/treatments")
	public ResponseEntity<Treatment> addTreatment(@RequestBody Treatment c)
	{
		Treatment c1=treatmentservice.addTreatment(c);
		ResponseEntity re=new ResponseEntity<Treatment>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/treatments")
	public ResponseEntity<List<Treatment>> getTreatments()
	{
		List<Treatment> lc1=treatmentservice.getTreatments();
		ResponseEntity re=new ResponseEntity<List<Treatment>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/treatments/{id}")
	public ResponseEntity<Treatment> getEmpById(@PathVariable int id) throws Throwable
	{
		Treatment c1=treatmentservice.getTreatmentById(id);
		
		ResponseEntity re=new ResponseEntity<Treatment>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addTreatments")
	public ResponseEntity<List<Treatment>> addTreatments(@RequestBody List<Treatment> ls)
	{
		List<Treatment> le=treatmentservice.addTreatments(ls);
		
		ResponseEntity re=new ResponseEntity<List<Treatment>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/treatments/{treatmentId}")
	public ResponseEntity<?> updateTreatment(@PathVariable int treatmentId, @RequestBody Treatment treatment) throws ResourceNotFoundException {
		Treatment updatedTreatment = treatmentservice.updateTreatment(treatmentId, treatment);
		return new ResponseEntity<Treatment>(updatedTreatment, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/treatments")
	public ResponseEntity<String> deleteTreatment(@RequestBody Treatment e)
	{
		treatmentservice.deleteTreatment(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/treatments/{id}")
	public ResponseEntity<String> deleteTreatmentById(@PathVariable int id)
	{
		treatmentservice.deleteTreatmentById(id);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	

}