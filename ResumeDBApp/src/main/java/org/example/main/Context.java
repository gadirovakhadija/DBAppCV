package org.example.main;

import org.example.dao.impl.*;
import org.example.dao.inter.*;

public class Context {
    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceUserSkillDaoInter() {
        return new UserSkillDaoImpl();
    }

    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDaoInter() {
        return new EmploymentHistoryDaoImpl();
    }

    public static SkillDaoInter instanecSkillDaoInter() {
        return new SkillDaoImpl();
    }

    public static CountryDaoInter instanceCountryDaoInter() {
        return new CountryDaoImpl();
    }
}
