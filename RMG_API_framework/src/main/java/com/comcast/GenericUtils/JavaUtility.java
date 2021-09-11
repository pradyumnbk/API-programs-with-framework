package com.comcast.GenericUtils;

import java.util.Random;

public class JavaUtility 
{
	/**
	 * generic method related to java
	 * @return rand
	 */
	public int randomNumber()
	{
		Random random = new Random();
		int rand = random.nextInt(1000);
		return rand;
	}
}
