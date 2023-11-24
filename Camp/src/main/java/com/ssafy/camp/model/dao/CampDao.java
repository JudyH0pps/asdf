package com.ssafy.camp.model.dao;

import java.util.List;

import com.ssafy.camp.model.dto.Camp;

public interface CampDao {
	public int insertCamp(Camp camp);

	public List<Camp> selectCamp(Camp camp);
	
	public List<Camp> selectAllCamp();

	public int deleteCamp(Camp camp);
	
	public int updateCamp(Camp camp);
	
	public Camp getCampById(int campid);
}
