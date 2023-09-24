package com.celc.proodonto.domain.records;

public record RecordRegisterData(
        String recordNumber,
        Long patientId,
        Long advisorId,
        Long operatorId,
        int semester,
        String careUnit,
        String initialExam
) {
}
