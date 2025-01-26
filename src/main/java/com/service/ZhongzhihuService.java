package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhongzhihuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhongzhihuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhongzhihuView;


/**
 * 种植户
 *
 * @author 
 * @email 
 * @date 2023-05-02 14:51:22
 */
public interface ZhongzhihuService extends IService<ZhongzhihuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhongzhihuVO> selectListVO(Wrapper<ZhongzhihuEntity> wrapper);
   	
   	ZhongzhihuVO selectVO(@Param("ew") Wrapper<ZhongzhihuEntity> wrapper);
   	
   	List<ZhongzhihuView> selectListView(Wrapper<ZhongzhihuEntity> wrapper);
   	
   	ZhongzhihuView selectView(@Param("ew") Wrapper<ZhongzhihuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhongzhihuEntity> wrapper);
   	

}

