package SchoolManagment.Exception;

public class InstructorException extends RuntimeException {

    public static final String SOMETHING_WENT_WRONG = "Something Went Wrong !";
    public static final String SUCCESSFUL = "Successfully !";
    public static final String INVALID_DATA = "Invalid Date !";

    public InstructorException(String message) {
        super(message);
    }
}
