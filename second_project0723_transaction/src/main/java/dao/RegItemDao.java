package dao;

import java.util.List;

import vo.RegItemVo;

public interface RegItemDao {
    List<RegItemVo> selectList();

	List<RegItemVo> selectOneReg(int reg_idx);
}