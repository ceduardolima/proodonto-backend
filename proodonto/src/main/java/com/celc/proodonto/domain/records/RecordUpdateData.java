package com.celc.proodonto.domain.records;

import java.util.UUID;

public record RecordUpdateData(
        UUID id,
        String recordNumber,
        Long advisorId,
        Long operatorId,
        String careUnit,
        String initialExam,
        Integer semester
) {

}
