package org.deliverlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.deliverlu.entity.Employee;
import org.deliverlu.service.EmployeeService;
import org.deliverlu.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
