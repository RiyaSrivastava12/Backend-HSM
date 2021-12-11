package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.Doctor;
import com.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepo;

//implementation methods

	public Doctor addDoctor(Doctor c)
	{
		 adminRepo.save(c);	
		 return c;
	}
	
	public List<Doctor> getDoctors()
	{
		List<Doctor> lc1=adminRepo.findAll();
		
		return lc1;
	}

	public Doctor getDoctorById(int cid) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Doctor Does not exist in the database");
		Doctor c=adminRepo.findById(cid).orElseThrow(s1);
		return c;
	}

	public String deleteDoctorById(int cid) {
		
		adminRepo.deleteById(cid);
		
		return "Deleted";
	}

	public String deleteDoctor(Doctor c) {
		
		adminRepo.delete(c);
		return "Deleted";
	}

	
public Doctor updateDoctor(int Id, Doctor doctor) throws ResourceNotFoundException {
		
	//	logger.info("****************updating Customer Details****************");
		
		Integer getId = Integer.valueOf(Id);

		if (getId instanceof Integer) {
			Optional<Doctor> optional = adminRepo.findById(getId);

			if (optional.isPresent()) {
				Doctor gotDoctor = optional.get();
				gotDoctor.setDname(doctor.getDname());
				gotDoctor.setQualification(doctor.getQualification());
				gotDoctor.setSpecialization(doctor.getSpecialization());
				gotDoctor.setAvailability(doctor.getAvailability());
				
				Doctor updateDoctor = adminRepo.save(gotDoctor);
				return updateDoctor;
			}

			else {
				throw new ResourceNotFoundException("Given customer id is not present in the database.");
			}
		} else {
			throw new ResourceNotFoundException("The ID should be a number type");
		}

	}
	

	public List<Doctor> addDoctors(List<Doctor> ls) {
		adminRepo.saveAll(ls);
		return ls;
	}
	
	

	
}
