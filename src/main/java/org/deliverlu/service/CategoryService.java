package org.deliverlu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.deliverlu.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
