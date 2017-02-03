package com.semperti.karaf.blueprint;

import java.util.Map;
import java.util.Dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.aries.blueprint.ext.evaluator.PropertyEvaluator;

public class SempertiPropertyEvaluator implements PropertyEvaluator {
	private static final Logger logger = LoggerFactory.getLogger(SempertiPropertyEvaluator.class);
	private static String KEYWORD_SERVICE = "service:";
	private static String SERVICE_HOST = "_SERVICE_HOST";
	private static String SERVICE_PORT = "_SERVICE_PORT";

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

		if (envValue != null && envValue.length() > 0)
			return envValue;

		if (key.startsWith(KEYWORD_SERVICE))
			return this.evaluateService(key.substring(KEYWORD_SERVICE.length()), properties);

		return value;
	}

	protected String evaluateService(String service, Dictionary<String, String> properties) {
		return evaluate(service+SERVICE_HOST, properties) + ":" + evaluate(service+SERVICE_PORT, properties);
	}
}
