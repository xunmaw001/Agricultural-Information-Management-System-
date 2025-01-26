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


import com.dao.ZhongzhihuDao;
import com.entity.ZhongzhihuEntity;
import com.service.ZhongzhihuService;
import com.entity.vo.ZhongzhihuVO;
import com.entity.view.ZhongzhihuView;

@Service("zhongzhihuService")
public class ZhongzhihuServiceImpl extends ServiceImpl<ZhongzhihuDao, ZhongzhihuEntity> implements ZhongzhihuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhongzhihuEntity> page = this.selectPage(
                new Query<ZhongzhihuEntity>(params).getPage(),
                new EntityWrapper<ZhongzhihuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhongzhihuEntity> wrapper) {
		  Page<ZhongzhihuView> page =new Query<ZhongzhihuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhongzhihuVO> selectListVO(Wrapper<ZhongzhihuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhongzhihuVO selectVO(Wrapper<ZhongzhihuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhongzhihuView> selectListView(Wrapper<ZhongzhihuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhongzhihuView selectView(Wrapper<ZhongzhihuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
