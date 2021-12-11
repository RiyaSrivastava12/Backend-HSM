package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.Doctor;
import com.model.PatientHistory;
import com.repository.PatientHistoryRepository;



@Service
public class PatientHistoryService {
	
	@Autowired
	PatientHistoryRepository repo;
	
	public PatientHistory addPatientHistory(PatientHistory ph)
	{
		 repo.save(ph);	
		 return ph;
	}
	
	public List<PatientHistory> getAllPatientHistory()
	{
		List<PatientHistory> lc1=repo.findAll();
		
		return lc1;
	}

	public PatientHistory getPatientHistoryById(int phid) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("PatientHistory Does not exist in the database");
		PatientHistory c=repo.findById(phid).orElseThrow(s1);
		return c;
	}

	public String deletePatientHistoryById(int phid) {
		
		repo.deleteById(phid);
		
		return "Deleted";
	}

	public String deletePatientHistory(PatientHistory ph) {
		
		repo.delete(ph);
		return "Deleted";
	}

	public PatientHistory updatePatientHistory(int Id, PatientHistory ph) throws ResourceNotFoundException {
		
		//	logger.info("****************updating Customer Details****************");
			
			Integer getId = Integer.valueOf(Id);

			if (getId instanceof Integer) {
				Optional<PatientHistory> optional = repo.findById(getId);

				if (optional.isPresent()) {
					PatientHistory gotPatientHistory = optional.get();
					gotPatientHistory.setDisease(ph.getDisease());
					gotPatientHistory.setdAdvice(ph.getdAdvice());
					gotPatientHistory.setDiet(ph.getDiet());
					
					PatientHistory updatePatientHistory = repo.save(gotPatientHistory);
					return updatePatientHistory;
				}

				else {
					throw new ResourceNotFoundException("Given PatientHistory id is not present in the database.");
				}
			} else {
				throw new ResourceNotFoundException("The ID should be a number type");
			}

		}
		
	
	

	public List<PatientHistory> addAllPatientHistory(List<PatientHistory> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	

}

