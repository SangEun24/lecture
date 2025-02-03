package com.kh.secom.board.model.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	private final Path fileLocation;

	public FileService() {
		this.fileLocation = Paths.get("uploads").toAbsolutePath().normalize();
	}

	public String store(MultipartFile file) {
		// 이름 바꾸는 메소드 호출~~
		String fileName = Paths.get(file.getOriginalFilename()).getFileName().toString();

		// 저장 위치 지정
		Path targetLocation = this.fileLocation.resolve(fileName);

		// 저장(복사)
		try {
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return "http://localhost/uploads/" + fileName;
		} catch (IOException e) {
			throw new RuntimeException("파일을 찾을 수 없습니다.");
		}
	}
}
