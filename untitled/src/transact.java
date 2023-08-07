import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transact extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenq,exit;
    String pinnumber;
    transact(String pinnumber){

        this.pinnumber=pinnumber;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text =new JLabel("Please Select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(170,395,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,395,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,430,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("MIni Statement");
        ministatement.setBounds(355,430,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);


        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,465,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenq=new JButton("Balance Enquiry");
        balanceenq.setBounds(355,465,150,30);
        balanceenq.addActionListener(this);
        image.add(balanceenq);


        exit=new JButton("Exit");
        exit.setBounds(355,500,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setUndecorated(true);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()==withdrawl) {
            setVisible(false);
            new withdrawal(pinnumber).setVisible(true);
        } else if (ae.getSource()==fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource()==pinchange) {
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        } else if (ae.getSource()==balanceenq) {
            setVisible(false);
            new balanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource()==ministatement) {
            setVisible(false);
            new ministatement(pinnumber).setVisible(true);
        }

    }


    public static void main(String[] args) {
        new transact("");
    }
}
