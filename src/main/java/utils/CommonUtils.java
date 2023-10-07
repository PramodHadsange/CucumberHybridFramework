package utils;

import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;

public class CommonUtils {

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int EXPLICIT_WAIT_BASIC_TIME = 10;

	public static final int PAGE_LOAD_TIME = 10;

	public String getEmailWithTimeStamp()
	{
		Date date = new Date();
		return"Phadsan"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
	}
	
	public String alphaNumeric()
	{
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (st+num+"@gmail.com");
	}
}
