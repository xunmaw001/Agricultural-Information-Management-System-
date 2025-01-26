package com.entity.vo;

import com.entity.NongzijishuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 农资技术
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
public class NongzijishuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 技术图片
	 */
	
	private String jishutupian;
		
	/**
	 * 种植技术
	 */
	
	private String zhongzhijishu;
		
	/**
	 * 肥料应用
	 */
	
	private String feiliaoyingyong;
		
	/**
	 * 适合作物
	 */
	
	private String shihezuowu;
		
	/**
	 * 技术详情
	 */
	
	private String jishuxiangqing;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
	/**
	 * 来源
	 */
	
	private String laiyuan;
				
	
	/**
	 * 设置：技术图片
	 */
	 
	public void setJishutupian(String jishutupian) {
		this.jishutupian = jishutupian;
	}
	
	/**
	 * 获取：技术图片
	 */
	public String getJishutupian() {
		return jishutupian;
	}
				
	
	/**
	 * 设置：种植技术
	 */
	 
	public void setZhongzhijishu(String zhongzhijishu) {
		this.zhongzhijishu = zhongzhijishu;
	}
	
	/**
	 * 获取：种植技术
	 */
	public String getZhongzhijishu() {
		return zhongzhijishu;
	}
				
	
	/**
	 * 设置：肥料应用
	 */
	 
	public void setFeiliaoyingyong(String feiliaoyingyong) {
		this.feiliaoyingyong = feiliaoyingyong;
	}
	
	/**
	 * 获取：肥料应用
	 */
	public String getFeiliaoyingyong() {
		return feiliaoyingyong;
	}
				
	
	/**
	 * 设置：适合作物
	 */
	 
	public void setShihezuowu(String shihezuowu) {
		this.shihezuowu = shihezuowu;
	}
	
	/**
	 * 获取：适合作物
	 */
	public String getShihezuowu() {
		return shihezuowu;
	}
				
	
	/**
	 * 设置：技术详情
	 */
	 
	public void setJishuxiangqing(String jishuxiangqing) {
		this.jishuxiangqing = jishuxiangqing;
	}
	
	/**
	 * 获取：技术详情
	 */
	public String getJishuxiangqing() {
		return jishuxiangqing;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：来源
	 */
	 
	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}
	
	/**
	 * 获取：来源
	 */
	public String getLaiyuan() {
		return laiyuan;
	}
			
}
