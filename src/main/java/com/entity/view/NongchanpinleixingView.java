package com.entity.view;

import com.entity.NongchanpinleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 农产品类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
@TableName("nongchanpinleixing")
public class NongchanpinleixingView  extends NongchanpinleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NongchanpinleixingView(){
	}
 
 	public NongchanpinleixingView(NongchanpinleixingEntity nongchanpinleixingEntity){
 	try {
			BeanUtils.copyProperties(this, nongchanpinleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
