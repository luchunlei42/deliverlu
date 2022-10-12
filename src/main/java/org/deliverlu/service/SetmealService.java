package org.deliverlu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.deliverlu.dto.SetmealDto;
import org.deliverlu.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

    public void removeWithDish(List<Long> ids);
}
