package com.ssafy.camp.model.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.camp.model.dao.CampDao;
import com.ssafy.camp.model.dto.Camp;

@Service
public class CampServiceImpl implements CampService {

	@Autowired
	CampDao campDao;

	File uploadFolder = new File("uploads");
	Path uploadFolderPath = null;

	public CampServiceImpl() throws IOException {
		uploadFolderPath = Paths.get(uploadFolder.getCanonicalPath());
	}

	@Override
	public List<Camp> getAllCampList() {
		return campDao.selectAllCamp();
	}

	@Override
	public int createCamp(Camp camp, MultipartFile campImage) throws IOException {

		if (!uploadFolder.exists()) {
			Files.createDirectory(uploadFolderPath);
		}

		if (!campImage.isEmpty() && campImage.getSize() != 0) {
			String today = Long.toString(System.currentTimeMillis());
			String newImageName = today + "_" + campImage.getOriginalFilename();

			camp.setOrgImg(campImage.getOriginalFilename());
			camp.setImg(newImageName);

			Path imagePath = uploadFolderPath.resolve(camp.getImg());

			campImage.transferTo(new File(imagePath.toString()));
		}

		return campDao.insertCamp(camp);
	}

	@Override
	public int deleteCamp(Camp camp) {
		return campDao.deleteCamp(camp);
	}

	@Override
	public int updateCamp(Camp camp) {
		return campDao.updateCamp(camp);
	}

	@Override
	public List<Camp> searchCamp(Camp camp) {
		return campDao.selectCamp(camp);
	}

	@Override
	public Camp getCamp(int campId) {
		return campDao.getCampById(campId);
	}

	@Override
	public Resource loadCampImage(String imgFileName) {
		Path campIamge = uploadFolderPath.resolve(imgFileName);
		Resource resource;
		try {
			resource = new UrlResource(campIamge.toUri());
			return resource;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
