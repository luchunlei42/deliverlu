package org.deliverlu.dto;

import lombok.Data;
import org.deliverlu.entity.Setmeal;
import org.deliverlu.entity.SetmealDish;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {
    private List<SetmealDish> setmealDishes;
    private String categoryName;

}
