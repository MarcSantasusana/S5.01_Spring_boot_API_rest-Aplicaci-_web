package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.exceptions;

public class FlowerAlreadyExistsException extends RuntimeException{

    public FlowerAlreadyExistsException(String message, Throwable cause)
    {
        super(message, cause);

    }

    public FlowerAlreadyExistsException(String message)
    {

        super(message);

    }
}
