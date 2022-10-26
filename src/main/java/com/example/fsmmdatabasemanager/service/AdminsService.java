package com.example.fsmmdatabasemanager.service;

import com.example.fsmmdatabasemanager.entity.Admins;
import com.example.fsmmdatabasemanager.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AdminsService {
    @Autowired
    AdminsRepository adminsRepository;

    public Admins logInByAccount(String account){
        return adminsRepository.selectById(account);
    }
}
