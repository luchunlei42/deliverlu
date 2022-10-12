package org.deliverlu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.deliverlu.dto.DishDto;
import org.deliverlu.entity.Category;
import org.deliverlu.entity.Dish;
import org.deliverlu.entity.DishFlavor;
import org.deliverlu.service.CategoryService;
import org.deliverlu.service.DishService;
import org.deliverlu.mapper.DishMapper;
import org.deliverlu.service.DishFlavorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DishServiceImpl extends ServiceImpl<DishMapper,Dish> implements DishService {
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private CategoryService categoryService;

    @Transactional
    public  void saveWithFlavor(DishDto dishDto){
        this.save(dishDto);
        Long dishId = dishDto.getId();
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map(item->{
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);
    }

    @Override
    public void page(Page<DishDto> pageInfo, String name) {
        Page<Dish> dishPage = new Page<>(pageInfo.getPages(),pageInfo.getSize());
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(name!=null,Dish::getName,name);
        queryWrapper.orderByDesc(Dish::getUpdateTime);
        this.page(dishPage, queryWrapper);
        BeanUtils.copyProperties(dishPage, pageInfo, "records");
        List<Dish> records = dishPage.getRecords();
        List<DishDto> list = records.stream().map(item->{
          DishDto dishDto = new DishDto();
          BeanUtils.copyProperties(item,dishDto);
          Long categoryId = item.getCategoryId();
          Category category = categoryService.getById(categoryId);
          if(category != null){
              String categoryName = category.getName();
              dishDto.setCategoryName(categoryName);
          }

          return dishDto;
        }).collect(Collectors.toList());
        pageInfo.setRecords(list);
    }

    @Override
    public DishDto getByIdWithFlavor(Long id) {
        Dish dish = this.getById(id);

        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(DishFlavor::getDishId, id);
        List<DishFlavor> flavors = dishFlavorService.list(queryWrapper);
        dishDto.setFlavors(flavors);
        return dishDto;
    }
    @Transactional
    public void updateWithFlavor(DishDto dishDto){
         this.updateById(dishDto);
         LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper();
         queryWrapper.eq(DishFlavor::getDishId, dishDto.getId());
         dishFlavorService.remove(queryWrapper);
         List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map(item->{
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());
        dishFlavorService.saveBatch(flavors);
    }
}
