package com.ssafy.camp.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.camp.model.dto.Camp;

public interface CampService {
	public int createCamp(Camp camp, MultipartFile campImage) throws IOException;

	public int deleteCamp(Camp camp);

	public int updateCamp(Camp camp);
	
	public List<Camp> getAllCampList();

	public List<Camp> searchCamp(Camp camp);
	
	public Camp getCamp(int campId);
	
	public Resource loadCampImage(String imgFileName);
}
