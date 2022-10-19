package uz.developers.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.developers.pcmarket.entity.Attachment;
import uz.developers.pcmarket.entity.AttachmentContent;

import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {


}
