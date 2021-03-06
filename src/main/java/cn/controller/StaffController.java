package cn.controller;

import cn.list.StaffList;
import cn.model.BooleanT;
import cn.model.Channel;
import cn.model.Lan;
import cn.model.Staff;
import cn.query.PagedData;
import cn.query.StaffQuery;
import cn.util.MD5Utils;
import cn.view.InterView;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 * 处理所有用户的Staff请求；
 */
@Controller
public class StaffController extends BaseController{
	/*
	 * StaffController:Login
	 * 入参：用户账号staff_code，用户密码pass_word；
	 * 出参：如果匹配，则反馈用户Staff对象，如果不匹配，反馈NULL
	 * */
    @RequestMapping("/Login")
    @ResponseBody
    @CrossOrigin
    public Staff Login(HttpServletRequest request) {
    	System.out.println("--------------------------------");
        System.out.println("StaffController：Login");
        Object staff_code = request.getParameter("staff_code");
        Object pass_word = request.getParameter("pass_word");
        Staff staff=null;
        
        if (staff_code !=null && pass_word != null)
        {
        	//System.out.println("后端获取到"+staff_code);
        	System.out.println("账号密码获取成功："+staff_code+" "+pass_word);
        	staff=staffService.findStaffByIdAndPass(staff_code.toString(),MD5Utils.md5Password(pass_word.toString()));
        	return staff;
        }
        else {
        	System.out.println("账号或密码获取失败");
        	return null;
		}
        
       
        
    }
    
    
    /*
	 * StaffController:LoginIn
	 * 入参：用户主键id[不是StaffCode]
	 * 出参：如果匹配，则反馈用户StaffList[包括Staff、Lan、Channel、视图Interview等多个类的信息]对象，如果不匹配，反馈NULL
	 * */
    @RequestMapping("/LoginIn")
    @ResponseBody
    @CrossOrigin
    public StaffList LoginIn(HttpServletRequest request) {
        System.out.println("--------------------------------");
        System.out.println("StaffController：LoginIn");
        StaffList List=new StaffList();
        Object Sid= request.getParameter("id");
        //System.out.println("ID:"+Sid);
        if (Sid != null) {
            int id = Integer.valueOf(Sid.toString());
            Staff sm=staffService.findStaffById(id);
            if (sm !=null)
            {
            	System.out.println("ID:"+id+"用户获取成功，如果用户信息获取错误，则说明Channel、Lan表或者视图Interview中存在逻辑问题,请查看数据库");
	            Channel cm=channelService.FindChannelById(sm.getChannelId());
	            Lan lm=lanService.FindLanByID(sm.getLanId());
	            InterView interView=interViewService.findInterViewById(sm.getStaffId());
	            List.setStaff_code(sm.getStaffCode());
	            List.setStaff_name(sm.getStaffName());
	            List.setSex(sm.getSex());
	            List.setLan_name(lm.getLanName());
	            List.setPhone_nbr(sm.getPhoneNbr());
	            List.setChannel_name(cm.getChannelName());
	            List.setGold(interView.getGold());
	            List<InterView> list=interViewService.query();
	            int Sank=1;
	            for(int i=0;i<list.size();i++)
	                if (list.get(i).getGold()>interView.getGold())
	                    Sank=Sank+1;
	            List.setSank(Sank);
	            return List;
            }
            else {
            	System.out.println("ID:"+id+"用户不存在");
				return null;
			}
            
        }
        else
        {
        	System.out.println("ID字段未获取到!");
            return null;
        }
    }

    /*修改密码，
     * 入参:用户主键id、旧密码oldpwd、新密码newpwd
     * 出参：{"bool":null,"boolI":2}反馈类型，BoolI，1代表用户修改成功，2代表修改失败，3代表旧密码不正确，4代表ID不能为空.5获取字段失败

    */
    @RequestMapping("/UpdatePWD")
    @ResponseBody
    @CrossOrigin
    public BooleanT UpdatePWD(HttpServletRequest request) {
    	System.out.println("--------------------------------");
        System.out.println("StaffController：UpdatePWD");
        Object OldPassWord=request.getParameter("oldpwd");
        Object NewPassWord=request.getParameter("newpwd");
        Object id= request.getParameter("id");
        BooleanT T=new BooleanT();
        Staff staff=new Staff();
        
        if (OldPassWord ==null || NewPassWord == null)
        {
        	T.setBoolI(5); 
        	System.out.println("新旧密码不能为空");
        }
        else {
        	String op=MD5Utils.md5Password(OldPassWord.toString());
        	String np=MD5Utils.md5Password(NewPassWord.toString());
        	

	        if (id == null)
	        {
	        	System.out.println("ID不能为空");
	            T.setBoolI(4);
	        }
	        else {
	        	int Id=Integer.valueOf(id.toString());
	        	staff = staffService.findStaffByIdAndPass(staffService.findStaffById(Integer.valueOf(id.toString())).getStaffCode(), op);
	            if (staff == null)
	            {
	            	//System.out.println(id+"用户旧密码不正确");
	                T.setBoolI(3);
	            }
	            else if (staffService.UpdatePassWord(Id,op,np)==1)
	            {
	            	System.out.println(id + "修改密码：" + op + " " + np+"成功");
	                T.setBoolI(1);
	            }
	            else
	            {
	            	System.out.println("所有用户信息收集正常，用户可以找到，但修改失败");
	                T.setBoolI(2);
	            }
	        }
        }
        return T;
    }
    
    
    /*修改用户信息，
     * 入参:用户主键id、性别sex、电话phonenbr【电话和性别选填】
     * 出参：{"bool":null,"boolI":2}反馈类型，BoolI，1代表用户修改成功，2代表修改失败，3预留，4代表用户不存在.5获取字段失败

    */
    @RequestMapping("/UpdateStaff")
    @ResponseBody
    @CrossOrigin
    public BooleanT UpdateStaff(HttpServletRequest request) {
    	System.out.println("--------------------------------");
        System.out.println("StaffController：UpdateStaff");
        Object id= request.getParameter("id");
        Object phonenbr = request.getParameter("phonenbr");
        Object sex = request.getParameter("sex");

        BooleanT T=new BooleanT();
        Staff staff=null;
        
        if (id == null)
        {
        	System.out.println("ID不能为空");
            T.setBoolI(5);
        }
        else {
        	staff=staffService.findStaffById(Integer.valueOf(id.toString()));
        	
        	if (staff == null)
        	{
        		System.out.println("ID"+id.toString()+"不存在");
        		T.setBoolI(4);
        	}
        	else
        	{
	        	if (sex !=null)
	        		staff.setSex(Integer.valueOf(sex.toString()));
	        	if (phonenbr !=null)
	        		staff.setPhoneNbr(phonenbr.toString());
	        	int reInt=staffService.updateByPrimaryKey(staff);
	        	System.out.println("信息修改成功");
	        	T.setBoolI(reInt);
        	}
        }
        return T;
    }
    
    
    
    
    /*添加用户信息，
     * 入参:用户主键id、性别sex、电话phonenbr【电话和性别选填】等等
     * 出参：null 代表没添加成功，Staff 代表添加成功

    */
    @RequestMapping("/AddStaff")
    @ResponseBody
    @CrossOrigin
    public Staff AddStaff(HttpServletRequest request) {
    	System.out.println("--------------------------------");
        System.out.println("StaffController：AddStaff");
        Object Staff_code= request.getParameter("staff_code");
        Object Pass_word = request.getParameter("pass_word");
        Object Email = request.getParameter("attr_value_1");
        Object Staff_name = request.getParameter("staff_name");
        Object Phone_Nbr = request.getParameter("phone_nbr");
        Object sex = request.getParameter("sex");
        Object channel_id = request.getParameter("channel_id");
        Object lan_id = request.getParameter("lan_id");
        Object age = request.getParameter("age");
        Staff staff=new Staff();
        if (Staff_code == null || Pass_word  == null || Staff_name == null || channel_id == null || sex == null || lan_id == null )
        {
        	System.out.println("必填字段不能为空");
        	return null;
        }
        else {
        	
        	if (Staff_code!=null)
				staff.setStaffCode(Staff_code.toString());
        	if (Pass_word!=null)
				staff.setPassWord(MD5Utils.md5Password(Pass_word.toString()));
        	if (Staff_name!=null)
				staff.setStaffName(Staff_name.toString());
        	
			if (Email!=null)
				staff.setAttrValue1(Email.toString());
			if (Phone_Nbr!=null)
				staff.setPhoneNbr(Phone_Nbr.toString());
			if (sex!=null)
				staff.setSex(Integer.valueOf(sex.toString()));
			if (age!=null)
				staff.setAge(Integer.valueOf(age.toString()));
			if (lan_id!=null)
				staff.setLanId(Integer.valueOf(lan_id.toString()));
			if (channel_id!=null)
				staff.setChannelId(Integer.valueOf(channel_id.toString()));
			
			staff.setStaffType(1);
		}
        System.out.println(staff.toString());
        
        staffService.insertSelective(staff);
        
        return staff;

    }
    
    /*用户搜索功能
     * 入参：staff_code、Staff_name、lan_id、staff_type
     * 出参：根据判断条件搜索出符合的用户
     * 
     * 
     * */
    @RequestMapping("/StaffList")
    @ResponseBody
    @CrossOrigin
    public List<Staff> StaffList(HttpServletRequest request) {
    	System.out.println("--------------------------------");
        System.out.println("StaffController：StaffList");
        Object staff_code = request.getParameter("staff_code");
        Object Staff_name = request.getParameter("Staff_name");
        Object lan_id = request.getParameter("lan_id");
        Object staff_type = request.getParameter("staff_type");
        
        Staff staff=new Staff();
        
        if (staff_type != null)
        	staff.setStaffType(Integer.valueOf(staff_type.toString()));
        if (lan_id != null)
        	staff.setLanId(Integer.valueOf(lan_id.toString()));
        if (staff_code != null)
        	staff.setStaffCode(staff_code.toString());
        if (Staff_name != null)
        {
        	staff.setStaffName("%"+Staff_name.toString()+"%");
        	//System.out.println("%"+Staff_name.toString()+"%");
        }
     
  //      query.setLan_id(Integer.valueOf(lan_id));
       
        return staffService.QueryByStaff(staff);
    }
    
    @RequestMapping("/StaffPage")
    @ResponseBody
    @CrossOrigin
    public PagedData<Staff> StaffPage(HttpServletRequest request) {
    	System.out.println("--------------------------------");
        System.out.println("StaffController：StaffPage");
        Object staff_code = request.getParameter("staff_code");
        Object Staff_name = request.getParameter("Staff_name");
        Object lan_id = request.getParameter("lan_id");
        Object staff_type = request.getParameter("staff_type");
        Object pageNum = request.getParameter("pageNum");
        Object size = request.getParameter("size");
        
        
        StaffQuery staff=new StaffQuery();
        
        if (staff_type != null)
        	staff.setStaffType(Integer.valueOf(staff_type.toString()));
        if (lan_id != null)
        	staff.setLanId(Integer.valueOf(lan_id.toString()));
        if (staff_code != null)
        	staff.setStaffCode(staff_code.toString());
        if (Staff_name != null)
        {
        	staff.setStaffName("%"+Staff_name.toString()+"%");
        	//System.out.println("%"+Staff_name.toString()+"%");
        }
        
        if (pageNum != null)
        	staff.setPageNo(Integer.valueOf(pageNum.toString()));
        if (size != null)
        {
        	staff.setPageSize(Integer.valueOf(size.toString()));
        }
          
        return staffService.query(staff);
    }
    
}
