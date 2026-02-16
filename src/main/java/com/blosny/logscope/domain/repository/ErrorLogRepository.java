package com.blosny.logscope.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blosny.logscope.domain.model.ErrorLog;

@Repository // Spring'e "Veritabanı işlerini bu arkadaş yapacak" diyoruz.
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
    // JPA kendisi yazacak buraları
}