package documentTockenisationAndCSSParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class CSSParser {
	public static void main(String[] args) {
//		String fileName = "css\style.css";
 
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/LAXMAN.KUDDEMMI/eclipse-workspace/documentTockenisationAndCSSParser/src/main/webapp/style.css"));
			String line;
			Pattern classPattern = Pattern.compile("\\.(\\w+)\\s*\\{([^\\}]+)\\}");
			Pattern intAttributePattern = Pattern.compile("\\s*(\\w+)\\s*:\\s*(\\d+)\\s*;");
			Pattern colorAttributePattern = Pattern.compile("\\s*(\\w+)\\s*:\\s*#([0-9a-fA-F]{6})\\s*;");
			Map<String, Map<String, String>> classAttributes = new HashMap<>();
 
			while ((line = br.readLine()) != null) {
				Matcher classMatcher = classPattern.matcher(line);
				while (classMatcher.find()) {
					String className = classMatcher.group(1);
					String attributesBlock = classMatcher.group(2);
					Map<String, String> attributes = new HashMap<>();
 
					Matcher intAttributeMatcher = intAttributePattern.matcher(attributesBlock);
					while (intAttributeMatcher.find()) {
						String attributeName = intAttributeMatcher.group(1);
						String attributeValue = intAttributeMatcher.group(2);
						attributes.put(attributeName, attributeValue);
					}
 
					Matcher colorAttributeMatcher = colorAttributePattern.matcher(attributesBlock);
					while (colorAttributeMatcher.find()) {
						String attributeName = colorAttributeMatcher.group(1);
						String hexColor = colorAttributeMatcher.group(2);
						String rgbColor = convertHexToRGB(hexColor);
						attributes.put(attributeName, rgbColor);
					}
 
					classAttributes.put(className, attributes);
				}
			}
 
			// Display class selectors and their attributes
			for (Map.Entry<String, Map<String, String>> entry : classAttributes.entrySet()) {
				System.out.println("Class Selector: " + entry.getKey());
				Map<String, String> attributes = entry.getValue();
				for (Map.Entry<String, String> attributeEntry : attributes.entrySet()) {
					System.out.println(attributeEntry.getKey() + ": " + attributeEntry.getValue());
				}
				System.out.println();
			}
 
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	private static String convertHexToRGB(String hexColor) {
		int colorValue = Integer.parseInt(hexColor, 16);
		int red = (colorValue >> 16) & 0xFF;
		int green = (colorValue >> 8) & 0xFF;
		int blue = colorValue & 0xFF;
		return "rgb(" + red + "," + green + "," + blue + ")";
	}
}