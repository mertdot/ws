package com.businesscard.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //@Autowired //eğer başka bir constructor olsaydı gerekirdi.
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
