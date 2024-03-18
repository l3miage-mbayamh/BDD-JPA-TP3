package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    public PlaylistEntity getPlaylist(String name) {
        return playlistRepository.findById(name).orElseThrow();
    }

    public PlaylistEntity createPlaylist(){
        PlaylistEntity playlistEntity = PlaylistEntity
                .builder()
                .name("playlist1 ")
                .description("playlist preferé")
                .totalDuration(Duration.ofDays(10))
                .songEntities(Set.of())
                .build();
        return  playlistRepository.save(playlistEntity);
    }

    public PlaylistEntity updateName(String name, String newName){
        PlaylistEntity playlistEntity = playlistRepository.findById(name).orElseThrow();
        playlistEntity.setName(newName);

        return  playlistRepository.save(playlistEntity);
    }

    public void deletePlaylist(String name){
        playlistRepository.deleteById(name);
    }



}
