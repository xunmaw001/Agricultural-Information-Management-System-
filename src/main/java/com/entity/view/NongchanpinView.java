package com.entity.view;

import com.entity.NongchanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 农产品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
@TableName("nongchanpin")
public class NongchanpinView  extends NongchanpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NongchanpinView(){
	}
 
 	public NongchanpinView(NongchanpinEntity nongchanpinEntity){
 	try {
			BeanUtils.copyProperties(this, nongchanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
