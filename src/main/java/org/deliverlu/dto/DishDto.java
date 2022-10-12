package org.deliverlu.dto;

import lombok.Data;
import org.deliverlu.entity.Dish;
import org.deliverlu.entity.DishFlavor;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
