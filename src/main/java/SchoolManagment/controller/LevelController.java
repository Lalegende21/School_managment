package SchoolManagment.controller;

import SchoolManagment.dto.LevelDTO;
import SchoolManagment.entity.Level;
import SchoolManagment.model.LevelMapper;
import SchoolManagment.serviceImpl.LevelServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "level")
public class LevelController {

    private final LevelServiceImpl levelService;
    private final LevelMapper levelMapper;



    //Method to save level
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public String Create(@RequestBody LevelDTO levelDTO) {
        Level level = levelMapper.mapDTOToLevel(levelDTO);
        this.levelService.saveLevel(level);
        return "Level register successfully !";
    }


    //Method to read all levels
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<LevelDTO> getAllLevel() {
        List<Level> levels = this.levelService.getAllLevel();
        return levels.stream()
                .map(level -> levelMapper.mapLevelToDto(level))
                .collect(Collectors.toList());
        //        return this.levelService.getAllLevel();
    }



    //Method to read level by id
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public LevelDTO getLevel(@PathVariable String id) {
        Level level = this.levelService.getLevel(id);

        LevelDTO levelDTO = levelMapper.mapLevelToDto(level);

        return levelDTO;
    }



    //Method to update level
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public String updateLevel(@PathVariable String id, @RequestBody LevelDTO levelDTO) {
        Level level = levelMapper.mapDTOToLevel(levelDTO);
        this.levelService.updateLevel(id, level);
        return "Update complete successfully!";
    }


    //Method to delete all levels
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping
    public String deleteAllLevel() {
        this.levelService.deleteLevel();
        return "All levels delete successfully!";
    }


    //Method to delete level by id
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public String deleteLevel(@PathVariable String id) {
        this.levelService.deleteLevelById(id);
        return "Level delete successfully!";
    }
}
