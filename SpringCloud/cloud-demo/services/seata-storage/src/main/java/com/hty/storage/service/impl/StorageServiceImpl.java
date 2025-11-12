package com.hty.storage.service.impl;

import com.hty.storage.mapper.StorageTblMapper;
import com.hty.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageTblMapper storageTblMapper;



    @Transactional// 开启事务
    @Override
    public void deduct(String commodityCode, int count) {
        storageTblMapper.deduct(commodityCode, count);
        if (count == 5) {
            throw new RuntimeException("库存不足");
        }
    }
}
