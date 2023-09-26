package com.celc.proodonto.domain.records;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.id.uuid.UuidGenerator;

import java.util.UUID;

@Table(name = "records")
@Entity(name = "Record")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String recordNumber;
    private Long operatorId;
    private Long advisorId;
    private Long patientId;
    private int semester;
    private String careUnit;
    private String initialExam;
    private boolean active;

    public Record(RecordRegisterData recordRegisterData) {
        recordNumber = recordRegisterData.recordNumber();
        operatorId = recordRegisterData.operatorId();
        advisorId = recordRegisterData.advisorId();
        patientId = recordRegisterData.patientId();
        semester = recordRegisterData.semester();
        careUnit = recordRegisterData.careUnit();
        initialExam = recordRegisterData.initialExam();
        active = true;
    }

    public void delete() {
        active = false;
    }
}
