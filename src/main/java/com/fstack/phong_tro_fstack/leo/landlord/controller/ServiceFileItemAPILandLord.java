package com.fstack.phong_tro_fstack.leo.landlord.controller;

import com.fstack.phong_tro_fstack.leo.landlord.Google.FileResponseLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.Google.GoogleDriveServiceLandLord;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ServiceFileItemAPILandLord {
  private GoogleDriveServiceLandLord googleDriveService;

  @GetMapping("/leo/getallImage")
  public ResponseEntity<?> getAllFile() throws IOException {
    List<FileResponseLandLord> result = googleDriveService.getAllFile();
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
    @PostMapping("/leo/upImage/list-file-on-google-drive")
    public ResponseEntity<?> uploadListFileOnService(
        @RequestParam("listFiles") MultipartFile[] listFiles,
        @RequestParam("roomIndex") int roomIndex ,HttpSession session) { // Thêm tham số roomIndex
      // Kiểm tra xem file có tồn tại không
      if (listFiles.length == 0) {
        return ResponseEntity.badRequest().body("Không có file được chọn");
      } else {
        List<FileResponseLandLord> fileResponseList = new ArrayList<>();
        for (MultipartFile file : listFiles) {
          if (!file.getContentType().startsWith("image/")) {
            return ResponseEntity.badRequest().body("File không đúng định dạng ảnh");
          } else {
            try {
              FileResponseLandLord fileListResponse = googleDriveService.uploadFile(file);
              fileResponseList.add(fileListResponse);
            } catch (IOException e) {
              e.printStackTrace();
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi lưu file");
            }
          }
        }
        session.setAttribute("list-image"+roomIndex, new Gson().toJson(fileResponseList));

        return ResponseEntity.status(HttpStatus.CREATED).body(fileResponseList);
      }
    }


  @RequestMapping("/leo/upImage/one-file-on-google-drive")
  public ResponseEntity<?> uploadOneFileOnService(@RequestParam("file") MultipartFile files,
      HttpSession session) {

    // Kiểm tra xem file có tồn tại không
    if (files.getSize() == 0) {
      return ResponseEntity.badRequest().body("Không có file được chọn");
    } else {
      List<FileResponseLandLord> aFileResponse = new ArrayList<>();
      if (!files.getContentType().startsWith("image/")) {
        return ResponseEntity.badRequest().body("File không đúng định dạng ảnh");
      } else {
        try {
          FileResponseLandLord fileResponse = googleDriveService.uploadFile(files);
          aFileResponse.add(fileResponse);
        } catch (IOException e) {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi lưu file");
        }
      }
      session.setAttribute("one-image",new Gson().toJson(aFileResponse));
      return ResponseEntity.status(HttpStatus.CREATED).body(aFileResponse);
    }
  }


  @DeleteMapping("/{fileId}")
  public ResponseEntity<?> deleteFile(@PathVariable(name = "fileId") String fileId)
      throws IOException {
    googleDriveService.deleteFile(fileId);
    return ResponseEntity.status(HttpStatus.OK).body("File has been deleted");
  }


}
