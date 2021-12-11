
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

import com.model.Treatment;
import com.repository.TreatmentRepository;



@SpringBootTest
class TreatmentServiceTest {
	
	@Autowired
	TreatmentService doctorservice;
	
	@MockBean
	TreatmentRepository repo;

	@Test
	void testGetTreatments() {
		Treatment c1=new Treatment();
		c1.setTid(1);
		c1.setReports("X-RAY");
		c1.setMedicines("CITRIZINE");
		c1.setDescription("Stone in left kidney");
		
		
		Treatment c2=new Treatment();
		c1.setTid(2);
		c1.setReports("ULTRASOUND");
		c1.setMedicines("DIMETHINE");
		c1.setDescription("Stone in stomach");
		
		List<Treatment> doctorList = new ArrayList<>();
		doctorList.add(c1);
		doctorList.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(doctorList);
		
		assertThat(doctorservice.getTreatments()).isEqualTo(doctorList);
	}

	@Test
	//@Disabled
	void testGetTreatmentById() throws Throwable {
		
		  Treatment c1=new Treatment(); 
		  c1.setTid(1);
			c1.setReports("X-RAY");
			c1.setMedicines("CITRIZINE");
			c1.setDescription("Stone in left kidney");
		 
		
		Optional<Treatment> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(doctorservice.getTreatmentById(1)).isEqualTo(c1);
	}

	@Test
	void testAddTreatment() {
		Treatment c1=new Treatment();
		c1.setTid(1);
		c1.setReports("X-RAY");
		c1.setMedicines("CITRIZINE");
		c1.setDescription("Stone in left kidney");
	Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(doctorservice.addTreatment(c1)).isEqualTo(c1);
	}

	@Test
	void testUpdateTreatment() throws Throwable {
		int tid=1;
		Treatment c1=new Treatment();
		c1.setTid(1);
		c1.setReports("X-RAY");
		c1.setMedicines("CITRIZINE");
		c1.setDescription("Stone in left kidney");
		Optional<Treatment> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		
		c1.setReports("X-RAY-I");
		c1.setMedicines("CITRIZINE-I");
		c1.setDescription("Stone in right kidney");
		
		assertThat(doctorservice.updateTreatment(tid,c1)).isEqualTo(c1);
	}
	

	@Test
	void testDeleteTreatment() {
		Treatment c1=new Treatment();
		c1.setTid(1);
		c1.setReports("X-RAY");
		c1.setMedicines("CITRIZINE");
		c1.setDescription("Stone in left kidney");
		Optional<Treatment> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getTid())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getTid()));
	}

	/*
	 * @Test void testDeleteTreatmentById() { fail("Not yet implemented"); }
	 * 
	 * 
	 */

}