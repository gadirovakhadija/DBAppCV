package org.example.dao.impl;

import org.example.bean.Country;
import org.example.dao.inter.AbstractDao;
import org.example.dao.inter.CountryDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    private Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");

        return new Country(id, name, nationality);
    }

    @Override
    public List<Country> getAllCountryByUserId(int getId) {
        List<Country> result = new ArrayList<>();
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement(
                    "select * from country where user_id =?");
            stmt.setInt(1, getId);

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Country cont = getCountry(rs);
                result.add(cont);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
