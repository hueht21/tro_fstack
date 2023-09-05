package com.fstack.phong_tro_fstack.leo.landlord.Google;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface GoogleDriveServiceLandLord {

  FileResponseLandLord uploadFile(MultipartFile file) throws IOException;

  List<FileResponseLandLord> getAllFile() throws IOException;

  void deleteFile(String fileId) throws IOException;
}
