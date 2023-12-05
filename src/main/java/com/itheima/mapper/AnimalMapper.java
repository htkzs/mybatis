package com.itheima.mapper;

import com.itheima.entity.Animal;

public interface AnimalMapper {
    public Animal queryAnimalById(Integer id);

    public void InsertAnimal(Animal animal);

    public Boolean InsertAnimalwithBoolean(Animal animal);
}
