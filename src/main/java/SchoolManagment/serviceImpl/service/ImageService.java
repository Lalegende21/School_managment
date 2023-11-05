package SchoolManagment.serviceImpl.service;

import SchoolManagment.entity.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {

    //Save image
    String save(Image image);

    //Get all images
    List<Image> getAllImage();

    //Get image by id
    Optional<Image> getOneImage(String id);


    //delete all image
    String delete();

    //delete all image
    String deleteImage(String id);

    //existing image
    boolean exists(String id);
}
