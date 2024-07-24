package dao;

import java.util.List;

import vo.RegItemVo;

public interface RegItemDao {
    List<RegItemVo> selectList();
}