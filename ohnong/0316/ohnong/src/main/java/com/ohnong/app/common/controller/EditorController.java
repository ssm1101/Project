package com.ohnong.app.common.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EditorController {

		private Logger logger = LoggerFactory.getLogger(this.getClass());

		/**
		 * 파일이름 추출하기
		 * 1. 업로드한 파일의 확장자명 알아내기
		 * 2. (오늘날짜)_currentTimeMillis + 확장자 방식으로 파일명 생성
		 * 3. 파일 경로에 등록
		 * 4. 주소값 리턴 (https://localhost:8080/ohnong/images/파일 -> 바꿈.)
		 */
		@ResponseBody
		@RequestMapping(value = "image_upload.do", method = RequestMethod.POST)
		public String imageUpload(@RequestParam("image")MultipartFile multipartFile,
								  @RequestParam String uri, HttpServletRequest request) {

			if(multipartFile.isEmpty()) {
				logger.warn("user_write image upload detected, but there's no file.");
				return "not found";
			}

			String directory = "/etc/";   //이 이름의 폴더에 업로드 됩니다. 

			String fileName = multipartFile.getOriginalFilename();
			int lastIndex = fileName.lastIndexOf(".");
			String ext = fileName.substring(lastIndex, fileName.length());
			String newFileName = LocalDate.now() + "_" + System.currentTimeMillis() + ext;

			try {
				File image = new File(directory + newFileName);

				multipartFile.transferTo(image);

			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} finally {
				logger.info("uri : {}", uri);
				logger.info("Image Path : {}", directory);
				logger.info("File_name : {}", newFileName);
			}

			// 주소값 알아내기
			String path = request.getContextPath();
			int index = request.getRequestURL().indexOf(path);
			String url = request.getRequestURL().substring(0, index);

			// https://localhost:8080/ohnong/images/파일이름
			String contextPath = request.getContextPath();
		     return contextPath+"/home/ubuntu/etc/" + newFileName;
		}
}