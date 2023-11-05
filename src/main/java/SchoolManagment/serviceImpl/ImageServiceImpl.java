package SchoolManagment.serviceImpl;

import SchoolManagment.entity.Image;
import SchoolManagment.repository.ImageRepo;
import SchoolManagment.serviceImpl.service.ImageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepo imageRepo;

    @Override
    public String save(Image image) {
        try {
            imageRepo.save(image);
            return "Image register successfully!";
        } catch (Exception e){
            System.out.println(e);
            return "Something went wrong!";
        }
    }

    @Override
    public List<Image> getAllImage() {
        try {
            return imageRepo.findAll();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Optional<Image> getOneImage(String id) {
        try {
            return imageRepo.findById(id);
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    @Override
    public String delete() {
        try {
            imageRepo.deleteAll();
            return "All images delete successfully!";
        } catch (Exception e){
            System.out.println(e);
            return "Something went wrong!";
        }
    }

    @Override
    public String deleteImage(String id) {
        try {
            imageRepo.deleteById(id);
            return "Image delete successfully!";
        }catch (Exception e){
            System.out.println(e);
            return "Something went wrong!";
        }
    }

    @Override
    public boolean exists(String id) {
        return imageRepo.existsById(id);
    }
}
