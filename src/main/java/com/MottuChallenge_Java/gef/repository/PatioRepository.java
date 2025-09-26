package com.MottuChallenge_Java.gef.repository;




import com.MottuChallenge_Java.gef.model.Patio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatioRepository extends JpaRepository<Patio, Long> {
}
