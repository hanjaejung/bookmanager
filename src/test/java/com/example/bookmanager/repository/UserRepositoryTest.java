package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional //세션유지시켜주는 어노테이션?
    void crudGetOneTest(){
        Users users = userRepository.getOne(1L);

        System.out.println(users);
    }


    @Test
    void crud(){
        //*save* 새로만든 객체 jpa save
        // userRepository.save(new Users());
//
//        userRepository.findAll().forEach(System.out::println);

// *findAll* jpa findall로 찾기 sort.by로 sort.direction으로 정렬되어 users객체의 List에 값을 집어넣어 출력하기
//        List<Users> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
//
//        users.forEach(System.out::println);

//*findAllById* Long의 List에 담아 add메소드로 값을 담아 findAllById메소드에 담아 users객체의 List에 값을 집어넣기
//        List<Long> ids = new ArrayList<>();
//        ids.add(1L);
//        ids.add(3L);
//        ids.add(5L);
//        List<Users> users = userRepository.findAllById(ids);
//
//        users.forEach(System.out::println);

// *findAllById* Lists.newArrayList에 담아 users객체의 List에 값을 집어넣기
//        List<Users> users = userRepository.findAllById(Lists.newArrayList(1l,3l,5l));
//        users.forEach(System.out::println);

// *saveAll* test
//        Users users1 = new Users("jack","jak@fastcampus.com");
//        Users users2 = new Users("steve", "steve@fastcampus.com");
//
//        userRepository.saveAll(Lists.newArrayList(users1, users2));
//
//        List<Users> users = userRepository.findAll();
//
//        users.forEach(System.out::println);

// *findById* test
//        Optional<Users> users1 = userRepository.findById(1L);
//        Users users2 = userRepository.findById(1L).orElse(null);
//        orElse 메소드는 찾는 값이 없을 시  null을 반환하겠다는 뜻이다

//        System.out.println(users2);

//save메소드 다음에 flush메소드
//아니면 saveAndFlush 메소드는 동작만 보면 차이가 없다
//나중에 영속성강의를 할때 알 수 있다고 했다?

// *delete, deleteById* test
//        userRepository.delete(userRepository.findById(1l).orElseThrow(RuntimeException::new));

//        userRepository.deleteById(1l);

//        userRepository.findAll().forEach(System.out::println);

// *deleteAll, deleteInBatch, deleteAllInBatch* test
//deleteAll과 deleteInBatch, deleteAllInBatch의 차이는 deleteAll은 삭제전 조건을 2개이상 걸어서 지우거나 전체를 지울시 select
//를 데이터 하나씩 다 하지만 deleteInBatch는 한번에 where in절로 select하여 지운다, deleteAllInBatch는 조회자체를 하지 않고 지운다
//        userRepository.deleteAll();

//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1l,3l)));

//        userRepository.deleteAllInBatch();

//        userRepository.findAll().forEach(System.out::println);

// *paging* test
        //PageRequest.of메소드를 살펴보면 page부분 설명이 zero-based page index 라고 나옵니다
        //숫자가 1부터 시작이 아니라 0부터 시작이라는 뜻입니다
        //그래서 1로 설정하면 2번째 페이지입니다.
        //그래서 data.sql에 5개의 데이터가 설정이 되어 있어서
        //2번째 페이지는 4,5 이 2개의 페이지가 users페이지에 있습니다.
//        Page<Users> users = userRepository.findAll(PageRequest.of(1, 3));
//
//        System.out.println("page : " + users);
//        System.out.println("totalElements : " + users.getTotalElements());
//        System.out.println("totalPages : " + users.getTotalPages());
//        System.out.println("numberOfElements : " + users.getNumberOfElements());
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

//*ExampleMatcher, Example*인터페이스 test
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")  //withIgnorePaths 제외한다는뜻
//                .withMatcher("email", endsWith()); //withMatcher like로 조회한다는 뜻
//                //endsWith()는 끝에 오는걸 검색한다는 뜻뜻
//                //contains()를 쓰면 양방향 검색이 된다
//       Example<Users> example = Example.of(new Users("ma","fastcampus.com"),matcher);
//        //matcher없이 조회하면 where조건절에 그대로 검색이 된다
//        userRepository.findAll(example).forEach(System.out::println);

        userRepository.save(new Users("david", "david@fastcampus.com"));

        Users users = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        users.setEmail("martin-updated@fastcampus.com");

        userRepository.save(users);
        //save시 오픈소스를 보면
        //Entity클래스에 설정해두었던 id를 기준으로 존재하지않으면 insert 존재하면 update를 실행
        //하게 되어있습니다.
    }

    @Test
    void select() {
//        System.out.println(userRepository.findByName("dennis"));

//        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("findUsersByEmail : " + userRepository.findUsersByEmail("martin@fastcampus.com"));
//
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("dennis"));
//
//        System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));
//        System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("dennis"));
//
//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com","martin"));
//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com","martin"));
//
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4l));
//
//        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//
//        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
//
//        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
////        System.out.println("findByIdIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());
//
//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));

//        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
//        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
//        System.out.println("findByNameContains : " + userRepository.findByNameContains("art"));

        System.out.println("findByNameLike : " + userRepository.findByNameLike("%" + "art" + "%"));
    }
}