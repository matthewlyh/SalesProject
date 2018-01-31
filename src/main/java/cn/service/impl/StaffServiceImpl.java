package cn.service.impl;

import java.util.List;

import cn.dao.StaffMapper;
import cn.model.Staff;
import cn.query.PagedData;
import cn.query.StaffQuery;
import cn.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/25.
 */
@Component
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffMapper staffmapper;

	public Staff findStaffByIdAndPass(String staff_code, String pass_word) {
		System.out.println("进入Service :findStaffByIdAndPass");

		// String staff_code,String pass_word
		Staff staffModel = staffmapper.selectByStaffCode(staff_code);
		if (staffModel != null) {
			System.out.println("比对密码，原密码：" + staffModel.getPassWord());
			System.out.println("现密码：" + pass_word);
			if (!staffModel.getPassWord().equals(pass_word)) {
				staffModel = null;
				System.out.println("密码不匹配");
			} else
				System.out.println("密码匹配成功");
		} else {
			System.out.println("用户不存在");
		}

		return staffModel;
	}

	public Staff findStaffById(int id) {
		Staff Staff = staffmapper.selectByPrimaryKey(id);
		// System.out.println("StaffService。findStaffById:" +
		// Staff.getStaffName());
		return Staff;
	}

	public int UpdatePassWord(int ID, String OldPWD, String NewPWD) {
		int T = -1;
		Staff record = staffmapper.selectByPrimaryKey(ID);
		if ((record.getPassWord()).equals(OldPWD)) {
			record.setPassWord(NewPWD);
			T = staffmapper.updateByPrimaryKey(record);
		}

		return T;
	}

	public int updateByPrimaryKey(Staff staff) {
		// TODO 自动生成的方法存根
		return staffmapper.updateByPrimaryKey(staff);
	}

	public List<Staff> QueryByStaff(Staff record) {
		// TODO 自动生成的方法存根
		return staffmapper.QueryByStaff(record);
	}

	public PagedData<Staff> query(StaffQuery query) {

		if (query == null) {
			throw new IllegalArgumentException();
		}

		try {
			PagedData<Staff> pagedData = new PagedData<Staff>();
			pagedData.setPageNo(query.getPageNo());
			pagedData.setPageSize(query.getPageSize());

			List<Staff> taskConfigDOs = staffmapper.PageByStaffQuery(query);

			pagedData.setList(taskConfigDOs);

			if (taskConfigDOs != null && !taskConfigDOs.isEmpty()
					&& query.getNeedPagedInfo()) {
				pagedData.setTotalNum(staffmapper.CountByStaffQuery(query));
				//添加入参，可以设置页数
				//Map<String, String> args = new HashMap<String, String>();
				//args.put("size","1");
				//pagedData.setArgs(args);
				//pagedData.setArgs();
			}
			return pagedData;
		} catch (Exception e) {
			// throw new SeiyaException(location, e);

			return null;
		}

	}

	@Override
	public int insertSelective(Staff record) {
		// TODO 自动生成的方法存根
		return staffmapper.insertSelective(record);
	}

}
