package com.common.utils;

import com.common.MandatoryField;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @MandatoryField
    private ZonedDateTime createdAt;
    @MandatoryField
    private ZonedDateTime updatedAt;
}
