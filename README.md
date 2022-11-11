# bookmanager
도서관리프로그램

2022-11-11
BookReviewInfo entity생성 후 insert테스트
ERD대로 BOOK 필드 수정

2022-11-10
첫번째 Listener 테스트
기본리스너 테스트를 진행하였습니다.
@PrePersist insert전에 수행되는 어노테이션
@PreUpdate  update전에 수행되는 어노테이션
Users클래스에 어노테이션을 달아 create와 update날짜를 실시간으로 업데이트하여
테스트를 진행하였습니다 현재는 주석처리 상태입니다.

두번째 Listener 테스트(리스너 클래스를 직접만들어서 진행)
@EntityListeners어노테이션에 MyEntityListener클래스를 직접생성하여 
@PrePersist ,@PreUpdate 이두 어노테이션을 달아서 
create와 update날짜를 실시간으로 업데이트하여 테스트를 진행하였습니다.

세번째 Listener 테스트(JPA에서 주어진 클래스로 진행)
기존에 만들었던 MyEntityListener클래스를 사용하지 않고
JPA에서 제공하는AuditingEntityListener 클래스를 이용하여
create날짜에 @CreatedDate 달아주어 insert시 날짜를 생성
update날짜에 @LastModifiedDate 달아주어 insert시 날짜를 생성
Users클래스에서 @EntityListeners(value = { MyEntityListener.class }) 이 부분을
@EntityListeners(value = { AuditingEntityListener.class }) 이렇게 수정해준 후 진행하였습니다.


네번째 Listener 테스트
Book클래스 생성 후 책에 대한 정보를 담는 엔티티 생성
UserHistory클래스 생성 후 log기록 담는 엔티티 생성
UserEntityListener클래스 생성하여 users정보를 userHistory에 담는 역할을 합니다.
Users클래스에 이와같은 어노테이션을 달아줍니다. => @EntityListeners(value = { UserEntityListener.class })

다섯번째 Listener 테스트
강의에서 협업에서 많이쓰는 리스너테스트를 진행하였습니다.
BaseEntity클래스 생성 후 
@EntityListeners(value = AuditingEntityListener.class)
직접 jpa 리스너를 받은 후 
각각 Users클래스, Book클래스, UserHistory클래스에 상속시켜
일일이 @CreatedDate, @LastModifiedDate어노테이션을 달지 않게 해주었습니다.
참고로  Book클래스, UserHistory클래스에는 createdAt과 updatedAt컬럼을 따로 생성해주지 않았기 때문에
@MappedSuperclass어노테이션을 BaseEntity클래스에 달아주어  Book클래스, UserHistory클래스에 프로젝트
구동시 테이블이 생성될때 createdAt과 updatedAt컬럼을 생성되게 해주었습니다.

2022-11-09
path => test>java>com.example.bookmanager>repository
UserRepositoryTest.java
data.sql에 insert 시킨 데이터를 crud 테스트와 page테스트를 하였습니다.
ExampleMatcher, Example인터페이스 테스트도 진행하였습니다.
SimpleJpaRepository.java에 있는 save메소드가 어떤식으로 코딩되어 있는지 테스트도 진행하였습니다.
=> save시 오픈소스를 보면
   Entity클래스에 설정해두었던 id를 기준으로 존재하지않으면 insert 존재하면 update를 실행
   하게 되어있습니다.
쿼리메소드 테스트를 진행하였습니다.

