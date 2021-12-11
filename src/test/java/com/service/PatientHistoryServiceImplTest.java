
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

import com.model.PatientHistory;
import com.repository.PatientHistoryRepository;




@SpringBootTest
class PatientHistoryServiceImplTest {
	
	@Autowired
	PatientHistoryService patientservice;
	
	@MockBean
	PatientHistoryRepository repo;

	@Test
	void testGetPatientHistorys() {
		PatientHistory c1=new PatientHistory();
		c1.setId(1);
		c1.setDisease("Diabetes");
		c1.setdAdvice("Take medicine");
		c1.setDiet("Green vegetables");
	
		PatientHistory c2=new PatientHistory();
		c1.setId(2);
		c1.setDisease("Covid");
		c1.setdAdvice("Take medicine");
		c1.setDiet("Vitamin C");
		
		
		List<PatientHistory> doctorList = new ArrayList<>();
		doctorList.add(c1);
		doctorList.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(doctorList);
		
		assertThat(patientservice.getAllPatientHistory()).isEqualTo(doctorList);
	}

	@Test
	//@Disabled
	void testGetPatientHistoryById() throws Throwable {
		
		  PatientHistory c1=new PatientHistory(); 
		  c1.setId(2);
			c1.setDisease("Covid");
			c1.setdAdvice("Take medicine");
			c1.setDiet("Vitamin C");
			
		 
		
		Optional<PatientHistory> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(patientservice.getPatientHistoryById(1)).isEqualTo(c1);
	}

	@Test
	void testAddPatientHistory() {
		PatientHistory c1=new PatientHistory();
		c1.setId(2);
		c1.setDisease("Covid");
		c1.setdAdvice("Take medicine");
		c1.setDiet("Vitamin C");
		
	Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(patientservice.addPatientHistory(c1)).isEqualTo(c1);
	}


	void testUpdatePatientHistory() throws Throwable {
		int phId=2;
		PatientHistory c1=new PatientHistory();
		c1.setId(2);
		c1.setDisease("Covid");
		c1.setdAdvice("Take medicine");
		c1.setDiet("Vitamin C");
		
		Optional<PatientHistory> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(2)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		
		c1.setDisease("Diabetes");
		c1.setdAdvice("Take medicine on time");
		c1.setDiet("Vitamin");
		
		assertThat(patientservice.updatePatientHistory( phId,c1)).isEqualTo(c1);
	}

	@Test
	void testDeletePatientHistory() {
		PatientHistory c1=new PatientHistory();
		c1.setId(2);
		c1.setDisease("Covid");
		c1.setdAdvice("Take medicine");
		c1.setDiet("Vitamin C");
		
		Optional<PatientHistory> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getId())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getId()));
	}

	/*
	 * @Test void testDeletePatientHistoryById() { fail("Not yet implemented"); }
	 * 
	 * 
	 */

}