package com.example.Rating_app_Service.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Rating_app_Service.model.Evaluation;


public interface CommentsRepository extends JpaRepository<Evaluation, Long>{

}
