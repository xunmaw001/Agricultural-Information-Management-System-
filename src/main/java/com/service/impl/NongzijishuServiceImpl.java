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


import com.dao.NongzijishuDao;
import com.entity.NongzijishuEntity;
import com.service.NongzijishuService;
import com.entity.vo.NongzijishuVO;
import com.entity.view.NongzijishuView;

@Service("nongzijishuService")
public class NongzijishuServiceImpl extends ServiceImpl<NongzijishuDao, NongzijishuEntity> implements NongzijishuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongzijishuEntity> page = this.selectPage(
                new Query<NongzijishuEntity>(params).getPage(),
                new EntityWrapper<NongzijishuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongzijishuEntity> wrapper) {
		  Page<NongzijishuView> page =new Query<NongzijishuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NongzijishuVO> selectListVO(Wrapper<NongzijishuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongzijishuVO selectVO(Wrapper<NongzijishuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongzijishuView> selectListView(Wrapper<NongzijishuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongzijishuView selectView(Wrapper<NongzijishuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
