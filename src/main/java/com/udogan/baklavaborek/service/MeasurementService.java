package com.udogan.baklavaborek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.udogan.baklavaborek.entity.Measurement;
import com.udogan.baklavaborek.exception.MeasurementNotFoundException;
import com.udogan.baklavaborek.exception.MeasurementAlreadyAddedException;
import com.udogan.baklavaborek.repository.MeasurementRepository;

@Service
public class MeasurementService {
	@Autowired
	private MeasurementRepository measurementRepository;
	
	public List<Measurement> getMeasurements() {
		return this.measurementRepository.findAll();
	}
	
	public Measurement getMeasurement(Long id) throws MeasurementNotFoundException {
		Measurement measurement = this.measurementRepository.findOne(id);
		if(measurement != null) {
			return measurement;
		}
		throw new MeasurementNotFoundException("Measurement not found with id " + id);
	}
	
	public Measurement createMeasurement(Measurement measurement) throws Exception {
		if(checkMeasurementAddedBefore(measurement.getName())) {
			return this.measurementRepository.saveAndFlush(measurement);
		}
		throw new MeasurementAlreadyAddedException("Measurement added before.");
	}
	
	public Measurement updateMeasurement(Measurement measurement) throws Exception {
		Assert.notNull(measurement.getId(), "Measurement id cannot be null!");
		if(checkMeasurementAddedBefore(measurement.getName(),measurement.getId())) {
			return this.measurementRepository.saveAndFlush(measurement);
		}
		throw new MeasurementAlreadyAddedException("Measurement added before.");
	}
	
	public boolean deleteMeasurement(Long id) throws MeasurementNotFoundException {
		Measurement measurement = getMeasurement(id);
		this.measurementRepository.delete(measurement);
		return true;
	}
	
	private boolean checkMeasurementAddedBefore(String name) {
		return checkMeasurementAddedBefore(name,null);
	}

	private boolean checkMeasurementAddedBefore(String name, Long id) {
		Measurement measurement = this.measurementRepository.findByName(name);
		return measurement != null && measurement.getId() != null ? measurement.getId().equals(id) : true;
	}
}