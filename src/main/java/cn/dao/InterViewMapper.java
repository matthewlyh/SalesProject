package cn.dao;

import java.util.List;

import cn.view.InterView;

public interface InterViewMapper {
   InterView findViewById(int id);
   List<InterView> queryList();
}
