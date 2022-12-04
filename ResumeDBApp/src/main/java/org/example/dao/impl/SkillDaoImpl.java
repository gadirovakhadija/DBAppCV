package org.example.dao.impl;

import org.example.bean.Skill;
import org.example.dao.inter.SkillDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.example.dao.inter.AbstractDao.connect;

public class SkillDaoImpl implements SkillDaoInter {

    private Skill getSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");

        return new Skill(id, name);
    }


    @Override
    public List<Skill> getAllSkillByUserId(int getId) {
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement(
                    "select * from employment_history where user_id =?");
            stmt.setInt(1, getId);

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Skill emp = getSkill(rs);
                result.add(emp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
