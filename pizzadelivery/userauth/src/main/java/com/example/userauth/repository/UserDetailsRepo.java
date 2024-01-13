package com.example.userauth.repository;

import com.example.userauth.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,String> {

}
