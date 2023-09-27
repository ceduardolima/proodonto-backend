package com.celc.proodonto.domain.controller.parameters;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DeleteRecordParams {
    private String id = "";
    private String recordNumber = "";

    public UUID getId() {
        if (id.isBlank())
            return null;
        return UUID.fromString(id);
    }
}
