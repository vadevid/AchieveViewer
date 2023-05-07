package com.example.achiveserver.service;

import com.example.achiveserver.entity.Achiv;
import com.example.achiveserver.entity.Checked;
import com.example.achiveserver.model.AchivModel;
import com.example.achiveserver.repository.AchivRepository;
import com.example.achiveserver.repository.CheckedRepository;
import com.example.achiveserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AchivService {
    @Autowired
    AchivRepository achivRepository;
    @Autowired
    CheckedRepository checkedRepository;
    @Autowired
    private UserRepository userRepository;

    public List<AchivModel> getAll(Integer id) {
        List<Achiv> achivs = achivRepository.findAll();
        List<AchivModel> achivModels = new ArrayList<>();
        for (var achiv: achivs) {
            if (checkedRepository.getCheckedByAchiv_IdAndUserId(achiv.getId(), id) != null) {
                achivModels.add(new AchivModel(achiv.getId(), achiv.getName(), achiv.getClassField(), achiv.getDescription(), true));
            } else achivModels.add(new AchivModel(achiv.getId(), achiv.getName(), achiv.getClassField(), achiv.getDescription(), false));
        }
        return achivModels;
    }

    public boolean checkAchiv(Integer userId, Integer achivId) {
        checkedRepository.save(new Checked(userRepository.getUserById(userId), achivRepository.getAchivById(achivId)));
        return true;
    }

    public boolean uncheckAchiv(Integer userId, Integer achivId) {
        Checked checked = checkedRepository.getCheckedByAchiv_IdAndUserId(achivId, userId);
        checkedRepository.delete(checked);
        return true;
    }
}
