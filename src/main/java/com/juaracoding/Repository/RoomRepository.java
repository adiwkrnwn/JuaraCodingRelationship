package com.juaracoding.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.model.RoomModel;

public interface RoomRepository extends JpaRepository<RoomModel, String>{

}
