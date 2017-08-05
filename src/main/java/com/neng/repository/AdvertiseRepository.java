package com.neng.repository;

import com.neng.pojo.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nengneng on 2017/8/5.
 */
@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise,Long> {
}
