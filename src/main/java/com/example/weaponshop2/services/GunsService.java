package com.example.weaponshop2.services;

import com.example.weaponshop2.dtos.GunDto;
import com.example.weaponshop2.models.Gun;
import com.example.weaponshop2.repositories.GunsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class GunsService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final GunsRepository gunsRepository;

    public GunsService(ModelMapper modelMapper, GunsRepository gunsRepository) {
        this.modelMapper = modelMapper;
        this.gunsRepository = gunsRepository;
    }

    public ArrayList<Gun> getAll(){
        return (ArrayList<Gun>) gunsRepository.findAll();
    }

    public ArrayList<GunDto> getAllForMobile(){
        return (ArrayList<GunDto>) gunsRepository.findAll().stream().map(gun -> modelMapper.map(gun, GunDto.class)).collect(Collectors.toList());
    }

    public Gun getById(int id) {
        return gunsRepository.findById(id).get();
    }

    public Gun insertOne(Gun gun) {
        return gunsRepository.saveAndFlush(gun);
    }

    public void deleteById(int id) {
        gunsRepository.deleteById(id);
    }

    public Gun updateById(int id, Gun gun){
        gun.id = id;
        return gunsRepository.save(gun);
    }
}
