package com.example.NinjaProject.repo.hibernatejpadata;

import com.example.NinjaProject.dto.FeatureDto;
import com.example.NinjaProject.entity.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FeatureDao extends JpaRepository<FeatureEntity, Integer> {

    @Query(value = "SELECT c.configname FROM Config c JOIN feature f ON c.featureid = f.id WHERE f.id=?1", nativeQuery = true)
    public List<String> listConfigBYFeature(int id);

    @Modifying
    @Transactional
    @Query(value = "update feature set active=?2 where name=?1", nativeQuery = true)
    public int updateFeature(String name, boolean active);

    @Modifying
    @Transactional
    @Query(value = "delete from feature where name=?1", nativeQuery = true)
    public int deleteFeature(String name);

}
