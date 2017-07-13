package com.neng.repository;

import com.neng.pojo.AlwaysLocation;
import com.neng.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlwaysLocationRepository extends JpaRepository<AlwaysLocation, Long> {
    List<AlwaysLocation> getByUser(User user);
}
