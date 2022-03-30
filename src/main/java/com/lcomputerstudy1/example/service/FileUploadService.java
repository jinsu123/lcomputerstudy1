package com.lcomputerstudy1.example.service;

import java.util.List;

import com.lcomputerstudy1.example.domain.FileUpload;

public interface FileUploadService {

	public void fileUpload(FileUpload fu);

	public List<FileUpload> detailFileUpload(FileUpload fu);
}
