package com.fileuploader.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fileuploader.entity.DocumentEntity;

@Repository
public interface FileManagerDAO extends JpaRepository<DocumentEntity, Long> {

}
