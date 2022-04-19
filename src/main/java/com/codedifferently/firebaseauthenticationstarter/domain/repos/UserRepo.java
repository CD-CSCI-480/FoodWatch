package com.codedifferently.firebaseauthenticationstarter.domain.repos;

import com.codedifferently.firebaseauthenticationstarter.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {


}
