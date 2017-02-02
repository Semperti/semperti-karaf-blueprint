package com.semperti.karaf.blueprint;

import java.util.Map;
import java.util.Dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.aries.blueprint.ext.evaluator.PropertyEvaluator;

public class SempertiPropertyEvaluator implements PropertyEvaluator {
	private static final Logger logger = LoggerFactory.getLogger(SempertiPropertyEvaluator.class);
	private Map<String, String> env;

	protected Map<String, String> getEnv() {
		if (env == null)
			env = System.getenv();
		return env;
	}

	public String evaluate(String key, Dictionary<String, String> properties) {
		String envValue = this.getEnv().get(key);
		String value = properties.get(key);

		logger.debug("Evaluating key: '{}' :: env: '{}' ::  '{}' ************", new Object[] { key, envValue, value });

		if (envValue != null)
			return envValue;

		return value;
	}
}
