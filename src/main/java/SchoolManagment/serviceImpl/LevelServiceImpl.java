package SchoolManagment.serviceImpl;

import SchoolManagment.exception.LevelException;
import SchoolManagment.entity.Level;
import SchoolManagment.repository.LevelRepo;
import SchoolManagment.serviceImpl.service.LevelService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {

    private final LevelRepo levelRepo;

    public LevelServiceImpl(LevelRepo levelRepo) {
        this.levelRepo = levelRepo;
    }

    @Override
    public String saveLevel(Level level) {
        Level levelName = this.levelRepo.findByName(level.getName());

        if (levelName == null){
            level.setCreate_at(LocalDateTime.now());
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

        if (levelUpdated.getId().equals(level.getId())) {
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
