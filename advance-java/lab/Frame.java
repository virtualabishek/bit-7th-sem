import java.awt.*;

public class FrameExample {

    Frame f;
    Label user;
    TextField tuser;

    FrameExample() {

        f = new Frame("Login");
        f.setSize(400, 500);
        f.setLayout(null);

        user = new Label("Username");
        user.setBounds(100, 50, 100, 30);
        f.add(user);

        tuser = new TextField();
        tuser.setBounds(150, 100, 200, 30);
        f.add(tuser);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameExample();
    }
}
