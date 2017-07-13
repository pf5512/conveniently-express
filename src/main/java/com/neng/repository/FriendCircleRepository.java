package com.neng.repository;

import com.neng.pojo.FriendCircle;
import com.neng.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nengneng on 2017/7/13.
 */
@Repository
public interface FriendCircleRepository extends JpaRepository<FriendCircle,Long> {
    List<FriendCircle> findByUser(User user);

}
