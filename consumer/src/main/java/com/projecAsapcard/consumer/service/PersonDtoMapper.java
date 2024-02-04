package com.projecAsapcard.consumer.service;

import com.projecAsapcard.consumer.model.DataDTO;
import com.projecAsapcard.consumer.model.Person;

public class PersonDtoMapper {

    public static Person map(DataDTO dataDTO) {
        Person person = new Person();
        person.setId(dataDTO.getIdPerson());
        person.setName(dataDTO.getNome());
        person.setAge(dataDTO.getIdade().intValue()); // Converte Short para Integer
        return person;
    }
}
