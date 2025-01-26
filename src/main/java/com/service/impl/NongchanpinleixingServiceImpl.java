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


import com.dao.NongchanpinleixingDao;
import com.entity.NongchanpinleixingEntity;
import com.service.NongchanpinleixingService;
import com.entity.vo.NongchanpinleixingVO;
import com.entity.view.NongchanpinleixingView;

@Service("nongchanpinleixingService")
public class NongchanpinleixingServiceImpl extends ServiceImpl<NongchanpinleixingDao, NongchanpinleixingEntity> implements NongchanpinleixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongchanpinleixingEntity> page = this.selectPage(
                new Query<NongchanpinleixingEntity>(params).getPage(),
                new EntityWrapper<NongchanpinleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongchanpinleixingEntity> wrapper) {
		  Page<NongchanpinleixingView> page =new Query<NongchanpinleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NongchanpinleixingVO> selectListVO(Wrapper<NongchanpinleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongchanpinleixingVO selectVO(Wrapper<NongchanpinleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongchanpinleixingView> selectListView(Wrapper<NongchanpinleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongchanpinleixingView selectView(Wrapper<NongchanpinleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
