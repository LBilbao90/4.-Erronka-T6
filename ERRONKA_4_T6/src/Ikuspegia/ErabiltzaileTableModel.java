package Ikuspegia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Modelo.Erabiltzaile;

public class ErabiltzaileTableModel extends AbstractTableModel {

    private List<Erabiltzaile> erabiltzaileak;
    private String[] columnNames = {"NAN", "Izena", "Abizena", "Jaiotze data", "Momentuko diru kopurua", "Maila"};

    public ErabiltzaileTableModel(List<Erabiltzaile> erabiltzaileak) {
        this.erabiltzaileak = erabiltzaileak;
    }

    public void setErabiltzaileak(List<Erabiltzaile> erabiltzaileak) {
        this.erabiltzaileak = erabiltzaileak;
        fireTableDataChanged();
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        return erabiltzaileak.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Erabiltzaile erabiltzaile = erabiltzaileak.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return erabiltzaile.getNAN();
            case 1:
                return erabiltzaile.getIzena();
            case 2:
                return erabiltzaile.getAbizena();
            case 3:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(erabiltzaile.getJaioteguna());
            case 4:
                return erabiltzaile.getDiru_kopuru_momentukoa();
            case 5:
            	if (erabiltzaile.getId_maila() == 1) {
            		return "Brontze";
            	} else if (erabiltzaile.getId_maila() == 2) {
            		return "Zilarra";
            	} else if (erabiltzaile.getId_maila() == 3) {
            		return "Urrea";
            	}
                 
            default:
                return null;
        }
        
        
    }
}
