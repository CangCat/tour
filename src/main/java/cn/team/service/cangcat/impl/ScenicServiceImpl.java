package cn.team.service.cangcat.impl;

import cn.team.entity.Scenic;
import cn.team.mapper.cangcat.ScenicMapper;
import cn.team.service.cangcat.ScenicService;
import cn.team.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CangCat
 * @date 2019/4/22 17:11
 */
@Service
@Transactional(rollbackFor = Exception.class)
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

    @Override
    public Scenic selectOne(Scenic scenic) {
        return scenicMapper.selectOne(scenic);
    }

    @Override
    public Scenic selectByPrimaryKey(Integer id) {
        return scenicMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scenicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(String ids) {
        return scenicMapper.deleteByIds(ids);
    }

    @Override
    public int insert(Scenic scenic) {
        return scenicMapper.insert(scenic);
    }

    @Override
    public int selectCount(Scenic scenic) {
        return scenicMapper.selectCount(scenic);
    }

    @Override
    public PageBean<Scenic> selectAllByPage(int page, int size, Scenic scenic) {
        int count = scenicMapper.selectCount(scenic);
        PageBean<Scenic> bean = new PageBean<Scenic>(size, page, count);
        List<Scenic> list = scenicMapper.selectAllByPage(bean.getStartIndex(), size);
        bean.setList(list);
        return bean;
    }

}
