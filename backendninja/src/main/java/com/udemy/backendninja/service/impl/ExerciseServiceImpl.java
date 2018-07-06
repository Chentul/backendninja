package com.udemy.backendninja.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.service.ExerciseService;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {
	
	private static final Log LOG = LogFactory.getLog(ExerciseServiceImpl.class);

	@Override
	public void getMessage() {
		LOG.info("HELLO FROM EXERCISESERVICE");
	}
	
}
