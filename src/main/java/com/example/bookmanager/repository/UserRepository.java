package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserRepository extends JpaRepository<Users, Long> {
    Set<Users> findByName(String name);

    Users findByEmail(String email);

    Users getByEmail(String email);

    Users readByEmail(String email);

    Users queryByEmail(String email);

    Users searchByEmail(String email);

    Users streamByEmail(String email);

    Users findUsersByEmail(String email);

//    List<Users> findFirst1ByName(String name); //에러 안난다
//
//    List<Users> findTop1ByName(String name); //에러 안난다

    Users findFirst1ByName(String name);

    Users findTop1ByName(String name);

    List<Users> findFirst2ByName(String name);

    List<Users> findTop2ByName(String name);

    List<Users> findByEmailAndName(String email, String name);

    List<Users> findByEmailOrName(String email, String name);

    List<Users> findByCreatedAtAfter(LocalDateTime yesterday);

    List<Users> findByIdAfter(Long id);

    List<Users> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<Users> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<Users> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<Users> findByIdBetween(Long id1, Long id2);

    List<Users> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<Users> findByIdIsNotNull();

//    List<User> findByAddressIsNotEmpty();   // name is not null and name != '' ?? => 이런의미가 아니란 뜻

    List<Users> findByNameIn(List<String> names);

    List<Users> findByNameStartingWith(String name);

    List<Users> findByNameEndingWith(String name);

    List<Users> findByNameContains(String name);

    List<Users> findByNameLike(String name);

    List<Users> findTopByNameOrderByIdDesc(String name);

    List<Users> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<Users> findFirstByName(String name, Sort sort);

    Page<Users> findByName(String name, Pageable pageable);
    //page<T> 안의 제네릭은 받고자 하는 entity를 넣으면 된다

    @Query(value = "select * from users limit 1;", nativeQuery = true)
    Map<String, Object> findRawRecord();
}
