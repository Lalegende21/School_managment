package SchoolManagment.controller;

import SchoolManagment.dto.LevelDTO;
import SchoolManagment.entity.Level;
import SchoolManagment.model.LevelMapper;
import SchoolManagment.serviceImpl.LevelServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "level")
public class LevelController {

    private final LevelServiceImpl levelService;
    private final LevelMapper levelMapper;

    public LevelController(LevelServiceImpl levelService, LevelMapper levelMapper) {
        this.levelService = levelService;
        this.levelMapper = levelMapper;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody LevelDTO levelDTO) {
        Level level = levelMapper.mapDTOToLevel(levelDTO);
        this.levelService.saveLevel(level);
        log.info("Level enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<LevelDTO> getAllLevel() {
        List<Level> levels = this.levelService.getAllLevel();
        return levels.stream()
                .map(level -> levelMapper.mapLevelToDto(level))
                .collect(Collectors.toList());
        //        return this.levelService.getAllLevel();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public LevelDTO getLevel(@PathVariable String id) {
        Level level = this.levelService.getLevel(id);

        LevelDTO levelDTO = levelMapper.mapLevelToDto(level);

        return levelDTO;
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateLevel(@PathVariable String id, @RequestBody LevelDTO levelDTO) {
        Level level = levelMapper.mapDTOToLevel(levelDTO);
        this.levelService.updateLevel(id, level);
        log.info("Mise a jour effectuee avec succes !");
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAllLevel() {
        this.levelService.deleteLevel();
        log.info("Tous les levels ont ete supprimes avec succes !");
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void deleteLevel(@PathVariable String id) {
        this.levelService.deleteLevelByid(id);
        log.info("Level supprime avec succes !");
    }
}
