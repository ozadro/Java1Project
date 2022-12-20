/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model;

import hr.algebra.model.Journalists;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class JournalistTableModel extends AbstractTableModel {
    
    private static final String[] COLUMN_NAMES = {"Id", "First Name", "Last Name" , "Age" , "Email" , "Picture Path"};
    
    private List<Journalists> journalists;

    public JournalistTableModel(List<Journalists> journalists) {
        this.journalists = journalists;
    }

    public void setJournalists(List<Journalists> journalists) {
        this.journalists = journalists;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return journalists.size();
    }

    @Override
    public int getColumnCount() {
       return Journalists.class.getDeclaredFields().length - 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch (columnIndex) {
            case 0:
                return journalists.get(rowIndex).getId();
            case 1:
                return journalists.get(rowIndex).getFirstName();
            case 2:
                return journalists.get(rowIndex).getLastName();
            case 3:
                return journalists.get(rowIndex).getAge();
            case 4:
                return journalists.get(rowIndex).getEmail();
            case 5:
                return journalists.get(rowIndex).getPicturePath();
            default:
                throw new RuntimeException("No such column");
        }
    }
    
     @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex); 
    }
    
    
    
    
}
