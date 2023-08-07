import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CON {
    Connection c;
    Statement s;

    public CON(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","root");
            s=c.createStatement();
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
