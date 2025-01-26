package com.entity.model;

import com.entity.NongzichanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 农资产品
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
public class NongzichanpinModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 产品图片
	 */
	
	private String chanpintupian;
		
	/**
	 * 农资类型
	 */
	
	private String nongzileixing;
		
	/**
	 * 产品特点
	 */
	
	private String chanpintedian;
		
	/**
	 * 产品详情
	 */
	
	private String chanpinxiangqing;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 价格
	 */
	
	private Float price;
				
	
	/**
	 * 设置：产品图片
	 */
	 
	public void setChanpintupian(String chanpintupian) {
		this.chanpintupian = chanpintupian;
	}
	
	/**
	 * 获取：产品图片
	 */
	public String getChanpintupian() {
		return chanpintupian;
	}
				
	
	/**
	 * 设置：农资类型
	 */
	 
	public void setNongzileixing(String nongzileixing) {
		this.nongzileixing = nongzileixing;
	}
	
	/**
	 * 获取：农资类型
	 */
	public String getNongzileixing() {
		return nongzileixing;
	}
				
	
	/**
	 * 设置：产品特点
	 */
	 
	public void setChanpintedian(String chanpintedian) {
		this.chanpintedian = chanpintedian;
	}
	
	/**
	 * 获取：产品特点
	 */
	public String getChanpintedian() {
		return chanpintedian;
	}
				
	
	/**
	 * 设置：产品详情
	 */
	 
	public void setChanpinxiangqing(String chanpinxiangqing) {
		this.chanpinxiangqing = chanpinxiangqing;
	}
	
	/**
	 * 获取：产品详情
	 */
	public String getChanpinxiangqing() {
		return chanpinxiangqing;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Float getPrice() {
		return price;
	}
			
}
