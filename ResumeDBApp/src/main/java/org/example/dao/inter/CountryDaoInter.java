package org.example.dao.inter;

import org.example.bean.Country;

import java.util.List;

public interface CountryDaoInter {
    public List<Country> getAllCountryByUserId(int getId);
}
