package SchoolManagment.controller;

import SchoolManagment.entity.Level;
import SchoolManagment.serviceImpl.LevelServiceImpl;
import SchoolManagment.serviceImpl.service.LevelService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "level")
public class LevelController {

    private LevelServiceImpl levelService;

    public LevelController(LevelServiceImpl levelService) {
        this.levelService = levelService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody Level level) {
        this.levelService.saveLevel(level);
        log.info("Level enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Level> getAllLevel() {
        return this.levelService.getAllLevel();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public Level getLevel(@PathVariable String id) {
        return this.levelService.getLevel(id);
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateLevel(@PathVariable String id, @RequestBody Level level) {
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
