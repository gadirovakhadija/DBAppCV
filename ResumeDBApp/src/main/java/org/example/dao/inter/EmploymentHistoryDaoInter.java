package org.example.dao.inter;

import org.example.bean.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistporyByUserId(int getId);
}
