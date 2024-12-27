package org.techhub.service;

import org.techhub.repository.HRRepositoryImpl;
import org.techhub.repository.IHRRepository;

public class HRServiceImpl implements HRService {

	private IHRRepository HRRepo = new HRRepositoryImpl();
	
	@Override
	public boolean HRLogin(String roleName, int empId) {
		return HRRepo.HRLogin(roleName, empId);
	}

}
