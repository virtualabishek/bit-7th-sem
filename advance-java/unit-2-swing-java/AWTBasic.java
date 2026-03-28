import java.awt.*;
public  class AWTBasic {
    Frame main;
    Panel p;
    Label name, address;
    TextField tname, taddress;
    Button submit;

    AWTBasic() {
        main = new Frame("Main");
        main.setSize(500, 500);
        main.setLayout(null);
        name = new Label("Name");
        name.setBounds(50,100,50,20);
        main.add(name);
        tname = new TextField();
        tname.setBounds(150,100,150,20);
        main.add(tname);
        address = new Label("Address");
        address.setBounds(50, 150,50,20);
        main.add(address);
        taddress = new TextField();
        taddress.setBounds(150,150,150,20);
        main.add(taddress);
        submit = new Button("Submit");
        submit.setBounds(250,200,50,30);
        main.add(submit);
        p = new Panel();
        p.setBounds(0,250,500,100);
        p.setBackground(Color.CYAN);
        main.add(p);
        main.setVisible(true);
        // System.out.println(tname);
        // System.out.println(address);
    }
    public static void main(String[] args) {
        new AWTBasic();
    }
    
}