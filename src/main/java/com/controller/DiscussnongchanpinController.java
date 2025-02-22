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

import com.entity.DiscussnongchanpinEntity;
import com.entity.view.DiscussnongchanpinView;

import com.service.DiscussnongchanpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 农产品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
@RestController
@RequestMapping("/discussnongchanpin")
public class DiscussnongchanpinController {
    @Autowired
    private DiscussnongchanpinService discussnongchanpinService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussnongchanpinEntity discussnongchanpin, 
		HttpServletRequest request){

        EntityWrapper<DiscussnongchanpinEntity> ew = new EntityWrapper<DiscussnongchanpinEntity>();


		PageUtils page = discussnongchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussnongchanpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussnongchanpinEntity discussnongchanpin, 
		HttpServletRequest request){
        EntityWrapper<DiscussnongchanpinEntity> ew = new EntityWrapper<DiscussnongchanpinEntity>();

		PageUtils page = discussnongchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussnongchanpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussnongchanpinEntity discussnongchanpin){
       	EntityWrapper<DiscussnongchanpinEntity> ew = new EntityWrapper<DiscussnongchanpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussnongchanpin, "discussnongchanpin")); 
        return R.ok().put("data", discussnongchanpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussnongchanpinEntity discussnongchanpin){
        EntityWrapper< DiscussnongchanpinEntity> ew = new EntityWrapper< DiscussnongchanpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussnongchanpin, "discussnongchanpin")); 
		DiscussnongchanpinView discussnongchanpinView =  discussnongchanpinService.selectView(ew);
		return R.ok("查询农产品评论表成功").put("data", discussnongchanpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussnongchanpinEntity discussnongchanpin = discussnongchanpinService.selectById(id);
        return R.ok().put("data", discussnongchanpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussnongchanpinEntity discussnongchanpin = discussnongchanpinService.selectById(id);
        return R.ok().put("data", discussnongchanpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussnongchanpinEntity discussnongchanpin, HttpServletRequest request){
    	discussnongchanpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussnongchanpin);

        discussnongchanpinService.insert(discussnongchanpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussnongchanpinEntity discussnongchanpin, HttpServletRequest request){
    	discussnongchanpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussnongchanpin);

        discussnongchanpinService.insert(discussnongchanpin);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussnongchanpinEntity discussnongchanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussnongchanpin);
        discussnongchanpinService.updateById(discussnongchanpin);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussnongchanpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
