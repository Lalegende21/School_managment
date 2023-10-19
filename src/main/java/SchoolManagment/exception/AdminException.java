package SchoolManagment.exception;

public class AdminException extends RuntimeException {

    public static final String SOMETHING_WENT_WRONG = "Something Went Wrong !";
    public static final String SUCCESSFULL = "Successfulll !";
    public static final String DATA_NOT_FOUND = "Data not found !";

    public AdminException(String message) {
        super(message);
    }
}
