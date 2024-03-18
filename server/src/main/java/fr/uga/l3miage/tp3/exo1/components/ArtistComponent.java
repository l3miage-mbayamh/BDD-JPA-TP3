package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ArtistComponent {

    private final ArtistRepository artistRepository;

    public ArtistEntity getName(String name) {
        return artistRepository.findById(name).orElseThrow();
    }

    public ArtistEntity createArtist(){
        ArtistEntity artistEntity = ArtistEntity
                .builder()
                .name("Ninho")
                .biography("Artist Rappeur français")
                .genreMusical(GenreMusical.RAP)
                .albumEntities(Set.of())
                .build();
        return  artistRepository.save(artistEntity);
    }

    public ArtistEntity updateName(String name, String newName){
        ArtistEntity artistEntity = artistRepository.findById(name).orElseThrow();
        artistEntity.setName(newName);

        return  artistRepository.save(artistEntity);
    }

    public void deleteArtist(String name){
        artistRepository.deleteById(name);
    }




}
