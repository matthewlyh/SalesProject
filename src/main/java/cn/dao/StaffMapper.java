package cn.dao;
import java.util.List;

import cn.model.Staff;
import cn.query.StaffQuery;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staffId);
    
    Staff selectByStaffCode(String staffCode);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
    
    public List<Staff> QueryByStaff(Staff record);
    
    //尝试采用分页算法获取Staff列表
    int CountByStaffQuery(StaffQuery staffQuery);
    
    List<Staff> PageByStaffQuery(StaffQuery staffQuery);
}