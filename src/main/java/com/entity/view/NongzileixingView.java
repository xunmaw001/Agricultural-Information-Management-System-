package com.entity.view;

import com.entity.NongzileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 农资类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
@TableName("nongzileixing")
public class NongzileixingView  extends NongzileixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NongzileixingView(){
	}
 
 	public NongzileixingView(NongzileixingEntity nongzileixingEntity){
 	try {
			BeanUtils.copyProperties(this, nongzileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
