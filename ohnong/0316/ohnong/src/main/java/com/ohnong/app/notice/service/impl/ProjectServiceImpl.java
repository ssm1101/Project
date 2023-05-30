package com.ohnong.app.notice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.notice.mapper.ProjectMapper;
import com.ohnong.app.notice.service.ProjectService;
import com.ohnong.app.notice.service.ProjectVO;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectMapper projectMapper;

	@Override
	public ProjectVO getProject(int seq) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
