
package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Doctor;
import com.repository.DoctorRepository;


@SpringBootTest
class DoctorServiceImplTest {
	
	@Autowired
	DoctorService doctorservice;
	
	@MockBean
	DoctorRepository repo;

	@Test
	void testGetDoctors() {
		Doctor c1=new Doctor();
		c1.setId(1);
		c1.setDname("Riya");
		c1.setSpecialization("Surgeon");
		c1.setQualification("MBBS");
		c1.setAvailability("Yes");
		
		Doctor c2=new Doctor();
		c1.setId(2);
		c1.setDname("Aswin");
		c1.setSpecialization("Surgeon");
		c1.setQualification("MD");
		c1.setAvailability("Yes");
		
		List<Doctor> doctorList = new ArrayList<>();
		doctorList.add(c1);
		doctorList.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(doctorList);
		
		assertThat(doctorservice.getDoctors()).isEqualTo(doctorList);
	}

	@Test
	void testGetDoctorById() throws Throwable {
		
		  Doctor c1=new Doctor(); 
		  c1.setId(1);
			c1.setDname("Riya");
			c1.setSpecialization("Surgeon");
			c1.setQualification("MBBS");
			c1.setAvailability("Yes");
		 
		
		Optional<Doctor> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(doctorservice.getDoctorById(1)).isEqualTo(c1);
	}

	@Test
	void testAddDoctor() {
		Doctor c1=new Doctor();
		c1.setId(1);
		c1.setDname("Riya");
		c1.setSpecialization("Surgeon");
		c1.setQualification("MBBS");
		c1.setAvailability("Yes");
	Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(doctorservice.addDoctor(c1)).isEqualTo(c1);
	}

	@Test
	void testUpdateDoctor() throws Throwable {
		int doctorId=1;
		Doctor c1=new Doctor();
		c1.setId(1);
		c1.setDname("Riya");
		c1.setSpecialization("Surgeon");
		c1.setQualification("MBBS");
		c1.setAvailability("Yes");
		Optional<Doctor> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setDname("Summi");
		c1.setSpecialization("Heart Specialist");
		c1.setQualification("MD");
		c1.setAvailability("No");
		
		assertThat(doctorservice.updateDoctor(doctorId,c1)).isEqualTo(c1);
	}

	@Test
	void testDeleteDoctor() {
		Doctor c1=new Doctor();
		c1.setId(1);
		c1.setDname("Riya");
		c1.setSpecialization("Surgeon");
		c1.setQualification("MBBS");
		c1.setAvailability("Yes");
		Optional<Doctor> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getId())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getId()));
	}

	/*
	 * @Test void testDeleteDoctorById() { fail("Not yet implemented"); }
	 * 
	 * 
	 */

}