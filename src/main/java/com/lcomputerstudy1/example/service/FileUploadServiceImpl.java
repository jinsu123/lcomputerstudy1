package com.lcomputerstudy1.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcomputerstudy1.example.domain.FileUpload;
import com.lcomputerstudy1.example.mapper.FileUploadMapper;


@Service
public class FileUploadServiceImpl implements FileUploadService{

	@Autowired FileUploadMapper FileUploadMapper;	

	@Override
	public void fileUpload(FileUpload fu){
		 FileUploadMapper.fileUpload(fu);
	}
	
	@Override
	public List<FileUpload> detailFileUpload(FileUpload fu){
		return FileUploadMapper.detailFileUpload(fu);
	}
}
