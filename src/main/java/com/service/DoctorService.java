package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.Doctor;
import com.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository repo;
	
	public Doctor addDoctor(Doctor c)
	{
		 repo.save(c);	
		 return c;
	}
	
	public List<Doctor> getDoctors()
	{
		List<Doctor> lc1=repo.findAll();
		
		return lc1;
	}

	public Doctor getDoctorById(int cid) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Doctor Does not exist in the database");
		Doctor c=repo.findById(cid).orElseThrow(s1);
		return c;
	}

	public String deleteDoctorById(int cid) {
		
		repo.deleteById(cid);
		
		return "Deleted";
	}

	public String deleteDoctor(Doctor c) {
		
		repo.delete(c);
		return "Deleted";
	}
/*
	public Doctor updateDoctor(Doctor c) throws Throwable {
		int id=c.getId();	
		Supplier s1= ()->new ResourceNotFoundException("Doctor Does not exist in the database");
		Doctor c1=repo.findById(id).orElseThrow(s1);
		
		c1.setDname(c1.getDname());
		c1.setQualification(c1.getQualification());
		c1.setSpecialization(c1.getSpecialization());
		c1.setAvailability(c1.getAvailability());
			repo.save(c1);
			return c1;	
	}
	
	*/
	/*
	public Doctor updateDoctor(Doctor c) throws Throwable {
		int id = c.getId();
		Supplier s1 = () -> new ResourceNotFoundException("Doctor Does not exist in the database");
		Doctor c1 = repo.findById(id).orElseThrow(s1);

		c1.setDname(c.getDname());
		c1.setQualification(c.getQualification());
		c1.setSpecialization(c.getSpecialization());
		c1.setAvailability(c.getAvailability());
		repo.save(c1);

		return c1;
	}
	*/
public Doctor updateDoctor(int Id, Doctor doctor) throws ResourceNotFoundException {
		
	//	logger.info("****************updating Customer Details****************");
		
		Integer getId = Integer.valueOf(Id);

		if (getId instanceof Integer) {
			Optional<Doctor> optional = repo.findById(getId);

			if (optional.isPresent()) {
				Doctor gotDoctor = optional.get();
				gotDoctor.setDname(doctor.getDname());
				gotDoctor.setQualification(doctor.getQualification());
				gotDoctor.setSpecialization(doctor.getSpecialization());
				gotDoctor.setAvailability(doctor.getAvailability());
				
				Doctor updateDoctor = repo.save(gotDoctor);
				return updateDoctor;
			}

			else {
				throw new ResourceNotFoundException("Given Doctor id is not present in the database.");
			}
		} else {
			throw new ResourceNotFoundException("The ID should be a number type");
		}

	}
	

	public List<Doctor> addDoctors(List<Doctor> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	

}