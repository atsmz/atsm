package com.zy.atsm.service.serviceImpl;

import com.zy.atsm.dao.StudentInfoDao;
import com.zy.atsm.entity.StudentInfo;
import com.zy.atsm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("IStudentService")
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentInfoDao studentInfoDao;

    @Override
    public List showStudentInfo(int id) {
        
        List list = studentInfoDao.selectById(id);

        return list;
    }
}
