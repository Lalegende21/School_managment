package SchoolManagment.exception;

public class Serie_SubjectException extends RuntimeException {

    public static final String SOMETHING_WENT_WRONG = "Something Went Wrong !";
    public static final String SUCCESSFUL = "Successfully !";

    public static final String DATA_NOT_FOUND = "Data not found !";

    public Serie_SubjectException(String message) {
        super(message);
    }
}
