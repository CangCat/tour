package cn.team.service.impl;

import cn.team.entity.Scenic;
import cn.team.mapper.ScenicMapper;
import cn.team.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CangCat
 * @date 2019/4/22 17:11
 */
@Service
public class ScenicServiceImpl implements ScenicService {

    @Autowired
    ScenicMapper scenicMapper;

    /**
     * 查询景区表所有内容
     *
     * @return
     */
    @Override
    public List<Scenic> selectAll() {
        return scenicMapper.selectAll();
    }

}
