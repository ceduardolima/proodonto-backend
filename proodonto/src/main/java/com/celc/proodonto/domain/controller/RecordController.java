package com.celc.proodonto.domain.controller;

import com.celc.proodonto.domain.records.Record;
import com.celc.proodonto.domain.records.RecordDetailData;
import com.celc.proodonto.domain.records.RecordRegisterData;
import com.celc.proodonto.domain.records.RecordRepository;
import com.celc.proodonto.domain.user.UserDetailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("records")
public class RecordController {

    @Autowired
    private RecordRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody RecordRegisterData recordRegisterData, UriComponentsBuilder uriComponentsBuilder) {
        var record = new Record(recordRegisterData);
        repository.save(record);
        var uri = uriComponentsBuilder.path("/records/{id}").buildAndExpand(record.getId()).toUri();
        return ResponseEntity.created(uri).body(new RecordDetailData(record));
    }
}
