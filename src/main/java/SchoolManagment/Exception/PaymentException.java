package SchoolManagment.Exception;

public class PaymentException extends RuntimeException {

    public static final String SOMETHING_WENT_WRONG = "Something Went Wrong !";
    public static final String SUCCESSFUL = "Successfully !";

    public static final String DATA_NOT_FOUND = "Data not found !";

    public PaymentException(String message) {
        super(message);
    }
}
