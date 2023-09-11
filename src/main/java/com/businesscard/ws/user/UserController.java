package com.businesscard.ws.user;

import com.businesscard.ws.ApiError.ApiError;
import com.businesscard.ws.shared.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping("/api/1.0/")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired //Dependency Injection
    UserService userService;

    //@CrossOrigin //bunu eklememizin sebepi farklı portlardan birbirine istek atılırken cors policy'den geçememesi. Bunu eklediğimizde özel header'lar isteklere ekleniyor ve sorun çözülüyor.
    @PostMapping("users") //Post Requestlerde Çalışacağını Belirttik.

    @ResponseStatus(HttpStatus.CREATED) //Istege bagli
    public GenericResponse createUser(@Valid @RequestBody User user){
        userService.save(user);
        return new GenericResponse("user created");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception){
        ApiError error = new ApiError(400, "Validation Error",  "api/1.0/users");
        Map<String, String> validationErrors =  new HashMap<>();
        for(FieldError fieldError: exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
    }
        error.setValidationErrors(validationErrors);
        return error;
    }

}
