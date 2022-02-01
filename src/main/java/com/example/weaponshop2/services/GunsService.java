package com.example.weaponshop2.services;

import com.example.weaponshop2.models.Gun;
import com.example.weaponshop2.repositories.GunsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GunsService {

    @Autowired
    private final GunsRepository gunsRepository;

    public GunsService(GunsRepository gunsRepository){
        this.gunsRepository = gunsRepository;
    }

    public ArrayList<Gun> getAll(){
        return (ArrayList<Gun>) gunsRepository.findAll();
    }
}
