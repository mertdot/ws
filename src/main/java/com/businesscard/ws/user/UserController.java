package com.businesscard.ws.user;

import com.businesscard.ws.shared.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0/")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired //Dependency Injection
    UserService userService;

    //@CrossOrigin //bunu eklememizin sebepi farklı portlardan birbirine istek atılırken cors policy'den geçememesi. Bunu eklediğimizde özel header'lar isteklere ekleniyor ve sorun çözülüyor.
    @PostMapping("users") //Post Requestlerde Çalışacağını Belirttik.
    @ResponseStatus(HttpStatus.CREATED) //Istege bagli
    public ResponseEntity<?> createUser(@RequestBody User user){
        String username = user.getUsername();
        if (username == null || username.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        userService.save(user);
        return ResponseEntity.ok(new GenericResponse("user created"));
    }
}
