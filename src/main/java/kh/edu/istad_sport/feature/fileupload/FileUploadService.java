package kh.edu.istad_sport.feature.fileupload;

import kh.edu.istad_sport.feature.fileupload.dto.FileUploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {
    // Upload single file
    FileUploadResponse upload(MultipartFile file);


    // Upload multi files
    List<FileUploadResponse> uploadMultiple(List<MultipartFile> files);

    // Delete
    void deleteByFileName(String fileName);

}
