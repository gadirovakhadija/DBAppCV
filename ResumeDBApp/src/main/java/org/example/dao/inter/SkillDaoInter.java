package org.example.dao.inter;

import org.example.bean.Skill;

import java.util.List;

public interface SkillDaoInter {
    public List<Skill> getAllSkillByUserId(int getId);
}
