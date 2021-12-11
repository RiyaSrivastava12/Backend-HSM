package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.Treatment;
import com.model.Treatment;
import com.repository.TreatmentRepository;

@Service
public class TreatmentService {
	
	@Autowired
	TreatmentRepository repo;
	
	public Treatment addTreatment(Treatment t)
	{
		 repo.save(t);	
		 return t;
	}
	
	public List<Treatment> getTreatments()
	{
		List<Treatment> lt1=repo.findAll();
		
		return lt1;
	}

	public Treatment getTreatmentById(int cid) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Treatment Does not exist in the database");
		Treatment c=repo.findById(cid).orElseThrow(s1);
		return c;
	}

	public String deleteTreatmentById(int tid) {
		
		repo.deleteById(tid);
		
		return "Deleted";
	}

	public String deleteTreatment(Treatment t) {
		
		repo.delete(t);
		return "Deleted";
	}

	public Treatment updateTreatment(int Id, Treatment treatment) throws ResourceNotFoundException {
			
			Integer getId = Integer.valueOf(Id);

			if (getId instanceof Integer) {
				Optional<Treatment> optional = repo.findById(getId);

				if (optional.isPresent()) {
					Treatment gotTreatment = optional.get();
					gotTreatment.setTid(treatment.getTid());
					gotTreatment.setReports(treatment.getReports());
					gotTreatment.setMedicines(treatment.getMedicines());
					gotTreatment.setDescription(treatment.getDescription());
					
					Treatment updateTreatment = repo.save(gotTreatment);
					return updateTreatment;
				}

				else {
					throw new ResourceNotFoundException("Given treatment id is not present in the database.");
				}
			} else {
				throw new ResourceNotFoundException("The ID should be a number type");
			}

		}
		


	public List<Treatment> addTreatments(List<Treatment> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	

}
