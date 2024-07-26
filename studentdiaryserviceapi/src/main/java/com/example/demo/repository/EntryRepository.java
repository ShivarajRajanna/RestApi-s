package com.example.demo.repository;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Entries;



public interface EntryRepository extends JpaRepository<Entries, Long> {
    
	@Query(value = "SELECT * FROM Entries WHERE userid = :userid",nativeQuery=true)
	List<Entries> findAllById(@Param("userid") Long id);
	
	@Query(value = "SELECT * FROM Entries WHERE id = :userid",nativeQuery=true)
	 public Entries findByUserId(@Param("userid") Long id);

}
