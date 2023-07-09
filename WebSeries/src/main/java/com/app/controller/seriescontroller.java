package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.seriesreqDTO;
import com.app.dto.updateDTO;
import com.app.service.seriesserviceimpl;

@RestController
@RequestMapping("/series")
public class seriescontroller {
	@Autowired
	private seriesserviceimpl sser;

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody @Valid seriesreqDTO sdto) {
		return ResponseEntity.status(HttpStatus.OK).body(sser.insert(sdto));
	}
	
	@GetMapping("/{sname}")
	public ResponseEntity<?> get(@PathVariable String sname) {
		return ResponseEntity.status(HttpStatus.OK).body(sser.get(sname));
	}

	@PutMapping("/updatation")
	public ResponseEntity<?> put(@RequestBody updateDTO udto) {
		return ResponseEntity.status(HttpStatus.OK).body(sser.put(udto));
	}
	
	@DeleteMapping("/delete/{sid}")
	public ResponseEntity<?> delete(@PathVariable Long sid) {
		return ResponseEntity.status(HttpStatus.OK).body(sser.delete(sid));
	}

}
