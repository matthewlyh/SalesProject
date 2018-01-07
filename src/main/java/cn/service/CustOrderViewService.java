package cn.service;

import cn.view.CustOrderView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface CustOrderViewService {
    public List<CustOrderView> queryList(CustOrderView record);
}
