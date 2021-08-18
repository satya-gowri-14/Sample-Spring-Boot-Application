package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.boot.model.UserAddress;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress,Long> {

}
