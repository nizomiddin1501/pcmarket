package uz.developers.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponce> getFileFromDB(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        ApiResponce file = attachmentService.getFile(id, response);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(file);
    }

    @PostMapping("/upload")
    public ResponseEntity<ApiResponce> uploadPhoto(MultipartHttpServletRequest request) throws IOException {
        ApiResponce apiResponce = attachmentService.uploadPhoto(request);
        if (apiResponce.isSuccess()){
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }


}
