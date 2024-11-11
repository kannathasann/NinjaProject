package com.example.NinjaProject.repo.hibernatejpadata;

import com.example.NinjaProject.entity.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppDao extends JpaRepository<AppEntity, Integer> {

}
