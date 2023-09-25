package com.celc.proodonto.domain.records;

import java.util.UUID;

public record RecordDetailData(
        UUID id,
        String recordNumber,
        Long patientId,
        Long advisorId,
        Long operatorId,
        String careUnit,
        String initialExam,
        int semester
) {
    public RecordDetailData(Record record) {
        this(
                record.getId(),
                record.getRecordNumber(),
                record.getPatientId(),
                record.getAdvisorId(),
                record.getOperatorId(),
                record.getCareUnit(),
                record.getInitialExam(),
                record.getSemester()
        );

    }
}
