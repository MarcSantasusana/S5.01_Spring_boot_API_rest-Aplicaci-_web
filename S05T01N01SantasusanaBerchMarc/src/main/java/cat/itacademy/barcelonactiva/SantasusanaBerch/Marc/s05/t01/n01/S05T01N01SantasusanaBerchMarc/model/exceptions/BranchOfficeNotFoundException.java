package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.exceptions;

public class BranchOfficeNotFoundException extends RuntimeException{

    public BranchOfficeNotFoundException(String message, Throwable cause)
    {
        super(message, cause);

    }

    public BranchOfficeNotFoundException(String message)
    {

        super(message);

    }
}
