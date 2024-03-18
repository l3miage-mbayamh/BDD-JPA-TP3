package fr.uga.l3miage.tp3.exo1.repositories;

import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity,String> {
    Set<ArtistEntity> findAllByName(String name);

}
