package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Entries;
import com.example.demo.repository.EntryRepository;


@Service
public class EntryServiceInterfaceImpl implements EntryServiceInterface {
	
	@Autowired
	private EntryRepository entryRepository;
	
	

	public EntryRepository getEntryRepository() {
		return entryRepository;
	}

	public void setEntryRepository(EntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}

	@Override
	public Entries saveEntry(Entries entry) {
		
		return  entryRepository.save(entry);
	}

	@Override
	public List<Entries> findAllEntries(long id) {
		List<Entries>entries= entryRepository.findAllById(id);
		return entries;
	}

	@Override
	public Entries findById(long id) {
		System.out.println(id);
		Entries entries=entryRepository.findByUserId(id);
		
		return entries;
	}

	@Override
	public void deleteEntry(long id) {
		entryRepository.deleteById(id);
		
	}

}
