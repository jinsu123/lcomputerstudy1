package com.lcomputerstudy1.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lcomputerstudy1.example.domain.FileUpload;

@Mapper
public interface FileUploadMapper {

	public void fileUpload(FileUpload fu);
}
