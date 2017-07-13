package com.neng.repository;

import com.neng.pojo.ShowOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nengneng on 2017/7/13.
 */
@Repository
public interface ShowOrderRepository extends JpaRepository<ShowOrder,Long> {
}
