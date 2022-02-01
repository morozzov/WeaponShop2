package com.example.weaponshop2.repositories;

import com.example.weaponshop2.models.Gun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GunsRepository extends JpaRepository<Gun, Integer> {
}
