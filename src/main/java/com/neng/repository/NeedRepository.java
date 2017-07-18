package com.neng.repository;

import com.neng.pojo.Need;
import com.neng.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nengneng on 2017/6/6.
 */
@Repository
public interface NeedRepository extends JpaRepository<Need, Long> {

    List<Need> findByUser(User user);

    List<Need> getByStatus(String status);
}
