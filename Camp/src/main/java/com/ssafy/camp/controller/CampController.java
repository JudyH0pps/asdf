package com.ssafy.camp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.camp.model.dto.Camp;
import com.ssafy.camp.model.service.CampService;

@Controller
@RequestMapping("/api/camp")
@CrossOrigin("*")
public class CampController {
	@Autowired
	CampService campService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllCampList() {
		List<Camp> campList = campService.getAllCampList();
		return new ResponseEntity<List<Camp>>(campList, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> postCamp(Camp camp, @RequestParam(required=true) MultipartFile campImage) throws IOException {
		int result = campService.createCamp(camp, campImage);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<?> modifyCamp(@RequestBody Camp camp) {
		int result = campService.updateCamp(camp);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("")
	public ResponseEntity<?> deleteCamp(@RequestBody Camp camp) {
		int result = campService.deleteCamp(camp);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@GetMapping("/image/{imgFileName}")
	public ResponseEntity<?> getImage(@PathVariable String imgFileName) {
		Resource image = campService.loadCampImage(imgFileName);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imgFileName + "\"")
				.body(image);
	}
}
