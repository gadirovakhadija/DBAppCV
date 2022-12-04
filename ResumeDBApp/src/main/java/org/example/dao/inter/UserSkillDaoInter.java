package org.example.dao.inter;

import org.example.bean.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    public List<UserSkill> getAllSkillByUserId(int getId);
}
