package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n02.S05T01N02SantasusanaBerchMarc.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class FlowerExceptionHandler {

    @ExceptionHandler(FlowerNotFoundException.class )
    public final ResponseEntity<Object> handleFruitNotFoundException(FlowerNotFoundException e)
    {

        HttpStatus notFound = HttpStatus.NOT_FOUND;

        ApiException apiException = new ApiException(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, notFound);
    }

    @ExceptionHandler(FlowerAlreadyExistsException.class )
    public final ResponseEntity<Object> handleFruitAlreadyExistsException(FlowerAlreadyExistsException e)
    {
        HttpStatus notFound = HttpStatus.IM_USED;

        ApiException apiException = new ApiException(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, notFound);
    }
}
