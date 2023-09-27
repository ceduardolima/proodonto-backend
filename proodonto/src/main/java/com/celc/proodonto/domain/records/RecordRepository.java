package com.celc.proodonto.domain.records;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecordRepository extends JpaRepository<Record, UUID> {
    Page<Record> findAllByActiveTrue(Pageable pageable);
    Record findRecordByRecordNumber(String recordNumber);

    Page<Record> findAllByActiveFalse(Pageable page);
}
