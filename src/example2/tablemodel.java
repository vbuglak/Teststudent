
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example2;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author CooL
 */
public class tablemodel extends AbstractTableModel {
    
    private int colnum=5;
    private int rownum;
    private String[] colNames={
        "ФИО","Дата рождения","Группа","Вид обучения","ID"
    };
    private  ArrayList<String[]> ResultSets;
    
    
    public tablemodel (ResultSet rs) {
      
      ResultSets=new ArrayList<String[]>();  
    
      try{
        while(rs.next()){
      
              String[] row={
                rs.getString("Firstname")+" "+rs.getString("Secondname")+" "+rs.getString("thirdname"),rs.getString("DateOfBirth"), rs.getString("name"),rs.getString("nametype"),rs.getString("idstudent")
          
            };
            ResultSets.add(row);
      
         }   
      }
      catch(Exception e){
          System.out.println("Exception in tabelmodel");
            }
        
    }
    
    public void refresh(ResultSet rs){
      
      ResultSets=new ArrayList<String[]>();  
    
      try{
        while(rs.next()){
      
              String[] row={
                rs.getString("Secondname")+" "+rs.getString("Firstname")+" "+rs.getString("thirdname"),rs.getString("DateOfBirth"), rs.getString("name"),rs.getString("nametype"),rs.getString("idstudent")
          
            };
            ResultSets.add(row);
      
         }   
      }
      catch(Exception e){
          System.out.println("Exception in tabelmodel");
            }
      
    }
   
    public Object getValueAt(int rowindex, int columnindex) {
        
       String[] row=ResultSets.get(rowindex);
       return row[columnindex];
        
    }

    public int getRowCount() {
        return ResultSets.size();
    }

    public int getColumnCount() {
        return colnum;
    }

    public String getColumnName(int param) {

       return colNames[param];
    }
    
}
