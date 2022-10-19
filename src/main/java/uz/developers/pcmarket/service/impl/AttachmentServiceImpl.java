package uz.developers.pcmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.developers.pcmarket.entity.Attachment;
import uz.developers.pcmarket.entity.AttachmentContent;
import uz.developers.pcmarket.payload.ApiResponce;
import uz.developers.pcmarket.repository.AttachmentContentRepository;
import uz.developers.pcmarket.repository.AttachmentRepository;
import uz.developers.pcmarket.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @Override
    public ApiResponce getFile(Integer id, HttpServletResponse response) throws IOException {

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
            Optional<AttachmentContent> byAttachmentIds = attachmentContentRepository.findByAttachmentIds(id);
            if (byAttachmentIds.isPresent()) {
                AttachmentContent attachmentContent = byAttachmentIds.get();
                response.setHeader("Content-Disposition",
                        "attachment; filename=\"" + attachment.getName()+"\"");
                response.setContentType(attachment.getContentType());

                FileCopyUtils.copy(attachmentContent.getBytes(),response.getOutputStream());
            }
            return new ApiResponce("Success",true);
        }
        return new ApiResponce("Photo is not found",false);
    }

    @Override
    public ApiResponce uploadPhoto(MultipartHttpServletRequest request) throws IOException {

        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);

        //
        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentRepository.save(attachmentContent);

        return new ApiResponce("Photo is saved",true,savedAttachment.getId());

    }
}
