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
import com.model.PatientHistory;
import com.service.PatientHistoryService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientHistoryController {
	
	@Autowired
	PatientHistoryService patientHistoryService;
	
	@PostMapping("/patientHistories")
	public ResponseEntity<PatientHistory> addPatientHistory(@RequestBody PatientHistory c)
	{
		PatientHistory c1=patientHistoryService.addPatientHistory(c);
		ResponseEntity re=new ResponseEntity<PatientHistory>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/patientHistories")
	public ResponseEntity<List<PatientHistory>> getPatientHistorys()
	{
		List<PatientHistory> lc1=patientHistoryService.getAllPatientHistory();
		ResponseEntity re=new ResponseEntity<List<PatientHistory>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/patientHistories/{id}")
	public ResponseEntity<PatientHistory> getEmpById(@PathVariable int id) throws Throwable
	{
		PatientHistory c1=patientHistoryService.getPatientHistoryById(id);
		
		ResponseEntity re=new ResponseEntity<PatientHistory>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addPatientHistories")
	public ResponseEntity<List<PatientHistory>> addPatientHistorys(@RequestBody List<PatientHistory> ls)
	{
		List<PatientHistory> le=patientHistoryService.addAllPatientHistory(ls);
		
		ResponseEntity re=new ResponseEntity<List<PatientHistory>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/patientHistories/{phId}")
	public ResponseEntity<?> updatePatientHistory(@PathVariable int phId, @RequestBody PatientHistory patientHistory) throws ResourceNotFoundException {
		PatientHistory updatedPatientHistory = patientHistoryService.updatePatientHistory(phId, patientHistory);
		return new ResponseEntity<PatientHistory>(updatedPatientHistory, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/patientHistories")
	public ResponseEntity<String> deletePatientHistory(@RequestBody PatientHistory e)
	{
		patientHistoryService.deletePatientHistory(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/patientHistories/{id}")
	public ResponseEntity<String> deletePatientHistoryById(@PathVariable int id)
	{
		patientHistoryService.deletePatientHistoryById(id);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	

}