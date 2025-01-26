package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongchanpinleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongchanpinleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchanpinleixingView;


/**
 * 农产品类型
 *
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
public interface NongchanpinleixingService extends IService<NongchanpinleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongchanpinleixingVO> selectListVO(Wrapper<NongchanpinleixingEntity> wrapper);
   	
   	NongchanpinleixingVO selectVO(@Param("ew") Wrapper<NongchanpinleixingEntity> wrapper);
   	
   	List<NongchanpinleixingView> selectListView(Wrapper<NongchanpinleixingEntity> wrapper);
   	
   	NongchanpinleixingView selectView(@Param("ew") Wrapper<NongchanpinleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongchanpinleixingEntity> wrapper);
   	

}

