package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.LogisticsMapper;
import com.cc.shoppingnet_backend.pojo.Logistics;
import com.cc.shoppingnet_backend.service.LogisticsService;
import org.springframework.stereotype.Service;

@Service
public class LogisticsServiceImpl extends ServiceImpl<LogisticsMapper, Logistics> implements LogisticsService {
}
