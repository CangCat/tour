package cn.team.service.cangcat.impl;

import cn.team.entity.Scenic;
import cn.team.entity.Scenicorder;
import cn.team.mapper.cangcat.ScenicorderMapper;
import cn.team.service.cangcat.ScenicorderService;
import cn.team.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CangCat
 * @date 2019/4/22 17:13
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ScenicorderServiceImpl implements ScenicorderService {

    @Autowired
    ScenicorderMapper scenicorderMapper;

    @Override
    public List<Scenicorder> selectAll() {
        return scenicorderMapper.selectAll();
    }

    @Override
    public int selectCount(Scenicorder scenicorder) {
        return scenicorderMapper.selectCount(scenicorder);
    }

    @Override
    public PageBean<Scenicorder> selectAllByPage(int page, int size, Scenicorder scenicorder) {
        int count = scenicorderMapper.selectCount(scenicorder);
        PageBean<Scenicorder> bean = new PageBean<Scenicorder>(size,page,count);
        List<Scenicorder> list = scenicorderMapper.selectAllByPage(bean.getStartIndex(), size);
        bean.setList(list);
        return bean;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scenicorderMapper.deleteByPrimaryKey(id);
    }
}
