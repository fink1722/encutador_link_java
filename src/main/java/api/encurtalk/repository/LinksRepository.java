package api.encurtalk.repository;

import api.encurtalk.entities.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinksRepository extends JpaRepository<Links, Long> {



    Optional<Links> findByLinkNovo(String linkNovo);


}
