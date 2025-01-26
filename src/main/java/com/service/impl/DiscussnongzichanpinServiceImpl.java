package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussnongzichanpinDao;
import com.entity.DiscussnongzichanpinEntity;
import com.service.DiscussnongzichanpinService;
import com.entity.vo.DiscussnongzichanpinVO;
import com.entity.view.DiscussnongzichanpinView;

@Service("discussnongzichanpinService")
public class DiscussnongzichanpinServiceImpl extends ServiceImpl<DiscussnongzichanpinDao, DiscussnongzichanpinEntity> implements DiscussnongzichanpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussnongzichanpinEntity> page = this.selectPage(
                new Query<DiscussnongzichanpinEntity>(params).getPage(),
                new EntityWrapper<DiscussnongzichanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussnongzichanpinEntity> wrapper) {
		  Page<DiscussnongzichanpinView> page =new Query<DiscussnongzichanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussnongzichanpinVO> selectListVO(Wrapper<DiscussnongzichanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussnongzichanpinVO selectVO(Wrapper<DiscussnongzichanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussnongzichanpinView> selectListView(Wrapper<DiscussnongzichanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussnongzichanpinView selectView(Wrapper<DiscussnongzichanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
