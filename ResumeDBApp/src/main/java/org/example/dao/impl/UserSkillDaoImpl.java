package org.example.dao.impl;

import org.example.bean.Skill;
import org.example.bean.User;
import org.example.bean.UserSkill;
import org.example.dao.inter.AbstractDao;
import org.example.dao.inter.UserSkillDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {


    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);
    }


    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement(
                    "select u.*, usk.skill_id, s.name as skill_name, usk.power" +
                            "from" +
                            "user_skill usk" +
                            "left join user u on usk.user_id = u.id" +
                            "left join skill s on usk.skill_id = s.id" +
                            "where" +
                            "usk.user_id =6;");
            stmt.setInt(1, userId);

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                UserSkill u = getUserSkill(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
