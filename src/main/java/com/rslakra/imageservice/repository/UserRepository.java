package com.rslakra.imageservice.repository;

import com.rslakra.imageservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Rohtash Singh Lakra
 * Created: 2019-03-05 10:43
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
