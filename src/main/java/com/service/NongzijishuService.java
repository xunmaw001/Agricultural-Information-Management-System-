package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongzijishuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongzijishuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongzijishuView;


/**
 * 农资技术
 *
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
public interface NongzijishuService extends IService<NongzijishuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongzijishuVO> selectListVO(Wrapper<NongzijishuEntity> wrapper);
   	
   	NongzijishuVO selectVO(@Param("ew") Wrapper<NongzijishuEntity> wrapper);
   	
   	List<NongzijishuView> selectListView(Wrapper<NongzijishuEntity> wrapper);
   	
   	NongzijishuView selectView(@Param("ew") Wrapper<NongzijishuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongzijishuEntity> wrapper);
   	

}

