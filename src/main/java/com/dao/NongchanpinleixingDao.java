package com.dao;

import com.entity.NongchanpinleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NongchanpinleixingVO;
import com.entity.view.NongchanpinleixingView;


/**
 * 农产品类型
 * 
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
public interface NongchanpinleixingDao extends BaseMapper<NongchanpinleixingEntity> {
	
	List<NongchanpinleixingVO> selectListVO(@Param("ew") Wrapper<NongchanpinleixingEntity> wrapper);
	
	NongchanpinleixingVO selectVO(@Param("ew") Wrapper<NongchanpinleixingEntity> wrapper);
	
	List<NongchanpinleixingView> selectListView(@Param("ew") Wrapper<NongchanpinleixingEntity> wrapper);

	List<NongchanpinleixingView> selectListView(Pagination page,@Param("ew") Wrapper<NongchanpinleixingEntity> wrapper);
	
	NongchanpinleixingView selectView(@Param("ew") Wrapper<NongchanpinleixingEntity> wrapper);
	

}
