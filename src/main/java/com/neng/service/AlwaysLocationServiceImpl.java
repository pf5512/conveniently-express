package com.neng.service;

import com.neng.repository.AlwaysLocationRepository;
import com.neng.service.inner.AlwaysLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nengneng on 2017/6/6.
 */
@Service
public class AlwaysLocationServiceImpl implements AlwaysLocationService {

    private AlwaysLocationRepository alwaysLocationRepository;

    @Autowired
    public AlwaysLocationServiceImpl(AlwaysLocationRepository alwaysLocationRepository) {
        this.alwaysLocationRepository = alwaysLocationRepository;
    }
}
