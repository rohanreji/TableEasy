/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tableeasy.graphicaluserinterface.widgets.maintabbedpane;

/**
 *
 * @author Rohan
 */
import java.awt.*;

import java.sql.*;
import java.util.*;
import java.sql.*;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import tableeasy.OracleDatabaseConnection;

public class QueryTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	Vector<String[]> cache;
	int colCount;
	String[] headers;
	
	Connection conn; 
	Statement st;
	
	public String getColumnName(int i)
	{
		return headers[i];
	}
	
	public int getColumnCount()
	{
		return colCount;
	}
	
	public int getRowCount()
	{
		
     if(cache == null)
        return 0; 
     return cache.size();  
  
	}
	
	public Object getValueAt(int row, int col)
	{
		return ((String[]) cache.elementAt(row))[col];
	}
	
	
	public void setQuery(String sqlQuery) throws SQLException
	{
		cache = new Vector<String[]>();
		OracleDatabaseConnection conn=new OracleDatabaseConnection();
                
		Connection conn1 =conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
		System.out.println("Got Connection");
		
		Statement st = conn1.createStatement();
		
		st = conn1.createStatement();
		
		try
		{
			ResultSet rs = st.executeQuery(sqlQuery);
                        
			ResultSetMetaData meta = rs.getMetaData();
                      
			colCount = meta.getColumnCount();
                     
			///Execute the query and store the result set and its metadata
			
			headers = new String[colCount];
				for(int i=1;i<=colCount;i++)
				{
					headers[i-1]=meta.getColumnName(i);
				}
			///Rebuild the headers array with the new column names
				
			while(rs.next())
			{
				String[] record = new String[colCount];
					for(int i=0;i<colCount;i++)
					{
						record[i]=rs.getString(i+1);
                                                  System.out.println("where the hell:  "+meta.getTableName(2));
					}
				cache.addElement(record);
			}
			
			fireTableChanged(null);
			
		}
		catch(Exception e)
		{
			cache = new Vector<String[]>();
			e.printStackTrace();
		}
		
		
	}
	
}

