import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenq,exit;
    String pinnumber;
    FastCash(String pinnumber){

        this.pinnumber=pinnumber;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text =new JLabel("Select Withdrawal Amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Rs 100");
        deposit.setBounds(170,395,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(355,395,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(170,430,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,430,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);


        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,465,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenq=new JButton("Rs 10000");
        balanceenq.setBounds(355,465,150,30);
        balanceenq.addActionListener(this);
        image.add(balanceenq);


        exit=new JButton("Back");
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
            setVisible(false);
            new transact(pinnumber).setVisible(true);
        }
        else{
            String amount=((JButton)ae.getSource()).getText().substring(3);//Rs 500
            try {
                CON c = new CON();
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String querry="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal'.'"+amount+"')";
                c.s.executeUpdate(querry);
                JOptionPane.showMessageDialog(null,"Rs "+amount+"Debited Sucessfully");
                setVisible(false);
                new transact(pinnumber).setVisible(true);

            }catch (Exception e){
                e.printStackTrace();
            }


        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
