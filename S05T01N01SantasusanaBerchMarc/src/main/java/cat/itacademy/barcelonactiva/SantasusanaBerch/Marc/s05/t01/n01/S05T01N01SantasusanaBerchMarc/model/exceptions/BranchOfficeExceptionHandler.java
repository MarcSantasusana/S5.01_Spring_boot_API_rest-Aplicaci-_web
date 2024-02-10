package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n01.S05T01N01SantasusanaBerchMarc.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class BranchOfficeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BranchOfficeNotFoundException.class )
    public final ResponseEntity<Object> handleFruitNotFoundException(BranchOfficeNotFoundException e)
    {

        HttpStatus notFound = HttpStatus.NOT_FOUND;

        ApiException apiException = new ApiException(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, notFound);
    }

    @ExceptionHandler(BranchOfficeAlreadyExistsException.class )
    public final ResponseEntity<Object> handleFruitAlreadyExistsException(BranchOfficeAlreadyExistsException e)
    {
        HttpStatus notFound = HttpStatus.IM_USED;

        ApiException apiException = new ApiException(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, notFound);
    }

}