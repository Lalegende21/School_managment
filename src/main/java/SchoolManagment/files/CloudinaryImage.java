package SchoolManagment.files;

import jakarta.mail.Multipart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryImage {

    public Map upload(MultipartFile file) throws IOException;
}
