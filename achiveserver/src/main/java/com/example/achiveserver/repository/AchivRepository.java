package com.example.achiveserver.repository;

import com.example.achiveserver.entity.Achiv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchivRepository extends JpaRepository<Achiv, Integer> {
}
