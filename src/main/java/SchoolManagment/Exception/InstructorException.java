package SchoolManagment.Exception;

public class InstructorException extends RuntimeException {

    public static final String SOMETHING_WENT_WRONG = "Something Went Wrong !";
    public static final String SUCCESSFUL = "Successfully !";
    public static final String DATA_NOT_FOUND = "Data not found !";

    public InstructorException(String message) {
        super(message);
    }
}
