package br.com.unisoma.api.repository;

import br.com.unisoma.api.model.Employee;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Employee feedEntry set feedEntry.salary =:salary where feedEntry.cpf =:cpf")
    void updateSalary(@Param("cpf") String cpf, @Param("salary") Float isRead);
}
