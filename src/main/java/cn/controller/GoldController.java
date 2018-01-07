package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.model.BooleanT;
import cn.model.CustOrder;
import cn.model.Gold;
import cn.model.ProdOffer;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/26.
 */
@Controller
public class GoldController extends BaseController {

    @RequestMapping("/InsertGold")
    @ResponseBody
    @CrossOrigin
    public BooleanT FindCustViewId(HttpServletRequest request) {
    	BooleanT T=new BooleanT();
    	int BoolInt=-1;
    	System.out.println("--------------------------------");
        System.out.println("启动程序CustCoderController：FindCustViewId");
        Object Cust_Order_ID = request.getParameter("id");
        CustOrder custOrderModel=custOrderService.FindCustOrderByID(Integer.valueOf(Cust_Order_ID.toString()));
        ProdOffer prodOfferModel=prodOfferService.FindProdOfferById(custOrderModel.getProdOfferId());
        int status_cd=custOrderModel.getStatusCd();
        if (status_cd==1)
        {
	        Gold gm=new Gold();
	        gm.setCustOrderId(custOrderModel.getCustOrderId());
	        gm.setChannelId(custOrderModel.getChannelId());
	        gm.setGold(prodOfferModel.getGold());
	        gm.setLanId(custOrderModel.getLanId());
	        gm.setStaffId(custOrderModel.getStaffId());
	        gm.setProdOfferId(custOrderModel.getProdOfferId());
	       
	        BoolInt=goldService.insertGold(gm);
	        if(BoolInt == 1)
	            custOrderService.updateCustOrder(custOrderService.FindCustOrderByID(gm.getCustOrderId()));
        }
        T.setBoolI(BoolInt);
        return(T);
    }


}
