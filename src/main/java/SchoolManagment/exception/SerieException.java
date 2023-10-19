package SchoolManagment.exception;

public class SerieException extends RuntimeException {

    public static final String SOMETHING_WENT_WRONG = "Something Went Wrong !";
    public static final String SUCCESSFUL = "Successfully !";

    public static final String DATA_NOT_FOUND = "Data not found !";

    public SerieException(String message) {
        super(message);
    }
}
