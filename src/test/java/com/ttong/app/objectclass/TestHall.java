package com.ttong.app.objectclass;

import com.ttong.app.AppConstants;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class TestHall {
	static Hall[] halls;
	static Object[] expected; 

	@BeforeClass
	public static void setUp() {
		halls = new Hall[5];
		halls[0] = new Hall(1001, 1, HallType.THEATRE, HallType.BOARDROOM, 
									new HallDimension(10,10), 
									new ArrayList<String>() {{add("drinks"); add("food");}});
		halls[1] = new Hall(1002, 2, HallType.BOARDROOM, HallType.BANQUET, 
									new HallDimension(15,10), 
									new ArrayList<String>() {{add("drinks"); add("food");}});
		halls[2] = new Hall(1003, 3, HallType.USHAPE, HallType.HOLLOWSQUARE, 
									new HallDimension(13,10), 
									new ArrayList<String>() {{add("drinks"); add("food");}});
		halls[3] = new Hall(1004, 4, HallType.CLASSROOM, HallType.BOARDROOM, 
									new HallDimension(10,11), 
									new ArrayList<String>() {{add("drinks"); add("food");}});
		halls[4] = new Hall(1005, 5, HallType.RECEPTION, HallType.USHAPE, 
									new HallDimension(10,14), 
									new ArrayList<String>() {{add("drinks"); add("food");}});

		expected = new Object[] {
			1001,
			1,
			HallType.THEATRE,
			HallType.BOARDROOM,
			100,
			new Object[] {"drinks", "food"},
			264,
			100.0*AppConstants.RPDTHEATRE
		};
	
	}

	@Test
	public void testHallDimensionGetArea() {
		HallDimension dimension = new HallDimension(10, 5);
		assertEquals(50, dimension.getArea());
	}

	@Test
	public void testWriteHall() {
		DbWrite writer = new DbWrite(AppConstants.HALLDB);
		writer.writeData(halls);
		
		assertTrue(new File(AppConstants.HALLDB).length() > 0);
	}

	@Test
	public void testReadHall() {
		DbRead reader = new DbRead(AppConstants.HALLDB);
		Hall[] readHalls = (Hall[]) reader.getData();

		Object[] actual = new Object[] {
			readHalls[0].getHallNo(),
			readHalls[0].getFloor(),
			readHalls[0].getHallType(),
			readHalls[0].getSeatingStyle(),
			readHalls[0].getDimension().getArea(),
			readHalls[0].getFacilities().toArray(),
			readHalls[0].getCapacity(),
			readHalls[0].getRentPerDay()
		};

		assertArrayEquals(expected, actual);
	}
}
