package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.Doctor;


@Repository
public interface AdminRepository extends JpaRepository<Doctor, Integer>
{
	
	

}