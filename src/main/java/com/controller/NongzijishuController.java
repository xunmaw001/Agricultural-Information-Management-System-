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

import com.entity.NongzijishuEntity;
import com.entity.view.NongzijishuView;

import com.service.NongzijishuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 农资技术
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-02 14:51:23
 */
@RestController
@RequestMapping("/nongzijishu")
public class NongzijishuController {
    @Autowired
    private NongzijishuService nongzijishuService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongzijishuEntity nongzijishu, 
		HttpServletRequest request){

        EntityWrapper<NongzijishuEntity> ew = new EntityWrapper<NongzijishuEntity>();


		PageUtils page = nongzijishuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongzijishu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongzijishuEntity nongzijishu, 
		HttpServletRequest request){
        EntityWrapper<NongzijishuEntity> ew = new EntityWrapper<NongzijishuEntity>();

		PageUtils page = nongzijishuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongzijishu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongzijishuEntity nongzijishu){
       	EntityWrapper<NongzijishuEntity> ew = new EntityWrapper<NongzijishuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongzijishu, "nongzijishu")); 
        return R.ok().put("data", nongzijishuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongzijishuEntity nongzijishu){
        EntityWrapper< NongzijishuEntity> ew = new EntityWrapper< NongzijishuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongzijishu, "nongzijishu")); 
		NongzijishuView nongzijishuView =  nongzijishuService.selectView(ew);
		return R.ok("查询农资技术成功").put("data", nongzijishuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongzijishuEntity nongzijishu = nongzijishuService.selectById(id);
        return R.ok().put("data", nongzijishu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongzijishuEntity nongzijishu = nongzijishuService.selectById(id);
        return R.ok().put("data", nongzijishu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongzijishuEntity nongzijishu, HttpServletRequest request){
    	nongzijishu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongzijishu);

        nongzijishuService.insert(nongzijishu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongzijishuEntity nongzijishu, HttpServletRequest request){
    	nongzijishu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongzijishu);

        nongzijishuService.insert(nongzijishu);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongzijishuEntity nongzijishu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongzijishu);
        nongzijishuService.updateById(nongzijishu);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongzijishuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
