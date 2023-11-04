package SchoolManagment.files;

import SchoolManagment.entity.Image;
import SchoolManagment.serviceImpl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "cloudinary")
public class CloudinaryImageController {

    @Autowired
    private CloudinaryServiceImpl cloudinaryService;

    @Autowired
    private ImageServiceImpl imageService;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/list")
    public void list(){
        this.imageService.getAllImage();
    }



    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "test")
    public String uploadImage(@RequestParam("image") MultipartFile file){
        Map data = this.cloudinaryService.upload(file);
        return "Image uploading successfully!";
    }


    @PostMapping(path = "/upload")
    public ResponseEntity<String> uploadImageData(@RequestParam("image") MultipartFile file) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        if (bufferedImage == null) {
            return new ResponseEntity<>("Image not valide!", HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(file);
        String imageUrl = (String) result.get("url");
        String public_id = (String) result.get("public_id");

        Image image = new Image((String) result.get("original_filename"),
                (String) result.get("url"),
                (String) result.get("public_id"));

        image.setCreate_at(LocalDateTime.now());
        image.setImageId(public_id);
        image.setImageUrl(imageUrl);
        imageService.save(image);
        return new ResponseEntity<>("Image register successfully!", HttpStatus.OK);
    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        Optional<Image> imageOptional = imageService.getOneImage(id);
        if (imageOptional.isEmpty()){
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
        Image image = imageOptional.get();
        String cloudinaryImageId = image.getImageId();
        cloudinaryService.delete(cloudinaryImageId);
        imageService.delete();
        return new ResponseEntity<>("image delete successfully!", HttpStatus.OK);
    }
}
