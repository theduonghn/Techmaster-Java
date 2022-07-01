package vn.techmaster.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.techmaster.demo.entity.IdentityCard;

public interface IdentityCardRepository extends JpaRepository<IdentityCard, Integer> {

}
