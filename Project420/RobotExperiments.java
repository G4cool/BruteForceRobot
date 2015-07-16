import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.Timer;
public class RobotExperiments implements NativeKeyListener
{
    private static final int KILL_CHANCE = 50;
    static Robot r;
    static Random rand;
    static boolean [] alphapressed = new boolean[26];
    static boolean commandPressed;
    static boolean escapePressed;
    static boolean altPressed;

    public static void main(String [] args)
    {
        rand = new Random();
        
        for(int a = 0; a < alphapressed.length; a++)
        {
            alphapressed[a] = true;
        }
        commandPressed = false;
        altPressed = false;
        escapePressed = false;

        try
        {
            r = new Robot();
            GlobalScreen.registerNativeHook();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.err.println("There was a problem.");

            System.exit(1);
        }

        //Construct the example object and initialze native hook.
        GlobalScreen.getInstance().addNativeKeyListener(new RobotExperiments());
        
        
    }

    public void nativeKeyPressed(NativeKeyEvent e)
    {
        if(e.getKeyCode() == NativeKeyEvent.VK_CONTROL && rand.nextInt(KILL_CHANCE)%KILL_CHANCE == 0)
        {
            r.keyPress(KeyEvent.VK_SHIFT);
            r.keyPress(KeyEvent.VK_Q);
            r.delay(25);
            r.keyRelease(KeyEvent.VK_SHIFT);
            r.keyRelease(KeyEvent.VK_Q);
            r.keyRelease(KeyEvent.VK_CONTROL);
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_META && rand.nextInt(KILL_CHANCE)%KILL_CHANCE == 0)
        {
            r.keyPress(KeyEvent.VK_Q);
            r.delay(25);
            r.keyRelease(KeyEvent.VK_Q);
            r.keyRelease(KeyEvent.VK_META);
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_Z && !alphapressed[25])
        {
            alphapressed[25] = false;
            r.keyRelease(KeyEvent.VK_Z);
            r.delay(10);
            r.keyPress(KeyEvent.VK_BACK_SPACE);
            r.keyRelease(KeyEvent.VK_BACK_SPACE);
            alphapressed[23] = true;
            r.keyPress(KeyEvent.VK_X);
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_X && !alphapressed[23])
        {
            alphapressed[23] = false;
            r.keyRelease(KeyEvent.VK_X);
            alphapressed[23] = false;
            r.delay(10);
            r.keyPress(KeyEvent.VK_BACK_SPACE);
            r.keyRelease(KeyEvent.VK_BACK_SPACE);
            alphapressed[25] = true;
            r.keyPress(KeyEvent.VK_Z);
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_META)
        {
            if(altPressed)
            {
                r.keyRelease(KeyEvent.VK_ALT);
            }
            else if(escapePressed)
            {
                r.keyRelease(KeyEvent.VK_ESCAPE);
            }
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_ALT)
        {
            if(commandPressed)
            {
                r.keyRelease(KeyEvent.VK_ALT);
            }
            else if(escapePressed)
            {
                r.keyRelease(KeyEvent.VK_ESCAPE);
            }
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_ESCAPE)
        {
            if(commandPressed || altPressed)
            {
                r.keyRelease(KeyEvent.VK_ESCAPE);
            }
        }
        
        
        if(e.getKeyCode() == NativeKeyEvent.VK_A)
        {
            alphapressed[0] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_B)
        {
            alphapressed[1] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_C)
        {
            alphapressed[2] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_D)
        {
            alphapressed[3] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_E)
        {
            alphapressed[4] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_F)
        {
            alphapressed[5] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_G)
        {
            alphapressed[6] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_H)
        {
            alphapressed[7] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_I)
        {
            alphapressed[8] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_J)
        {
            alphapressed[9] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_K)
        {
            alphapressed[10] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_L)
        {
            alphapressed[11] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_M)
        {
            alphapressed[12] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_N)
        {
            alphapressed[13] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_O)
        {
            alphapressed[14] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_P)
        {
            alphapressed[15] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_Q)
        {
            alphapressed[16] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_R)
        {
            alphapressed[17] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_S)
        {
            alphapressed[18] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_T)
        {
            alphapressed[19] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_U)
        {
            alphapressed[20] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_V)
        {
            alphapressed[21] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_W)
        {
            alphapressed[22] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_X)
        {
            alphapressed[23] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_Y)
        {
            alphapressed[24] = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_Z)
        {
            alphapressed[25] = true;
        }
        //Special Keys
        else if(e.getKeyCode() == NativeKeyEvent.VK_META)
        {
            commandPressed = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_ALT)
        {
            altPressed = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_ESCAPE)
        {
            escapePressed = true;
        }

        if (e.getKeyCode() == NativeKeyEvent.VK_ESCAPE)
        {
            GlobalScreen.unregisterNativeHook();
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e)
    {
        //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        
        if(e.getKeyCode() == NativeKeyEvent.VK_Z && alphapressed[25])
        {
            r.keyRelease(KeyEvent.VK_X);
        }
        if(e.getKeyCode() == NativeKeyEvent.VK_X && alphapressed[23])
        {
            r.keyRelease(KeyEvent.VK_Z);
        }

        if(e.getKeyCode() == NativeKeyEvent.VK_A)
        {
            alphapressed[0] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_B)
        {
            alphapressed[1] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_C)
        {
            alphapressed[2] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_D)
        {
            alphapressed[3] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_E)
        {
            alphapressed[4] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_F)
        {
            alphapressed[5] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_G)
        {
            alphapressed[6] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_H)
        {
            alphapressed[7] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_I)
        {
            alphapressed[8] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_J)
        {
            alphapressed[9] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_K)
        {
            alphapressed[10] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_L)
        {
            alphapressed[11] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_M)
        {
            alphapressed[12] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_N)
        {
            alphapressed[13] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_O)
        {
            alphapressed[14] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_P)
        {
            alphapressed[15] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_Q)
        {
            alphapressed[16] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_R)
        {
            alphapressed[17] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_S)
        {
            alphapressed[18] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_T)
        {
            alphapressed[19] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_U)
        {
            alphapressed[20] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_V)
        {
            alphapressed[21] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_W)
        {
            alphapressed[22] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_X)
        {
            alphapressed[23] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_Y)
        {
            alphapressed[24] = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_Z)
        {
            alphapressed[25] = false;
        }
        //Special Keys
        else if(e.getKeyCode() == NativeKeyEvent.VK_META)
        {
            commandPressed = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_ALT)
        {
            altPressed = false;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VK_ESCAPE)
        {
            escapePressed = false;
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e)
    {
        //System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));

    }
    
    public void screenControl(Robot robot, String fileName) {
        while(true) {
            int delay = 1000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //...Perform a task...
                }
            };
            new Timer(delay, taskPerformer).start();
            try {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                Rectangle screenRectangle = new Rectangle(screenSize);
                BufferedImage image = robot.createScreenCapture(screenRectangle);
                ImageIO.write(image, "png", new File(fileName));
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("There was a problem.");
    
                System.exit(1);
            }
        }
    }
}