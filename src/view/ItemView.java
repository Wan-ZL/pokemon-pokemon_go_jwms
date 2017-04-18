package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.Trainer;

public class ItemView extends JPanel implements Observer {
	private JTable table;	// hold all the items
	private JList<String> list;		// hold all the caught pokemon

	private ListModel<String> list_model;
	private TableModel table_model;
	
	private Trainer trainer;
	
	public ItemView(Trainer trainer){
		this.setPreferredSize(new Dimension(100,100));
		this.setLayout(new GridLayout(3, 1));
		this.setBackground(Color.cyan);
		JLabel name = new JLabel(trainer.getName());
		this.add(name);
		
		list = new JList<String>();
		//this.add(list);
		list_model = trainer.getPokemonBelt();
		System.out.println(list_model);
		list.setModel(list_model);
		list.setBackground(Color.red);
		
		
		table = new JTable();
		//this.add(table);
		table_model = trainer.getBackpack();
		System.out.println(trainer.getBackpack().toString());
		table.setModel(table_model);
		JScrollPane scrollPane = new JScrollPane(table);
	    this.add(scrollPane); 
	    RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table_model);
	    table.setRowSorter(sorter);
	    table.setMaximumSize(new Dimension(30, 30));
	    table.setBackground(Color.blue);
	    
	    System.out.println("in the items");
	   
	}
	
	
	
	// method needed from the observer interface
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
