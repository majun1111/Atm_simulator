import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinchange extends JFrame implements ActionListener {

    JTextField pin, repin;
    JButton change,back;
    String pinnumber;
    pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(250,260,500,35);
        image.add(text);

        JLabel pintext=new JLabel("New PIN :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        pintext.setBounds(165,320,180,35);
        image.add(pintext);

         pin =new JTextField();
        pin.setBounds(330,320,180,25);
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(pin);

        JLabel repintext=new JLabel("RE-Enter New PIN :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway",Font.BOLD,16));
        repintext.setBounds(165,360,180,35);
        image.add(repintext);

        repin=new JTextField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

         change=new JButton("CHANGE");
        change.setBounds(355,465,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("BACK");
        back.addActionListener(this);
        back.setBounds(355,500,150,30);
        image.add(back);








        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Enterd PIN dose not match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null,"PLese enter the PIN");

                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null,"PLease Enter RE-PIN");

                }
                CON conn=new CON();
                String query1="update bank set pin='"+rpin+"'where pin='"+pinnumber+"'";
                String query2="update login set pin='"+rpin+"'where pin='"+pinnumber+"'";
                String query3="update signupthree set pin='"+rpin+"'where pin='"+pinnumber+"'";


                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed Successfully");

                setVisible(false);
                new transact(pinnumber).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }else {
            setVisible(false);
            new transact(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new pinchange("");
    }
}
