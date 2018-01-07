package cn.dao;
import java.util.List;
import cn.view.CustOrderView;

public interface CustOrderViewMapper {
	List<CustOrderView> QueryByCustOrderView(CustOrderView record);
}
