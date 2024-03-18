package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository  songRepository;

    public SongEntity getSong(String title){
        return songRepository.findById(title).orElseThrow();
    }

    public SongEntity createSong(){
        SongEntity songEntity = SongEntity
                .builder()
                .title("03 MAI 2025")
                .duration(Duration.ofDays(10))
                .albumEntity(new AlbumEntity())
                .artistEntity(new ArtistEntity())
                .build();
        return songRepository.save(songEntity);
    }

    public SongEntity updateTitle(String title, String newtitle){
        SongEntity songEntity = songRepository.findById(title).orElseThrow();
        songEntity.setTitle(newtitle);
        return songRepository.save(songEntity);
    }

    public void deleteSong(String title){
        songRepository.deleteById(title);
    }

}
