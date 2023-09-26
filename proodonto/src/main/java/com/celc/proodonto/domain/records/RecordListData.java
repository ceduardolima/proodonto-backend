package com.celc.proodonto.domain.records;

import java.util.UUID;

public record RecordListData(
        UUID id,
        String recordNumber,
        Long patientId,
        Long advisorId,
        Long operatorId,
        String careUnit,
        String initialExam,
        int semester
) {
    public RecordListData(Record recordData) {
        this(
                recordData.getId(),
                recordData.getRecordNumber(),
                recordData.getPatientId(),
                recordData.getAdvisorId(),
                recordData.getOperatorId(),
                recordData.getCareUnit(),
                recordData.getInitialExam(),
                recordData.getSemester()
        );
    }
}
