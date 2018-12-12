package com.pictools.repository;

import com.pictools.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status, Long> {
}