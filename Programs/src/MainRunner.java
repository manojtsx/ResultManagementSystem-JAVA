import Frames.MyFrame;
import com.mysql.cj.log.Log;

public class MainRunner {
    public static void main(String s[]){
        MyFrame frame = new MyFrame();
        LoginWindow login = new LoginWindow();

        frame.add(login);
        frame.setVisible(true);


    }
}
