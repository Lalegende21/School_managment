package SchoolManagment.files;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadFile {

    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Value("${cloudinary.api_key}")
    private String apiKey;

    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    @Value("${cloudinary.secure}")
    private boolean secure;

    Cloudinary cloudinary;

    @PostConstruct
    public void init() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret,
                "secure", secure));
    }


    public String uploadImageToCloudinary(MultipartFile imageFile) {
        try {
            // Envoyez le fichier à Cloudinary
            Map<String, Object> uploadResult = cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());

            // Récupérez l'URL de l'image à partir du résultat de l'envoi
            String cloudinaryImageUrl = (String) uploadResult.get("secure_url");

            // Retournez l'URL de l'image
            return cloudinaryImageUrl;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "Something went wrong!";
        }
    }
}
