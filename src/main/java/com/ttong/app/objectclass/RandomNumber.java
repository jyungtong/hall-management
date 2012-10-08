package com.ttong.app.objectclass;

import java.util.Random;

public class RandomNumber {
	public static int getNumber(int start, int end) {
		Random random = new Random();
		return random.nextInt(end - start + 1) + start; 
	}
}
