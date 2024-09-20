package com.webperside.courseerpbackend.models.mybatis.base;


import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IsDeletedEntity {

    boolean isDeleted;
}
