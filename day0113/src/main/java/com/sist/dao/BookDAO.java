package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
    String url="jdbc:oracle:thin:@localhost:1521:XE";
    String user="c##madang";
    String password = "madang";
    
    public int bookPrice(String bookname,String publisher) {
    	String sql = "select price from book where bookname=? and publisher=?";
    	int price=0;
    	Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,bookname);
            pstmt.setString(2,publisher);
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	price = rs.getInt(1);
            }
            
        }catch (Exception e) {
            System.out.println("예외발생:"+e.getMessage());
        }finally {
            try {
                if(conn!=null) {
                    conn.close();
                }
                if(rs!= null) {
                    rs.close();
                }
                if(pstmt!= null) {
                    pstmt.close();
                }
            }catch (Exception e) {
                
            }
        }
    	return price;
    }
}
