package com.ttong.app.objectclass;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TestUser {
	static User[] users;

	@BeforeClass
	public static void setUp() {
		users = new User[3];
		users[0] = new Admin("111", "tux", new char[]{'1','2','3'});
		users[1] = new EventManager("222", "gwee", new char[]{'w','e','e'});
		users[2] = new Receptionist("333", "tan", new char[]{'t','a','n'});
	}

	@Test
	public void testUserImplementation() {
		assertArrayEquals(new Object[]{"111","tux", new char[]{'1','2','3'}}, 
			new Object[]{users[0].getUserId(), users[0].getUsername(), users[0].getPassword()});

		assertArrayEquals(new Object[]{"222","gwee", new char[]{'w','e','e'}}, 
			new Object[]{users[1].getUserId(), users[1].getUsername(), users[1].getPassword()});

		assertArrayEquals(new Object[]{"333","tan", new char[]{'t','a','n'}}, 
			new Object[]{users[2].getUserId(), users[2].getUsername(), users[2].getPassword()});
	}

	@Test
	public void testLogin1() {
		User loginUser = User.login("tux", new char[]{'1','2','3'});
		assertNotNull(loginUser);
	}

	@Test
	public void testLogin2() {
		User falseLoginUser = User.login("gwee", new char[]{'1','2','3'});
		assertNull(falseLoginUser);
	}

}
