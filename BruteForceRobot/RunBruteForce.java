import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.InputEvent;
import java.awt.AWTException;

public class RunBruteForce {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		RunBruteForce obj = new RunBruteForce();

		String command = "open -a Terminal";

		String output = obj.executeCommand(command);

		System.out.println(output);
		
		command = "whoami";
		output = obj.executeCommand(command);
		System.out.println(output);

		try {
			Robot robot = new Robot();
			robot.setAutoDelay(0);
			robot.setAutoWaitForIdle(true);
			
			robot.delay(1000);
			robot.mouseMove(700, 200);
			robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.delay(1000);

			/*
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_SPACE);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_M);
			robot.keyRelease(KeyEvent.VK_M);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_I);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_E);
			robot.keyRelease(KeyEvent.VK_E);
			robot.keyPress(KeyEvent.VK_L);
			robot.keyRelease(KeyEvent.VK_L);
			*/
			
			type(robot, "ssh Michael\\ Truell@172.17.121.183");
			
			/*
			String s = "ssh Michael\\ Truell@172.17.121.183";
			byte[] bytes = s.getBytes();
			for (byte b : bytes) {
				int code = b;
			    // keycode only handles [A-Z] (which is ASCII decimal [65-90])
			    if (code > 96 && code < 123) code = code - 32;
			    //robot.delay(1);
			    robot.keyPress(code);
			    robot.keyRelease(code);
			}
			*/

		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
	static void type(Robot robot, String s) {
		System.out.println("hello?");
		byte[] bytes = s.getBytes();
	    for (byte b : bytes)
	    {
	      int code = b;
	      System.out.println(b);
	      // keycode only handles [A-Z] (which is ASCII decimal [65-90])
	      if (code > 96 && code < 123) {
	    	  code = code - 32;
	      }
	      if (b <= 90 && b >= 65) {
	    	  System.out.println("testing");
	    	  robot.keyPress(KeyEvent.VK_SHIFT);
	    	  robot.keyPress(code);
	    	  robot.keyRelease(code);
	    	  robot.keyRelease(KeyEvent.VK_SHIFT);
	      } else if (b == 46) {
	    	  robot.keyPress(KeyEvent.VK_PERIOD);
	    	  robot.keyRelease(KeyEvent.VK_PERIOD);
	      } else if (b == 48) {
	    	  robot.keyPress(KeyEvent.VK_0);
	    	  robot.keyRelease(KeyEvent.VK_0);
		  } else if (b == 49) {
	    	  robot.keyPress(KeyEvent.VK_1);
	    	  robot.keyRelease(KeyEvent.VK_1);
	      } else if (b == 50) {
	    	  robot.keyPress(KeyEvent.VK_2);
	    	  robot.keyRelease(KeyEvent.VK_2);
	      } else if (b == 51) {
	    	  robot.keyPress(KeyEvent.VK_3);
	    	  robot.keyRelease(KeyEvent.VK_3);
	      } else if (b == 52) {
	    	  robot.keyPress(KeyEvent.VK_4);
	    	  robot.keyRelease(KeyEvent.VK_4);
	      } else if (b == 53) {
	    	  robot.keyPress(KeyEvent.VK_5);
	    	  robot.keyRelease(KeyEvent.VK_5);
	      } else if (b == 54) {
	    	  robot.keyPress(KeyEvent.VK_6);
	    	  robot.keyRelease(KeyEvent.VK_6);
	      } else if (b == 55) {
	    	  robot.keyPress(KeyEvent.VK_7);
	    	  robot.keyRelease(KeyEvent.VK_7);
	      } else if (b == 56) {
	    	  robot.keyPress(KeyEvent.VK_8);
	    	  robot.keyRelease(KeyEvent.VK_8);
	      } else if (b == 57) {
	    	  robot.keyPress(KeyEvent.VK_9);
	    	  robot.keyRelease(KeyEvent.VK_9);
	      } else if (b == 64) {
	    	  robot.keyPress(KeyEvent.VK_SHIFT);
	    	  robot.keyPress(KeyEvent.VK_2);
	    	  robot.keyRelease(KeyEvent.VK_SHIFT);
	      } else {
		      robot.keyPress(code);
		      robot.keyRelease(code);
	      }
	    }
	    robot.delay(100);
	    robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	static void typePassword() {
		//char[] chars = [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z];
	}
}
