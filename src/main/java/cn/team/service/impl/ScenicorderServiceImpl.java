package cn.team.service.impl;

import cn.team.entity.Scenicorder;
import cn.team.mapper.ScenicorderMapper;
import cn.team.service.ScenicorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CangCat
 * @date 2019/4/22 17:13
 */
@Service
public class ScenicorderServiceImpl implements ScenicorderService {

    @Autowired
    ScenicorderMapper scenicorderMapper;

    @Override
    public List<Scenicorder> selectAll() {
        return scenicorderMapper.selectAll();
    }
}
