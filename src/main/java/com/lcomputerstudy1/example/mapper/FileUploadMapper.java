package com.lcomputerstudy1.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lcomputerstudy1.example.domain.FileUpload;

@Mapper
public interface FileUploadMapper {

	public void fileUpload(FileUpload fu);
	
	public List<FileUpload> detailFileUpload(FileUpload fu);
}
