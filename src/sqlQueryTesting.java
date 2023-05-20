import java.sql.*;
import java.util.Scanner;


public class sqlQueryTesting {

    public static void main(String[] args) {
        // copy-paste from video (learning experience)
        Scanner sc = new Scanner(System.in);

        String db = sc.nextLine();
        String tablename = sc.nextLine();

        String url = "jdbc:mysql://localhost:3306/" + db;
        String username = "root";
        String password = "";




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
//            +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            ResultSet showColCount = statement.executeQuery("SELECT count(*)\n" +
                    "FROM INFORMATION_SCHEMA.COLUMNS\n" +
                    "WHERE TABLE_NAME = " + '\'' + tablename + '\'' + ";" + "\n" );
            int colsCount = 0;
            while(showColCount.next()){
                colsCount = showColCount.getInt(1); //shows number of columns
            }


//            ============================================================================================================

            ResultSet showRowsCount = statement.executeQuery("SELECT count(*)\n" +
                    "FROM " + tablename);
            int rowsCount = 0;
            while(showRowsCount.next()){
                rowsCount = showRowsCount.getInt(1); //shows number of rows
            }

//            ============================================================================================================

            ResultSet showAll = statement.executeQuery("SELECT * FROM " + tablename);
            while (showAll.next()){

                for (int i = 1; i <= colsCount; i++) {
                    System.out.printf("%s | ", showAll.getString(i));
                }


            }



            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
