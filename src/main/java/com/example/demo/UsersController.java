package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class UsersController {

    @RequestMapping ("/users")
    @ResponseBody

    public Object getUsers(
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize
    ) {

        //TODO zapytanie do bazy i pobranie rekordów dla page size i pagenumber

        List<UserEntity> users = new ArrayList<>();

        users.add(new UserEntity(1L, "John"));
        users.add(new UserEntity(2L, "Matt"));
        users.add(new UserEntity(3L, "Chris"));

        return users;
    }

    //http://localhost:8080/users/100
    @RequestMapping("/users/{id}")
    @ResponseBody
    public Object getUsers(
            @PathVariable Long id
    ) {
        return new UserEntity(id, "John-" + id);
    }
}