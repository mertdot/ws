package com.businesscard.ws.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    //@CrossOrigin //bunu eklememizin sebepi farklı portlardan birbirine istek atılırken cors policy'den geçememesi. Bunu eklediğimizde özel header'lar isteklere ekleniyor ve sorun çözülüyor.
    @PostMapping("/api/1.0/users") //Post Requestlerde Çalışacağını Belirttik.
    public void createUser(@RequestBody User user){
        log.info(user.toString());
    }
}
