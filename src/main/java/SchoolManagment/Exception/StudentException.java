package SchoolManagment.Exception;

public class StudentException extends RuntimeException {

    public static final String SOMETHING_WENT_WRONG = "Something Went Wrong !";
    public static final String SUCCESSFUL = "Successfully !";

    public static final String DATA_NOT_FOUND = "Data not found !";

    public StudentException(String message) {
        super(message);
    }
}
