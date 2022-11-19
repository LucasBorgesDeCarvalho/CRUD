package View.components;

import java.awt.Component;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
public class formTable extends JTable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Integer> linhasSelecionadas;
    private boolean mouseListennerActivated;
    public formTable(DefaultTableModel dtm)
    {
        super(dtm);
        mouseListennerActivated = true;
        linhasSelecionadas = new ArrayList<Integer>();
        formTable ref = this;
        ref.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = ref.rowAtPoint(evt.getPoint());
                if(row >= 0)
                {
                    //System.out.println(row);
                    ref.setLinhasSelecionadas(row);
                }
            }
        });
    }

    public void setMouseListennerActivated(boolean mouseListennerActivated) {
        this.mouseListennerActivated = mouseListennerActivated;
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
    {
        Component c = super.prepareRenderer(renderer, row, column);

        if (linhasSelecionadas.contains((Integer)row))
        {
            c.setBackground(Color.PINK);
        }
        else
        {
            c.setBackground(null);
        }
        return c;
    }

    public void setLinhasSelecionadas(int row) {
        if (mouseListennerActivated == true) {
            boolean exist = false;
            int i = 0;
            for (i = 0; i < linhasSelecionadas.size(); i++) {
                if (linhasSelecionadas.get(i) == row) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                linhasSelecionadas.remove(i);
            } else {
                linhasSelecionadas.add(row);
            }
            this.repaint();
            this.revalidate();
        }
    }


    // verifica se a lista está vazia

    public boolean EstaVazia()
    {

        if(linhasSelecionadas.size() == 0)
        {
            return true;
        }
        return false;
    }

    public boolean SomenteUmEstaSelecionado(){
        if (linhasSelecionadas.size() == 1){
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Integer> getLinhasSelecionadas()
    {
        return linhasSelecionadas;
    }
    @Override
    public boolean editCellAt(int row, int column, java.util.EventObject e)
    {
        return false;
    }

}
