package uz.developers.pcmarket.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.developers.pcmarket.payload.ApiResponce;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AttachmentService {
    ApiResponce getFile(Integer id, HttpServletResponse response) throws IOException;

    ApiResponce uploadPhoto(MultipartHttpServletRequest request) throws IOException;
}
