package com.example.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true) //상속받은 클래스에 상위클래스의 필드가 toString으로 포함될 수 있게 하는 어노테이션
@EqualsAndHashCode(callSuper = true) //상속받은 클래스에 상위클래스의 eqauls와 hashCode 메소드
//자동 생성 할 수 있게 하는 어노테이션
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long bookId;

    @OneToOne(optional = false)//1대1연관관계라는뜻
    private Book book;

    private float averageReviewScore;
    //대문자 Float Wrapper타입은 nullpointException에러에 걸릴 수 있다
    //primitive type은 not null로 테이블에 적용됨
    private int reviewCount;
    //대문자 Integer Wrapper타입은 nullpointException에러에 걸릴 수 있다
    //primitive type은 not null로 테이블에 적용됨
}
