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


import com.dao.NongzichanpinDao;
import com.entity.NongzichanpinEntity;
import com.service.NongzichanpinService;
import com.entity.vo.NongzichanpinVO;
import com.entity.view.NongzichanpinView;

@Service("nongzichanpinService")
public class NongzichanpinServiceImpl extends ServiceImpl<NongzichanpinDao, NongzichanpinEntity> implements NongzichanpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongzichanpinEntity> page = this.selectPage(
                new Query<NongzichanpinEntity>(params).getPage(),
                new EntityWrapper<NongzichanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongzichanpinEntity> wrapper) {
		  Page<NongzichanpinView> page =new Query<NongzichanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NongzichanpinVO> selectListVO(Wrapper<NongzichanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongzichanpinVO selectVO(Wrapper<NongzichanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongzichanpinView> selectListView(Wrapper<NongzichanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongzichanpinView selectView(Wrapper<NongzichanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
