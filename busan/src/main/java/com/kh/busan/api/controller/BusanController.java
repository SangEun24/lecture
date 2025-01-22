package com.kh.busan.api.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.busan.api.model.service.BusanService;
import com.kh.busan.api.model.vo.CommentDTO;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class BusanController {
	
	private final BusanService service; 
	
	@GetMapping("/busan")
	public ResponseEntity<String> getBusanFood(@RequestParam(name="page")int page) throws URISyntaxException{
		
		String response = service.getBusan(page);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/busan/{pk}")
	public ResponseEntity<String> getBusanDetail(@PathVariable(name="pk") int pk){
		
		String response = service.getBusanDetail(pk);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/comments")
	public ResponseEntity<String> save(@RequestBody CommentDTO comment){
		//System.out.print(comment);
		service.save(comment);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("성공~");
	}
	
	@GetMapping("/comments/{id}")
	public ResponseEntity<List<CommentDTO>> getComments(@PathVariable(name="id") Long foodNo){
		List<CommentDTO> list = service.getComments(foodNo);
		
		return ResponseEntity.ok(list);
	}
	
}
