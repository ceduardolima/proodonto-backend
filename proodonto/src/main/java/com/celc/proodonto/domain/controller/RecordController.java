package com.celc.proodonto.domain.controller;

import com.celc.proodonto.domain.records.*;
import com.celc.proodonto.domain.records.Record;
import com.celc.proodonto.domain.user.UserDetailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<Page<RecordListData>> list(@PageableDefault(sort = {"recordNumber"}) Pageable page) {
        var resultPage = repository.findAll(page);
        return ResponseEntity.ok(resultPage.map(RecordListData::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordDetailData> detail(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        Record recordData = repository.getReferenceById(uuid);
        return ResponseEntity.ok(new RecordDetailData(recordData));
    }
}
