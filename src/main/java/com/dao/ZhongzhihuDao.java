package com.dao;

import com.entity.ZhongzhihuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhongzhihuVO;
import com.entity.view.ZhongzhihuView;


/**
 * 种植户
 * 
 * @author 
 * @email 
 * @date 2023-05-02 14:51:22
 */
public interface ZhongzhihuDao extends BaseMapper<ZhongzhihuEntity> {
	
	List<ZhongzhihuVO> selectListVO(@Param("ew") Wrapper<ZhongzhihuEntity> wrapper);
	
	ZhongzhihuVO selectVO(@Param("ew") Wrapper<ZhongzhihuEntity> wrapper);
	
	List<ZhongzhihuView> selectListView(@Param("ew") Wrapper<ZhongzhihuEntity> wrapper);

	List<ZhongzhihuView> selectListView(Pagination page,@Param("ew") Wrapper<ZhongzhihuEntity> wrapper);
	
	ZhongzhihuView selectView(@Param("ew") Wrapper<ZhongzhihuEntity> wrapper);
	

}
