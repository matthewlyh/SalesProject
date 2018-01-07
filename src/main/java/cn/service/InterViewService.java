package cn.service;


import java.util.List;

import cn.view.InterView;
/**
 * Created by Administrator on 2017/10/27.
 */
public interface InterViewService {
    InterView findInterViewById(int id);
    public List<InterView> query();
}
