package SchoolManagment.serviceImpl.service;

import SchoolManagment.entity.Level;

import java.util.List;

public interface LevelService {

    //Save level
    String saveLevel(Level level);

    //Read all levels
    List<Level> getAllLevel();

    //Read level by id
    Level getLevel(String id);

    //Update level
    String updateLevel(String id, Level level);

    //Delete all levels
    void deleteLevel();

    //Delete level by id
    void deleteLevelById(String id);
}
