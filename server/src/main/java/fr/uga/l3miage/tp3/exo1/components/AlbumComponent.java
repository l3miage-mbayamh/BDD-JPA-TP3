package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Set;
@Component
@RequiredArgsConstructor
public class AlbumComponent {

    private final AlbumRepository albumRepository;

    public AlbumEntity getTitle(String title) {
        return albumRepository.findById(title).orElseThrow();
    }

    public AlbumEntity createAlbum(){
        AlbumEntity albumEntity = AlbumEntity
                .builder()
                .title("Roro")
                .releaseDate(Date.valueOf("18-03-2024"))
                .songEntities(Set.of())
                .artistEntity(new ArtistEntity())
                .build();
        return  albumRepository.save(albumEntity);
    }

    public AlbumEntity updateTitle(String title, String newTitle){
        AlbumEntity albumEntity = albumRepository.findById(title).orElseThrow();
        albumEntity.setTitle(newTitle);

        return  albumRepository.save(albumEntity);
    }

    public void deleteAlbum(String title){
        albumRepository.deleteById(title);
    }


}
