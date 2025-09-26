package com.MottuChallenge_Java.gef.repository;




import com.MottuChallenge_Java.gef.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
}
