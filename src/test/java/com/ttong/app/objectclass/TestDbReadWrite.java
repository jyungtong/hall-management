package com.ttong.app.objectclass;

import org.junit.*;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import com.ttong.app.AppConstants;
import java.io.*;

/*
 *@RunWith(Suite.class)
 *@Suite.SuiteClasses({
 *  TestUser.class
 *})
 */
public class TestDbReadWrite {
	static User[] users;

	@BeforeClass
	public static void setUp() {
		users = new User[3];
		users[0] = new Admin("111", "tux", new char[]{'1','2','3'});
		users[1] = new EventManager("222", "gwee", new char[]{'w','e','e'});
		users[2] = new Receptionist("333", "tan", new char[]{'t','a','n'});
	}

	@Test
	public void testWriteData() {
		DbWrite writer = new DbWrite(AppConstants.USERDB);
		writer.writeData(users);

		assertTrue(new File(AppConstants.USERDB).length() > 0);
	}

	@Test
	public void testGetData() {
		DbRead reader = new DbRead(AppConstants.USERDB);
		User[] readUsers = (User[]) reader.getData();

		assertArrayEquals(new Object[]{"111","tux", new char[]{'1','2','3'}}, 
			new Object[]{users[0].getUserId(), users[0].getUsername(), users[0].getPassword()});

		assertArrayEquals(new Object[]{"222","gwee", new char[]{'w','e','e'}}, 
			new Object[]{users[1].getUserId(), users[1].getUsername(), users[1].getPassword()});

		assertArrayEquals(new Object[]{"333","tan", new char[]{'t','a','n'}}, 
			new Object[]{users[2].getUserId(), users[2].getUsername(), users[2].getPassword()});
	}

}
