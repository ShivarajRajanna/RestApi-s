package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Entries;
import com.example.demo.service.EntryServiceInterface;

import jakarta.servlet.http.HttpSession;

@RestController
public class EntriesController {
	
	
	@Autowired
	private EntryServiceInterface entryServiceInterface;
	
	
	public EntryServiceInterface getEntryServiceInterface() {
		return entryServiceInterface;
	}

	public void setEntryServiceInterface(EntryServiceInterface entryServiceInterface) {
		this.entryServiceInterface = entryServiceInterface;
	}








	@PostMapping("/entries/") 
	public Entries saveEntry(@RequestBody Entries entries)
	{
		
	Entries entry=entryServiceInterface.saveEntry(entries);
	return entry;
		
	}
	

	@GetMapping("/entries/{id}") 
	public List<Entries> FindEntry(@PathVariable long id)
	{
		
	List<Entries> entry=entryServiceInterface.findAllEntries(id);
	return entry;
		
	}
	
	@DeleteMapping("/entries/{id}")
	public void deleteEntry(@PathVariable long id)
	{
		entryServiceInterface.deleteEntry(id);
	}
	
	@GetMapping("/entries1/{id}")
	public Entries viewEntry(@PathVariable long id)
	{
		Entries entry=entryServiceInterface.findById(id);
		return entry;
	}
	

}
