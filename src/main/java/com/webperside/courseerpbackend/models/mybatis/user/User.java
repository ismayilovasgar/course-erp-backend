package com.webperside.courseerpbackend.models.mybatis.user;

import com.webperside.courseerpbackend.models.enums.user.UserStatus;
import com.webperside.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User  extends BaseEntity {

    String name;
    String  surname;
    UserStatus status;
    Long roleId;
    String email;
    String phoneNumber;
    String password
            ;


}
