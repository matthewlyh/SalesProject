package cn.dao;
import java.util.List;
import cn.model.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staffId);
    
    Staff selectByStaffCode(String staffCode);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
    
    public List<Staff> QueryByStaff(Staff record);
}