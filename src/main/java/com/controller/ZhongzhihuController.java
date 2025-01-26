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

import com.entity.ZhongzhihuEntity;
import com.entity.view.ZhongzhihuView;

import com.service.ZhongzhihuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 种植户
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-02 14:51:22
 */
@RestController
@RequestMapping("/zhongzhihu")
public class ZhongzhihuController {
    @Autowired
    private ZhongzhihuService zhongzhihuService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ZhongzhihuEntity u = zhongzhihuService.selectOne(new EntityWrapper<ZhongzhihuEntity>().eq("zhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(u.getId(), username,"zhongzhihu",  "种植户" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ZhongzhihuEntity zhongzhihu){
    	//ValidatorUtils.validateEntity(zhongzhihu);
    	ZhongzhihuEntity u = zhongzhihuService.selectOne(new EntityWrapper<ZhongzhihuEntity>().eq("zhanghao", zhongzhihu.getZhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		zhongzhihu.setId(uId);
        zhongzhihuService.insert(zhongzhihu);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ZhongzhihuEntity u = zhongzhihuService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ZhongzhihuEntity u = zhongzhihuService.selectOne(new EntityWrapper<ZhongzhihuEntity>().eq("zhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
    	u.setMima("123456");
        zhongzhihuService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhongzhihuEntity zhongzhihu, 
		HttpServletRequest request){

        EntityWrapper<ZhongzhihuEntity> ew = new EntityWrapper<ZhongzhihuEntity>();


		PageUtils page = zhongzhihuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongzhihu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhongzhihuEntity zhongzhihu, 
		HttpServletRequest request){
        EntityWrapper<ZhongzhihuEntity> ew = new EntityWrapper<ZhongzhihuEntity>();

		PageUtils page = zhongzhihuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongzhihu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhongzhihuEntity zhongzhihu){
       	EntityWrapper<ZhongzhihuEntity> ew = new EntityWrapper<ZhongzhihuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhongzhihu, "zhongzhihu")); 
        return R.ok().put("data", zhongzhihuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhongzhihuEntity zhongzhihu){
        EntityWrapper< ZhongzhihuEntity> ew = new EntityWrapper< ZhongzhihuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhongzhihu, "zhongzhihu")); 
		ZhongzhihuView zhongzhihuView =  zhongzhihuService.selectView(ew);
		return R.ok("查询种植户成功").put("data", zhongzhihuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById(id);
        return R.ok().put("data", zhongzhihu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById(id);
        return R.ok().put("data", zhongzhihu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhongzhihuEntity zhongzhihu, HttpServletRequest request){
    	zhongzhihu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhongzhihu);
    	ZhongzhihuEntity u = zhongzhihuService.selectOne(new EntityWrapper<ZhongzhihuEntity>().eq("zhanghao", zhongzhihu.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}

		zhongzhihu.setId(new Date().getTime());
        zhongzhihuService.insert(zhongzhihu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhongzhihuEntity zhongzhihu, HttpServletRequest request){
    	zhongzhihu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhongzhihu);
    	ZhongzhihuEntity u = zhongzhihuService.selectOne(new EntityWrapper<ZhongzhihuEntity>().eq("zhanghao", zhongzhihu.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}

		zhongzhihu.setId(new Date().getTime());
        zhongzhihuService.insert(zhongzhihu);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhongzhihuEntity zhongzhihu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhongzhihu);
        zhongzhihuService.updateById(zhongzhihu);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhongzhihuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
