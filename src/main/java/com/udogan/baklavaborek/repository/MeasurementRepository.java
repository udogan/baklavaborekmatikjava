package com.udogan.baklavaborek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udogan.baklavaborek.entity.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long>{
	List<Measurement> findAll();
	Measurement findOne(Long id);
	<S extends Measurement>S saveAndFlush(S measurement);
	void delete(Measurement measurement);
	Measurement findByName(String name);
}