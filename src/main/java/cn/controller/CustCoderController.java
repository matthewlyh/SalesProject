package cn.controller;

import java.util.List;

import cn.model.CustOrder;
import cn.model.ProdOffer;
import cn.query.CustOrderQuery;
import cn.view.CustOrderView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/26.
 */
@Controller
public class CustCoderController extends BaseController{
    
    /*根据id获取到当前销售品信息
     * 入参：id[代表CustOrderId]
     * 出参：Cust_order_id、Staff_name、Product_name、Cust_order_date、Prod_offer_id、Prod_offer_name、Offer_type、Gold、Bool[true代表可销售，false代表已销售]
     * 纠错：如果未输入id或者id在数据库中找不到对应的内容，反馈null
     */
    @RequestMapping("/FindCustId")
    @ResponseBody
    @CrossOrigin
    public CustOrderQuery FindCustId(HttpServletRequest request) {
    	System.out.println("--------------------------------");
        System.out.println("启动程序CustCoderController：FindCustId");
        Object CustOrderId = request.getParameter("id");
        CustOrderQuery custOrderQuery=new CustOrderQuery();
        if (CustOrderId !=null)
        {
	        CustOrder custOrder=custOrderService.FindCustOrderByID(Integer.valueOf(CustOrderId.toString()));
	        if (custOrder !=null)
	        {
	        int id=custOrder.getProdOfferId();
	        ProdOffer prodOffer=prodOfferService.FindProdOfferById(id);
	        boolean T=custOrderService.FindCustOrderId(Integer.valueOf(CustOrderId.toString()));
	        custOrderQuery.setCust_order_id(custOrder.getCustOrderId());
	        custOrderQuery.setStaff_name(staffService.findStaffById(custOrder.getStaffId()).getStaffName());
	        custOrderQuery.setProduct_name(productService.selectByPrimaryKey(offerProdRelService.selectByPrimaryKey(custOrder.getProdOfferId()).getProductId()).getProductName());
	        custOrderQuery.setCust_order_date(custOrder.getCustOrderDate().toString());
	        custOrderQuery.setProd_offer_id(custOrder.getProdOfferId());
	        custOrderQuery.setProd_offer_name(prodOffer.getProdOfferName());
	        custOrderQuery.setOffer_type(prodOffer.getOfferType());
	        custOrderQuery.setGold(prodOffer.getGold());
	        custOrderQuery.setBool(T);
	        }
	        else
	        {
	        	System.out.println("ID"+CustOrderId.toString()+"在数据库中找不到数据");
	        	custOrderQuery=null;
	        }
        }
        else {
        	System.out.println("ID不能为空");
        	custOrderQuery=null;
		}
        return custOrderQuery;
    }

    
    /*根据产品ID、时间、销售品类型订单信息表。
     * 入参：CustId、Date、Prod_offer_name均为可选项，不支持模糊查询
     * 格式：2017-10-26，或者2017等等均可
     * 出参：custOrderView视图的所有参数；
     */
    @RequestMapping("/FindCustViewId")
    @ResponseBody
    @CrossOrigin
    public List<CustOrderView> FindCustViewId(HttpServletRequest request) {
    	System.out.println("--------------------------------");
    	System.out.println("启动程序CustCoderController：FindCustViewId");
    	Object CustOrderId = request.getParameter("CustId");
    	Object Date = request.getParameter("Date");
    	Object Prod_offer_name = request.getParameter("Prod_offer_name");
    	
    	CustOrderView custOrderView=new CustOrderView();
    	
    	if (CustOrderId!=null)
    		custOrderView.setCust_order_id(Integer.valueOf(CustOrderId.toString()));
    	if (Date !=null)
    		custOrderView.setCust_order_date(Date.toString());
    	if (Prod_offer_name !=null)
    		custOrderView.setProd_offer_name(Prod_offer_name.toString());

    	
    	return custOrderViewService.queryList(custOrderView);
    }





}
