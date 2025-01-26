package com.entity.view;

import com.entity.ZhongzhihuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 种植户
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-02 14:51:22
 */
@TableName("zhongzhihu")
public class ZhongzhihuView  extends ZhongzhihuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhongzhihuView(){
	}
 
 	public ZhongzhihuView(ZhongzhihuEntity zhongzhihuEntity){
 	try {
			BeanUtils.copyProperties(this, zhongzhihuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
