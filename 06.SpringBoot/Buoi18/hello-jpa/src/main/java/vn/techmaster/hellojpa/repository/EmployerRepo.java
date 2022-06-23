package vn.techmaster.hellojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.hellojpa.model.Employer;

@Repository
public interface EmployerRepo extends JpaRepository<Employer, Long> {

}
