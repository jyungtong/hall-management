package com.ttong.app;

import com.ttong.app.view.LoginView;
import com.ttong.app.controller.LoginController;
import com.ttong.app.model.LoginModel;
import javax.swing.SwingUtilities;

import com.ttong.app.objectclass.*;
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) {
		LoginModel loginModel = new LoginModel();
		LoginView loginView = new LoginView();
		LoginController loginController = new LoginController(loginView, loginModel);



/*
 *    Hall[] halls = new Hall[5];
 *    halls[0] = new Hall(1, 1, HallType.THEATRE, HallType.BOARDROOM, 
 *                  new HallDimension(10,10), 
 *                  new ArrayList<String>() {{add("drinks"); add("food");}});
 *    halls[1] = new Hall(2, 2, HallType.BOARDROOM, HallType.BANQUET, 
 *                  new HallDimension(15,10), 
 *                  new ArrayList<String>() {{add("drinks"); add("food");}});
 *    halls[2] = new Hall(3, 3, HallType.USHAPE, HallType.HOLLOWSQUARE, 
 *                  new HallDimension(13,10), 
 *                  new ArrayList<String>() {{add("drinks"); add("food");}});
 *    halls[3] = new Hall(4, 4, HallType.CLASSROOM, HallType.BOARDROOM, 
 *                  new HallDimension(10,11), 
 *                  new ArrayList<String>() {{add("drinks"); add("food");}});
 *    halls[4] = new Hall(5, 5, HallType.RECEPTION, HallType.USHAPE, 
 *                  new HallDimension(10,14), 
 *                  new ArrayList<String>() {{add("drinks"); add("food");}});
 *
 *    try {
 *      FileOutputStream fos = new FileOutputStream(AppConstants.HALLDB);
 *      ObjectOutputStream oos = new ObjectOutputStream(fos);
 *      oos.writeObject(halls);
 *    } catch(Exception e) {
 *      e.printStackTrace();
 *    }
 */

		/*
		 *try{
		 *FileInputStream fis = new FileInputStream(AppConstants.HALLDB);
		 *ObjectInputStream ois = new ObjectInputStream(fis);
		 *Hall[] newhalls = (Hall[]) ois.readObject();
		 *System.out.println(newhalls.length);
		 *} catch (Exception ex) {
		 *  ex.printStackTrace();
		 *}
		 */



				/*
				 *DbRead reader = new DbRead(AppConstants.HALLDB);
				 *Hall[] newhalls = (Hall[]) reader.getData();
				 *System.out.println(newhalls.length);
				 */

				/*
				 *DbRead reader = new DbRead(AppConstants.USERDB);
				 *User[] users = (User[]) reader.getData();
				 *System.out.println(users.length);
				 */
	}
}
