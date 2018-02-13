/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Юлия
 */
public class WordStatisticTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<WordStatistic> wordsAndAmountsOfText;

    public WordStatisticTableModel(List<WordStatistic> wordsAndAmountsOfText) {
        this.wordsAndAmountsOfText = wordsAndAmountsOfText;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return long.class;
            case 3:
                return double.class;
        }
        return String.class;
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "№";
            case 1:
                return "Лексема";
            case 2:
                return "Количество";
            case 3:
                return "Частота";
        }
        return "";
    }

    public int getRowCount() {
        return wordsAndAmountsOfText.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        WordStatistic wordsAndAmounts = wordsAndAmountsOfText.get(rowIndex);
        DecimalFormat f = new DecimalFormat("#,#####0.00000");
        switch (columnIndex) {
            case 0: 
                return rowIndex + 1;
            case 1:
                return wordsAndAmounts.getWord();
            case 2:
                return wordsAndAmounts.getAmount();
            case 3:
                return f.format(wordsAndAmounts.getFrequency());
        }
        return "";
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }
}
