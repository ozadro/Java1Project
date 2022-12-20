/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model;

import hr.algebra.model.Newspaper;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class NewspaperTableModel extends AbstractTableModel {
   private static final String[] COLUMN_NAMES = {"Id", "Title", "JournalistID", "ArticleID", "Picture path"};
    
    private List<Newspaper> newspapers;

    public NewspaperTableModel(List<Newspaper> newspapers) {
        this.newspapers = newspapers;
    }

    public void setNewspapers(List<Newspaper> newspapers) {
        this.newspapers = newspapers;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return newspapers.size();
    }

    @Override
    public int getColumnCount() {
        return Newspaper.class.getDeclaredFields().length - 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return newspapers.get(rowIndex).getId();
            case 1:
                return newspapers.get(rowIndex).getTitle();
            case 2:
                return newspapers.get(rowIndex).getJournalistID();
            case 3:
                return newspapers.get(rowIndex).getArticleID();
            case 4:
                return newspapers.get(rowIndex).getPicturePath();
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
