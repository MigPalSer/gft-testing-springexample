package migpalser.holamundospring;

import java.math.BigDecimal;

public class FormatUtils {

	public static String fmtBigDecimal(BigDecimal bd) {
		String s=bd.toString();
		
		if(s.substring(s.length()-2).equals(".0")) {
			s=s.substring(0, s.length()-2);
		}
		
		return s;
	}
}
