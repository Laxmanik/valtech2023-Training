package com.valtech.training.pattern.checker;

import java.util.List;
import java.util.Map;

public interface PatternCheckerService {

	Map<String, Integer> checkPatterns(List<String> phoneNumbers);

}