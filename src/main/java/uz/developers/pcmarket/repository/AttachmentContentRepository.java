package uz.developers.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.developers.pcmarket.entity.AttachmentContent;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {


    @Query(value = "select * from attachment_content where attachment_id = ?1",nativeQuery = true)
    Optional<AttachmentContent> findByAttachmentIds(Integer attachment_id);

}
