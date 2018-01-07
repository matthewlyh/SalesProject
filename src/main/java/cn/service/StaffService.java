package cn.service;
import java.util.List;

import cn.model.Staff;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface StaffService {
    //验证账号密码是否正确String staff_code,String pass_word
	Staff findStaffByIdAndPass(String staff_code,String pass_word);
	Staff findStaffById(int id);
	int UpdatePassWord(int id ,String OldPWD,String NewPWD);
	int updateByPrimaryKey(Staff staff);
	public List<Staff> QueryByStaff(Staff record);
}
