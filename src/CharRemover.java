import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CharRemover {

	public static void main(String[] args) throws IOException {
		String xml10pattern = "[^" 
				+ "\u0009\r\n" 
				+ "\u0020-\uD7FF"
				+ "\uE000-\uFFFD" 
				+ "\ud800\udc00-\udbff\udfff" 
				+ "]";
		File file = new File(args[0]);
		List<String> strings = FileUtils.readLines(file);
		List<String> outs = new ArrayList<String>();
		for (int i = 0; i < strings.size(); i++) {
			String s = strings.get(i);
			String s2 = s.replaceAll(xml10pattern, "");
			outs.add(i, s2);
		}
		File out = new File(args[1]);
		FileUtils.writeLines(out, outs);
	}

}
