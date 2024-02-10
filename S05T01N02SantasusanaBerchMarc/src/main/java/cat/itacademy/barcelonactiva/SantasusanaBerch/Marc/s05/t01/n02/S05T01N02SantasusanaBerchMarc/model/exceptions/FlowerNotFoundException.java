package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.exceptions;

public class FlowerNotFoundException extends RuntimeException{

    public FlowerNotFoundException(String message, Throwable cause)
    {
        super(message, cause);

    }

    public FlowerNotFoundException(String message)
    {

        super(message);

    }
}
