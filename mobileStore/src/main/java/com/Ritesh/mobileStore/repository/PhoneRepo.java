package com.Ritesh.mobileStore.repository;

import com.Ritesh.mobileStore.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PhoneRepo extends JpaRepository<Phone,Integer> {

    List<Phone> findBybrandName(String brand);

    @Query("SELECT p FROM Phone as p WHERE brandName=:brandName AND phoneName=:phoneName")
    Phone findBybrandNameAndphoneName(@Param("brandName") String brand, @Param("phoneName") String phone);

    @Query("SELECT p from Phone as p where brandName LIKE %:detail% OR phoneName LIKE %:detail% OR processor LIKE %:detail% OR displayType LIKE %:detail% ")
    Optional<List<Phone>> findByDetail(String detail);
}
