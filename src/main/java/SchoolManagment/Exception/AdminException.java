package SchoolManagment.Exception;

public class AdminException extends RuntimeException {

    public static final String SOMETHING_WENT_WRONG = "Something Went Wrong !";
    public static final String SUCCESSFULL = "Successfulll !";
    public static final String INVALID_DATA = "Invalid Date !";

    public AdminException(String message) {
        super(message);
    }
}
