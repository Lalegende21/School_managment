package SchoolManagment.files;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryImage {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Map upload(MultipartFile file) {

        try {
            Map data = this.cloudinary.uploader().upload(file.getBytes(), Map.of());
            String imageUrl = (String) data.get("secure_url");
            System.out.println(data);
            System.out.println(imageUrl);
            return data;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Image uploading fail!");
        }
    }


    public Map delete(String id){
        try {
            return cloudinary.uploader().destroy(id, Map.of());
        } catch (IOException e){
            System.out.println(e);
            return null;
        }
    }
}
