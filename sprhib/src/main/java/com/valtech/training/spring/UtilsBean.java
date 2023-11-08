package com.valtech.training.spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UtilsBean {

	private List<String> names;
	private Properties settings;
	private Map<Point, Line> points;
	
	
	public UtilsBean() {}

	
	
	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}



	public Properties getSettings() {
		return settings;
	}



	public void setSettings(Properties settings) {
		this.settings = settings;
	}



	public Map<Point, Line> getPoints() {
		return points;
	}



	public void setPoints(Map<Point, Line> points) {
		this.points = points;
	}
	
	

}
