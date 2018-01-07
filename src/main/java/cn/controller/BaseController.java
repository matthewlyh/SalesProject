package cn.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.service.ChannelService;
import cn.service.CustOrderService;
import cn.service.CustOrderViewService;
import cn.service.GoldService;
import cn.service.InterViewService;
import cn.service.LanService;
import cn.service.OfferProdRelService;
import cn.service.ProdOfferService;
import cn.service.ProductService;
import cn.service.StaffRankService;
import cn.service.StaffService;

public class BaseController {
	@Resource
	protected HttpServletRequest request;
	@Resource
	// 通过类型注入的内置对象
	protected HttpSession session;
	@Resource
	protected ServletContext application;

	// 三层架构: Controller ===> Service(接口)
	// 没有指定name,则会先按属性名注入
	@Resource
	protected StaffService staffService;
	@Resource
	protected ChannelService channelService;
	@Resource
	protected LanService lanService;
	@Resource
	protected InterViewService interViewService;
	@Resource
	protected GoldService goldService;
	@Resource
	protected CustOrderService custOrderService;
	@Resource
	protected ProdOfferService prodOfferService;
	@Resource
	protected ProductService productService;
	@Resource
	protected OfferProdRelService offerProdRelService;
	@Resource
	protected CustOrderViewService custOrderViewService;
	@Resource
	protected StaffRankService staffRankService;
   // @Autowired
   // private CustOrderViewService custOrderViewService;
    
	

    
}
