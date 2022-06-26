package com.trionix.agrimartorder.repository;

import com.trionix.agrimartorder.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
