package com.webperside.courseerpbackend.services.base;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

//@FieldDefaults(level = AccessLevel.PRIVATE)
public interface TokenGenerator<T>{

    // Token Generasiyasi zaman istifade olun obyekt-i otururem
    String generate(T obj);
}
