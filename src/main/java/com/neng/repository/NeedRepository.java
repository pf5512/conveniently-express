package com.neng.repository;

import com.neng.pojo.Need;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nengneng on 2017/6/6.
 */
@Repository
public interface NeedRepository extends JpaRepository<Need, Long> {

}
