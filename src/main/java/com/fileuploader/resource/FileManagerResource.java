package com.fileuploader.resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileuploader.service.FileManagerService;

@RestController
@RequestMapping(value = "file-manager")
public class FileManagerResource {

	private static final Logger LOG = Logger.getLogger(FileManagerResource.class);

	private final FileManagerService service;

	public FileManagerResource(FileManagerService fileManagerService) {
		this.service = fileManagerService;
	}

	@PostMapping(path = "upload")
	public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file) {
		String message = service.save(file);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	@GetMapping(path = "files")
	public ResponseEntity getFiles() {
		return ResponseEntity.ok(service.getFiles());
	}

}
