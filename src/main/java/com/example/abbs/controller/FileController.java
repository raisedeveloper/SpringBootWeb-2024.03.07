package com.example.abbs.controller;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class FileController {
	@Value("{spring.servlet.multipart.location}") private String uploadDir;
	
	@GetMapping("/profile/{filename}")
	public ResponseEntity<Resource> profile(@PathVariable String filename) {
		Path ipath = Paths.get(uploadDir + "profile/" + filename);
		try {
			String contentType = Files.probeContentType(path);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(
					ContentDisposition.builder("attachment")
									  .filename(filename, StandardCharsets.UTF_8)
									  .build()
					);
			headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@GetMapping("/download/{filename}")
	public ResponseEntity<Resource> download(@PathVariable String filename) {
	
		return null;
	}
}