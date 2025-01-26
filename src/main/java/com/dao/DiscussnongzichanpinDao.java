package com.dao;

import com.entity.DiscussnongzichanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussnongzichanpinVO;
import com.entity.view.DiscussnongzichanpinView;


/**
 * 农资产品评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
public interface DiscussnongzichanpinDao extends BaseMapper<DiscussnongzichanpinEntity> {
	
	List<DiscussnongzichanpinVO> selectListVO(@Param("ew") Wrapper<DiscussnongzichanpinEntity> wrapper);
	
	DiscussnongzichanpinVO selectVO(@Param("ew") Wrapper<DiscussnongzichanpinEntity> wrapper);
	
	List<DiscussnongzichanpinView> selectListView(@Param("ew") Wrapper<DiscussnongzichanpinEntity> wrapper);

	List<DiscussnongzichanpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussnongzichanpinEntity> wrapper);
	
	DiscussnongzichanpinView selectView(@Param("ew") Wrapper<DiscussnongzichanpinEntity> wrapper);
	

}
