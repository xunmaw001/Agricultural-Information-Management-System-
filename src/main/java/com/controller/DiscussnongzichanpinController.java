package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussnongzichanpinEntity;
import com.entity.view.DiscussnongzichanpinView;

import com.service.DiscussnongzichanpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 农资产品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
@RestController
@RequestMapping("/discussnongzichanpin")
public class DiscussnongzichanpinController {
    @Autowired
    private DiscussnongzichanpinService discussnongzichanpinService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussnongzichanpinEntity discussnongzichanpin, 
		HttpServletRequest request){

        EntityWrapper<DiscussnongzichanpinEntity> ew = new EntityWrapper<DiscussnongzichanpinEntity>();


		PageUtils page = discussnongzichanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussnongzichanpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussnongzichanpinEntity discussnongzichanpin, 
		HttpServletRequest request){
        EntityWrapper<DiscussnongzichanpinEntity> ew = new EntityWrapper<DiscussnongzichanpinEntity>();

		PageUtils page = discussnongzichanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussnongzichanpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussnongzichanpinEntity discussnongzichanpin){
       	EntityWrapper<DiscussnongzichanpinEntity> ew = new EntityWrapper<DiscussnongzichanpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussnongzichanpin, "discussnongzichanpin")); 
        return R.ok().put("data", discussnongzichanpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussnongzichanpinEntity discussnongzichanpin){
        EntityWrapper< DiscussnongzichanpinEntity> ew = new EntityWrapper< DiscussnongzichanpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussnongzichanpin, "discussnongzichanpin")); 
		DiscussnongzichanpinView discussnongzichanpinView =  discussnongzichanpinService.selectView(ew);
		return R.ok("查询农资产品评论表成功").put("data", discussnongzichanpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussnongzichanpinEntity discussnongzichanpin = discussnongzichanpinService.selectById(id);
        return R.ok().put("data", discussnongzichanpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussnongzichanpinEntity discussnongzichanpin = discussnongzichanpinService.selectById(id);
        return R.ok().put("data", discussnongzichanpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussnongzichanpinEntity discussnongzichanpin, HttpServletRequest request){
    	discussnongzichanpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussnongzichanpin);

        discussnongzichanpinService.insert(discussnongzichanpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussnongzichanpinEntity discussnongzichanpin, HttpServletRequest request){
    	discussnongzichanpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussnongzichanpin);

        discussnongzichanpinService.insert(discussnongzichanpin);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussnongzichanpinEntity discussnongzichanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussnongzichanpin);
        discussnongzichanpinService.updateById(discussnongzichanpin);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussnongzichanpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
