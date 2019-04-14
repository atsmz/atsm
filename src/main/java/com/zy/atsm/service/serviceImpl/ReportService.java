package com.zy.atsm.service.serviceImpl;

import com.zy.atsm.dao.ReportDao;
import com.zy.atsm.entity.Report;
import com.zy.atsm.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("IReportService")
public class ReportService implements IReportService{

    @Autowired
    ReportDao reportDao;

    @Override
    public void addProject(Report report) {
        reportDao.insert(report);
    }
}
