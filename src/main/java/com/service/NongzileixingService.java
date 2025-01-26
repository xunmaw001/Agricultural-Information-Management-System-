package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongzileixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongzileixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongzileixingView;


/**
 * 农资类型
 *
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
public interface NongzileixingService extends IService<NongzileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongzileixingVO> selectListVO(Wrapper<NongzileixingEntity> wrapper);
   	
   	NongzileixingVO selectVO(@Param("ew") Wrapper<NongzileixingEntity> wrapper);
   	
   	List<NongzileixingView> selectListView(Wrapper<NongzileixingEntity> wrapper);
   	
   	NongzileixingView selectView(@Param("ew") Wrapper<NongzileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongzileixingEntity> wrapper);
   	

}

