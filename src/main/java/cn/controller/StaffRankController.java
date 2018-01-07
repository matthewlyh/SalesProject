package cn.controller;

import java.util.List;

import cn.model.Staff;
import cn.view.StaffRank;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/26.
 */
@Controller
public class StaffRankController extends BaseController {

	
	/*根据用户主键ID，查找到他所在部门的所有员工的视图staffrank中的全部信息，并且以金额排序
	 * 入参：ID[用户Staff主键]
	 * 出参：staffrank视图中的所有信息
	 * 
	 * */
	@RequestMapping("/FindStaffRank")
	@ResponseBody
	@CrossOrigin
	public List<StaffRank> FindStaffRank(HttpServletRequest request) {
		System.out.println("StaffRankController:FindStaffRank");
		Object Sid = request.getParameter("id");
		if (Sid != null) {
			System.out.println("Sid:" + Sid.toString());
			StaffRank staffRank = new StaffRank();
			Staff staff = staffService.findStaffById(Integer.valueOf(Sid.toString()));
			if (staff != null) {
				staffRank.setChannel_id(staff.getChannelId());
				List<StaffRank> list = staffRankService.queryList(staffRank);
				StaffRank temp=new StaffRank();
				for (int i = 0; i < list.size(); i++) 
					for (int j = i + 1; j < list.size(); j++)
						if (list.get(i).getGold()<list.get(j).getGold()) 
						{
							temp=list.get(i);
							list.set(i, list.get(j));
							list.set(j, temp);
						}
				return list;
			}
			else
			{
				System.out.println("此ID"+Sid+"用户不存在");
				return null;
			}

		} else
		{
			System.out.println("ID不能为空");
			return null;
		}
	}

}
