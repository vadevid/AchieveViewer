package com.example.achiveserver.controller;

import com.example.achiveserver.entity.Achiv;
import com.example.achiveserver.model.AchivModel;
import com.example.achiveserver.model.CheckModel;
import com.example.achiveserver.model.UserLoginModel;
import com.example.achiveserver.model.UserModel;
import com.example.achiveserver.service.AchivService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achiv")
@CrossOrigin(origins = "http://localhost:4200")
public class AchivController {
    @Autowired
    AchivService achivService;

    @PostMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AchivModel> getAll(@RequestBody @Validated UserModel user) {
        return achivService.getAll(user.getId());
    }

    @PostMapping(path = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean checkAchive(@RequestBody @Validated CheckModel checkModel) {return achivService.checkAchiv(checkModel.getUserId(), checkModel.getAchivId());}

    @PostMapping(path = "/uncheck", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean uncheckAchiv(@RequestBody @Validated CheckModel checkModel) {return achivService.uncheckAchiv(checkModel.getUserId(), checkModel.getAchivId());}
}
