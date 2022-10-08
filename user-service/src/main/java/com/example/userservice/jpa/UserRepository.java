package com.example.userservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;


// 어느 버전부터인지 모르겠지만 엔티티클래스와 extends에 jpa레포에 클래스명과 제네릭 맞춰줘야 에러가 없어짐
public interface UserRepository extends JpaRepository<User, Long> {

}
