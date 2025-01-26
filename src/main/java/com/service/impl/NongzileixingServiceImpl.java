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


import com.dao.NongzileixingDao;
import com.entity.NongzileixingEntity;
import com.service.NongzileixingService;
import com.entity.vo.NongzileixingVO;
import com.entity.view.NongzileixingView;

@Service("nongzileixingService")
public class NongzileixingServiceImpl extends ServiceImpl<NongzileixingDao, NongzileixingEntity> implements NongzileixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongzileixingEntity> page = this.selectPage(
                new Query<NongzileixingEntity>(params).getPage(),
                new EntityWrapper<NongzileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongzileixingEntity> wrapper) {
		  Page<NongzileixingView> page =new Query<NongzileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NongzileixingVO> selectListVO(Wrapper<NongzileixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongzileixingVO selectVO(Wrapper<NongzileixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongzileixingView> selectListView(Wrapper<NongzileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongzileixingView selectView(Wrapper<NongzileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
