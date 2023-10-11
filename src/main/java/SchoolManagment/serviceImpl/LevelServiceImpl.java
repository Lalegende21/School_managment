package SchoolManagment.serviceImpl;

import SchoolManagment.Exception.LevelException;
import SchoolManagment.entity.Level;
import SchoolManagment.repository.LevelRepo;
import SchoolManagment.serviceImpl.service.LevelService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class LevelServiceImpl implements LevelService {

    private LevelRepo levelRepo;

    @Override
    public String saveLevel(Level level) {
        Level levelName = this.levelRepo.findByName(level.getName());

        if (levelName == null){
            this.levelRepo.save(level);
            return LevelException.SUCCESSFUL;
        }
        else {
            return LevelException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public List<Level> getAllLevel() {
        return this.levelRepo.findAll();
    }

    @Override
    public Level getLevel(String id) {
        Optional<Level> optionalLevel = this.levelRepo.findById(id);
        return optionalLevel.orElseThrow(() -> new RuntimeException(LevelException.DATA_NOT_FOUND));
    }

    @Override
    public String updateLevel(String id, Level level) {
        Level levelUpdated = this.getLevel(id);

        if (levelUpdated.getId() == level.getId()) {
            levelUpdated.setName(level.getName());
            levelUpdated.setType(level.getType());
            this.levelRepo.save(levelUpdated);
            return LevelException.SUCCESSFUL;
        }
        else {
            return LevelException.SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public void deleteLevel() {
        this.levelRepo.deleteAll();
    }

    @Override
    public void deleteLevelByid(String id) {
        this.levelRepo.deleteById(id);
    }
}
