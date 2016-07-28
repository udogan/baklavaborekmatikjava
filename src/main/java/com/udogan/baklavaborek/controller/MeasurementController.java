package com.udogan.baklavaborek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udogan.baklavaborek.entity.Measurement;
import com.udogan.baklavaborek.exception.MeasurementNotFoundException;
import com.udogan.baklavaborek.service.MeasurementService;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
	
	@Autowired
	private MeasurementService measurementService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Measurement> getAllMeasurements(){
		return this.measurementService.getMeasurements();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Measurement getMeasurement(@PathVariable("id") Long id) throws MeasurementNotFoundException {
		return this.measurementService.getMeasurement(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Measurement addMeasurement(@RequestBody Measurement measurement) throws Exception {
		return this.measurementService.createMeasurement(measurement);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Measurement editMeasurement(@RequestBody Measurement measurement) throws Exception {
		return this.measurementService.updateMeasurement(measurement);
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public boolean deleteMeasurement(@PathVariable("id") Long id) throws MeasurementNotFoundException {
		return this.measurementService.deleteMeasurement(id);
	}
}