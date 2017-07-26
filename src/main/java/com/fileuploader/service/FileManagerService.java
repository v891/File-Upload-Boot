package com.fileuploader.service;

import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileuploader.dao.FileManagerDAO;
import com.fileuploader.entity.DocumentEntity;

@Service
public class FileManagerService {
	
	private final FileManagerDAO repository;
	
	public FileManagerService(FileManagerDAO repository) {
		this.repository = repository;
	}

	public String save(MultipartFile file) {
		try {
			ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
			DocumentEntity document = new DocumentEntity(file.getBytes(), file.getOriginalFilename(), file.getContentType(),
					Date.from(utc.toInstant()));
			
			repository.save(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL";
		}
		return "SUCCESS";

	}
	
	public List<DocumentEntity> getFiles() {
		return repository.findAll();
	}

}
