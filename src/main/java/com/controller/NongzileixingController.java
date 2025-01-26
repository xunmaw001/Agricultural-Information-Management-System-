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

import com.entity.NongzileixingEntity;
import com.entity.view.NongzileixingView;

import com.service.NongzileixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 农资类型
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
@RestController
@RequestMapping("/nongzileixing")
public class NongzileixingController {
    @Autowired
    private NongzileixingService nongzileixingService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongzileixingEntity nongzileixing, 
		HttpServletRequest request){

        EntityWrapper<NongzileixingEntity> ew = new EntityWrapper<NongzileixingEntity>();


		PageUtils page = nongzileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongzileixing), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongzileixingEntity nongzileixing, 
		HttpServletRequest request){
        EntityWrapper<NongzileixingEntity> ew = new EntityWrapper<NongzileixingEntity>();

		PageUtils page = nongzileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongzileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongzileixingEntity nongzileixing){
       	EntityWrapper<NongzileixingEntity> ew = new EntityWrapper<NongzileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongzileixing, "nongzileixing")); 
        return R.ok().put("data", nongzileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongzileixingEntity nongzileixing){
        EntityWrapper< NongzileixingEntity> ew = new EntityWrapper< NongzileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongzileixing, "nongzileixing")); 
		NongzileixingView nongzileixingView =  nongzileixingService.selectView(ew);
		return R.ok("查询农资类型成功").put("data", nongzileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongzileixingEntity nongzileixing = nongzileixingService.selectById(id);
        return R.ok().put("data", nongzileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongzileixingEntity nongzileixing = nongzileixingService.selectById(id);
        return R.ok().put("data", nongzileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongzileixingEntity nongzileixing, HttpServletRequest request){
    	nongzileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongzileixing);

        nongzileixingService.insert(nongzileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongzileixingEntity nongzileixing, HttpServletRequest request){
    	nongzileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongzileixing);

        nongzileixingService.insert(nongzileixing);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongzileixingEntity nongzileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongzileixing);
        nongzileixingService.updateById(nongzileixing);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongzileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
