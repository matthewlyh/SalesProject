package cn.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import cn.list.CustOrderList;
import cn.model.CustOrder;
import cn.model.ProdOffer;
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
     * bool结果；1订单存在且可以录入；2、订单不存在；3、订单存在但是已被录入，无法继续录入。
     */
    @RequestMapping("/FindCustId")
    @ResponseBody
    @CrossOrigin
    public CustOrderList FindCustId(HttpServletRequest request) {
    	System.out.println("--------------------------------");
        System.out.println("启动程序CustCoderController：FindCustId");
        Object CustOrderId = request.getParameter("id");
        CustOrderList custOrderQuery=new CustOrderList();
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
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	        String str=sdf.format(custOrder.getCustOrderDate()); 
	        custOrderQuery.setCust_order_date(str);
	        //System.out.println(str);
	        custOrderQuery.setProd_offer_id(custOrder.getProdOfferId());
	        custOrderQuery.setProd_offer_name(prodOffer.getProdOfferName());
	        custOrderQuery.setOffer_type(prodOffer.getOfferType());
	        custOrderQuery.setGold(prodOffer.getGold());
	        if (T)
	        	custOrderQuery.setBool(1);
	        else 
	        	custOrderQuery.setBool(3);
			
	        }
	        
	        else
	        {
	        	System.out.println("ID"+CustOrderId.toString()+"在数据库中找不到数据");
	        	custOrderQuery.setBool(2);
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


    /*根据销售名名称，输出所有订单号、销售员和金额；
     * 入参：ProName
     * 格式：
     * 出参：custorderview的所有字段
      */
    @RequestMapping("/FindCustByProName")
    @ResponseBody
    @CrossOrigin
    public List<CustOrderView> FindCustByProName(HttpServletRequest request) {
    	System.out.println("--------------------------------");
    	System.out.println("启动程序CustCoderController：FindCustByProName");
    	Object product_name=request.getParameter("ProName");
    	List<CustOrderView> list=null;
    	if (product_name ==null)
    	{
    		System.out.println("ProName不能为空");
    		return list;
    	}
    	else {
    		CustOrderView custOrderView=new CustOrderView();
    		custOrderView.setProduct_name(product_name.toString());
    		return custOrderViewService.queryList(custOrderView);
    		
		}
    }
   

}
