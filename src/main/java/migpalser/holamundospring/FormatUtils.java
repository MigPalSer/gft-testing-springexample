package migpalser.holamundospring;

import java.math.BigDecimal;

public class FormatUtils {

	public static String fmtBigDecimal(BigDecimal bd) {
		String s = bd.toString();

		if(s.length()>=2){
			if (s.substring(s.length() - 2).equals(".0")) {
				s = s.substring(0, s.length() - 2);
			} else if(s.length()>=3) {
				if(s.substring(s.length() - 3).equals(".00")) {
					s = s.substring(0, s.length() - 3);
				}
			}
			
		}
		

		return s;
	}
}
