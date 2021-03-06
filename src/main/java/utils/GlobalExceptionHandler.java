package utils;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.ErrorResult;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.NoSuchStudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchStudentException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex){
        String message=ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult=new ErrorResult(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
