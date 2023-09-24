package com.celc.proodonto.domain.records;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "records")
@Entity(name = "Record")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Record {
    @Id
    private Long id;
    private String recordNumber;
    private Long operatorId;
    private Long advisorId;
    private String semester;
    private String careUnit;
    private String initialExam;
}
