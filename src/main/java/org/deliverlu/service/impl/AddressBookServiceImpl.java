package org.deliverlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.deliverlu.entity.AddressBook;
import org.deliverlu.mapper.AddressBookMapper;
import org.deliverlu.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
