package com.businesscard.ws.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{ //Database objesinin ismi ve id'nin tipi
}
