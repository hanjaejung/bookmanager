# bookmanager
도서관리프로그램

2022-11-09 path => test>java>com.example.bookmanager>repository
UserRepositoryTest.java
data.sql에 insert 시킨 데이터를 crud 테스트와 page테스트를 하였습니다.
ExampleMatcher, Example인터페이스 테스트도 진행하였습니다.
SimpleJpaRepository.java에 있는 save메소드가 어떤식으로 코딩되어 있는지 테스트도 진행하였습니다.
=> save시 오픈소스를 보면
   Entity클래스에 설정해두었던 id를 기준으로 존재하지않으면 insert 존재하면 update를 실행
   하게 되어있습니다.
쿼리메소드 테스트를 진행하였습니다.

