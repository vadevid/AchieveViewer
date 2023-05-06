package com.example.achiveserver.repository;

import com.example.achiveserver.entity.Checked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckedRepository extends JpaRepository<Checked, Integer> {
    Checked getCheckedByAchiv_IdAndUserId(Integer achivId, Integer userId);
}
