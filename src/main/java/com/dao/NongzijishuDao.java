package com.dao;

import com.entity.NongzijishuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NongzijishuVO;
import com.entity.view.NongzijishuView;


/**
 * 农资技术
 * 
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
public interface NongzijishuDao extends BaseMapper<NongzijishuEntity> {
	
	List<NongzijishuVO> selectListVO(@Param("ew") Wrapper<NongzijishuEntity> wrapper);
	
	NongzijishuVO selectVO(@Param("ew") Wrapper<NongzijishuEntity> wrapper);
	
	List<NongzijishuView> selectListView(@Param("ew") Wrapper<NongzijishuEntity> wrapper);

	List<NongzijishuView> selectListView(Pagination page,@Param("ew") Wrapper<NongzijishuEntity> wrapper);
	
	NongzijishuView selectView(@Param("ew") Wrapper<NongzijishuEntity> wrapper);
	

}
