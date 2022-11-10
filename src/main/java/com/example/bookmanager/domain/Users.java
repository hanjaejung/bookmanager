package com.example.bookmanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity//pk값을 설정해주지 않으면 오류가 생긴다
@Table(name = "users", indexes = { @Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Users {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING) //@Enumerated 이 어노테이션은 default 상태가 ORDINAL라서 MALE은 0, FEMALE은 1 이다
    private Gender gender;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Transient //영속성,db 레코드에는 처리하지 않지만 객체에서 따로 쓰기 위해서 쓰인다
    private String testData;
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
