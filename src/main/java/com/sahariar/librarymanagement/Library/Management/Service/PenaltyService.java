package com.sahariar.librarymanagement.Library.Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahariar.librarymanagement.Library.Management.Jpa.PenaltyRepository;
import com.sahariar.librarymanagement.Library.Management.Models.Penalty;

@Service
public class PenaltyService {

	@Autowired
	PenaltyRepository pr;
	
	public List<Penalty> getAll()
	{
		return pr.findAll();
	}
	
}
