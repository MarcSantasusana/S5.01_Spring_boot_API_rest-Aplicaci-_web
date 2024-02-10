package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.exceptions;

public class BranchOfficeAlreadyExistsException extends RuntimeException {

    public BranchOfficeAlreadyExistsException(String message, Throwable cause)
    {
        super(message, cause);

    }

    public BranchOfficeAlreadyExistsException(String message)
    {

        super(message);

    }
}
