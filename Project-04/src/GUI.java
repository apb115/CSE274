import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.Window.Type;
import java.awt.SystemColor;

// Project 04 - FinalProject GPS
// Names: Vimal Vinod (vinodv), Aaron Bryant (bryant53), Andrew Boothe (boothea)
// Date: 05/06/2022
// Purpose: Implement GUI

public class GUI {

	private JFrame frmGpsApplication;
	private JTextField destination;
	private JTextField startArea;
	private JTextArea output;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private JTextField stTxt;
	private JTextField desTxt;
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		// Creates the window and sets its visibility to true and if not
		// prints the exception found
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmGpsApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	

			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Creates the frame where everything goes
		frmGpsApplication = new JFrame();
		// Sets the name of the GUI
		frmGpsApplication.setTitle("GPS Application");
		// Sets the background color
		frmGpsApplication.getContentPane().setBackground(new Color(127, 255, 212));
		// Sets the area in which it will be generated from
		frmGpsApplication.setBounds(200, 50, 450, 300);
		// Sets the size of the application
		frmGpsApplication.setSize(480,800);
		// Sets the closing procedure
		frmGpsApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGpsApplication.getContentPane().setLayout(null);
		
		// A label for the title
		JLabel lblNewLabel = new JLabel("GPS Application - Shortest Path");
		// Sets its horizontal alignment of text
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// Sets the bounds where it appears
		lblNewLabel.setBounds(16, 6, 438, 16);
		// Adds it to frame
		frmGpsApplication.getContentPane().add(lblNewLabel);
		
		// A label for the start area
		JLabel lblNewLabel_1 = new JLabel("Start Area");
		// Sets its horizontal alignment of text
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		// Sets the bounds where it appears
		lblNewLabel_1.setBounds(6, 34, 213, 16);
		// Adds it to frame
		frmGpsApplication.getContentPane().add(lblNewLabel_1);

		// A label for the destination
		JLabel lblNewLabel_1_1 = new JLabel("Destination");
		// Sets its horizontal alignment of text
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		// Sets the bounds where it appears
		lblNewLabel_1_1.setBounds(247, 34, 213, 16);
		// Adds it to frame
		frmGpsApplication.getContentPane().add(lblNewLabel_1_1);

		// A label for the destination
		JLabel lblNewLabel_2 = new JLabel("Calculate Based On:");
		// Sets its horizontal alignment of text
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		// Sets the bounds where it appears
		lblNewLabel_2.setBounds(16, 484, 438, 16);
		// Adds it to frame
		frmGpsApplication.getContentPane().add(lblNewLabel_2);
		
		// Adds a button for the time cost
		JButton btnNewButton = new JButton("Time Cost");
		// Gives the action method to that button
		btnNewButton.setAction(action);
		// Sets the bounds of the button
		btnNewButton.setBounds(6, 505, 213, 29);
		// Adds it to the frame
		frmGpsApplication.getContentPane().add(btnNewButton);
		
		// Adds a button for the distance cost
		JButton btnNewButton_1 = new JButton("Distance Cost");
		// Gives the action method to that button
		btnNewButton_1.setAction(action_1);
		// Sets the bounds of the button
		btnNewButton_1.setBounds(247, 505, 213, 29);
		// Adds it to the frame
		frmGpsApplication.getContentPane().add(btnNewButton_1);
		
		// Creates a textfield where the output of the operation is displayed
		output = new JTextArea();
		// Makes it so you cannot edit the field
		output.setEditable(false);
		// Sets the bounds of the text field 
		output.setBounds(6, 581, 454, 160);
		// Adds it to the frame
		frmGpsApplication.getContentPane().add(output);
		// Sets the columns to 10
		output.setColumns(10);
		// Sets the alignment 
		
		
		// Adds label for the directions
		JLabel lblNewLabel_3 = new JLabel("Directions");
		// Sets alignment to center
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		// Sets bounds to this
		lblNewLabel_3.setBounds(198, 423, 82, 16);
		// Adds it to the frame
		frmGpsApplication.getContentPane().add(lblNewLabel_3);
		
		// Map to read in the entries that the textfile contained
		Map<String, String> entries = readFile();
		
		// Creates textfield to show what user chose
		stTxt = new JTextField();
		// Sets its bounds
		stTxt.setBounds(6, 453, 205, 26);
		// Makes it not editable
		stTxt.setEditable(false);
		// Adds it to frame
		frmGpsApplication.getContentPane().add(stTxt);
		stTxt.setColumns(10);
		
		// Creates a list to display what was found in the textfile
		JList startAr = new JList();
		// Adds the text chosen to the "stTxt" field above
		startAr.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
	                stTxt.setText((String) startAr.getSelectedValue());

	            }
			}
		});
		// Done based on the values from the map
		startAr.setListData(entries.values().toArray());
		// Sets the bounds of the object 
		startAr.setBounds(6, 62, 213, 346);
		// Makes it single selection
		startAr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Adds start area to the frame
		frmGpsApplication.getContentPane().add(startAr);
		

		// Creates textfield to show what user chose for destination
		desTxt = new JTextField();
		// Makes it so you cannot edit the field
		desTxt.setEditable(false);
		// Adds it to frame
		desTxt.setColumns(10);
		// Sets bounds
		desTxt.setBounds(255, 453, 205, 26);
		// Adds it to frame
		frmGpsApplication.getContentPane().add(desTxt);
		
		// Creates a list to display what was found in the textfile
		JList destAr = new JList();
		// Adds the text chosen to the "desTxt" field above
		destAr.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
	                desTxt.setText((String) destAr.getSelectedValue());

	            }
			}
		});
		// Done based on the values from the map
		destAr.setListData(entries.values().toArray());
		// Sets the bounds of the object
		destAr.setBounds(247, 62, 213, 346);
		// Makes it single selection
		destAr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Adds start area to the frame
		frmGpsApplication.getContentPane().add(destAr);	
		
		// Label for displaying "to"
		JLabel lblNewLabel_4 = new JLabel("to");
		// Sets orientation
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		// Sets bounds
		lblNewLabel_4.setBounds(208, 456, 49, 16);
		// Adds it to frame
		frmGpsApplication.getContentPane().add(lblNewLabel_4);
		
		// A separator to add visual separation 
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 414, 454, 12);
		frmGpsApplication.getContentPane().add(separator);
		
		// A separator to add visual separation 
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(6, 20, 454, 16);
		frmGpsApplication.getContentPane().add(separator_1);
		
		// A separator to add visual separation 
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(6, 741, 454, 12);
		frmGpsApplication.getContentPane().add(separator_2);
		
		// For the symbols of the addresses (not selectable)
		JList symbolRep = new JList();
		symbolRep.setEnabled(false);
		// Sets background
		symbolRep.setBackground(new Color(127, 255, 212));
		symbolRep.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Sets bounds
		symbolRep.setBounds(227, 62, 20, 346);
		// Adds it to the frame
		frmGpsApplication.getContentPane().add(symbolRep);
		// Sets the data to keyset
		symbolRep.setListData(entries.keySet().toArray());
		
		// Button to display path as addresses
		JButton btnNewButton_2 = new JButton("Distance Path As Addresses");
		btnNewButton_2.setAction(action_2);
		// Sets bounds
		btnNewButton_2.setBounds(247, 540, 213, 29);
		// Adds button to frame
		frmGpsApplication.getContentPane().add(btnNewButton_2);
		
		// Label for symbols
		JLabel lblNewLabel_5 = new JLabel("Symbols");
		// Sets orientation
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		// Sets bounds
		lblNewLabel_5.setBounds(206, 34, 61, 16);
		// Adds it to frame
		frmGpsApplication.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_2_1 = new JButton("Time Path As Addresses");
		btnNewButton_2_1.setAction(action_3);
		btnNewButton_2_1.setBounds(6, 540, 213, 29);
		frmGpsApplication.getContentPane().add(btnNewButton_2_1);
	}
	
	// Reads the file in and populates a map
	private Map<String, String> readFile() {
		Map<String, String> vertices = null;
		try (Scanner in = new Scanner(new File("MapInformation.txt"));) {
			String line = in.nextLine();
            
            vertices = new HashMap<String, String>();
            
            // Skips lines until the Nodes are reached
            while (!line.equals("<Nodes>")) { line = in.nextLine(); }
            
            // Skips two lines of header text in the file
            in.nextLine();
            line = in.nextLine();
            
            // Creates Vertex objects (each of which contains a symbol and an address property)
            while (!line.equals("</Nodes>")) {
                String[] s = line.split("\t");
                vertices.put(s[0], s[1]);
                line = in.nextLine();
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vertices;
	}
	
	private class SwingAction extends AbstractAction {
		// Gives the button a name and description
		public SwingAction() {
			putValue(NAME, "Time Path As Symbols");
			putValue(SHORT_DESCRIPTION, "Gets the time cost");
		}
		public void actionPerformed(ActionEvent e) {
			// Creates a new graph with the info in the textfile
			Graph test = new Graph("MapInformation.txt");
			// While the user has entered in a start and destination point
			if (!(stTxt.getText().isEmpty() && desTxt.getText().isEmpty())) {
				String first = stTxt.getText();
				String last = desTxt.getText();
				
				// set distance cost to false
				test.useDistanceCost = false;
				
				// Gets the shortest path
				Path shortest = Dijkstra.shortestPath(test, test.getVertices(test.findSymbol(first)), test.getVertices(test.findSymbol(last)));
				if (shortest == null) {
					// If null, print this
					output.setText("No Path Found!");
				} else {
					// If not null, print path
					output.setText(shortest.toString());
				}
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Distance Path As Symbols");
			putValue(SHORT_DESCRIPTION, "Gets the distance cost");
		}
		public void actionPerformed(ActionEvent e) {
			// Creates a new graph with the info in the textfile
			Graph test = new Graph("MapInformation.txt");
			// While the user has entered in a start and destination point
			if (!(stTxt.getText().isEmpty() && desTxt.getText().isEmpty())) {

				String first = stTxt.getText();
				String last = desTxt.getText();
				
				// set distance cost to true
				test.useDistanceCost = true;
				
				// Gets the shortest path
				Path shortest = Dijkstra.shortestPath(test, test.getVertices(test.findSymbol(first)), test.getVertices(test.findSymbol(last)));
				if (shortest == null) {
					// If null, print this
					output.setText("No Path Found!");
				} else {
					// If not null, print path
					output.setText(shortest.toString());
				}
			}
		}
	}
	private class SwingAction_2 extends AbstractAction {
		// For displaying path as addresses
		public SwingAction_2() {
			putValue(NAME, "Distance Path As Addresses");
			putValue(SHORT_DESCRIPTION, "Displays Path As Addresses");
		}
		public void actionPerformed(ActionEvent e) {
			// Creates a new graph with the info in the textfile
			Graph test = new Graph("MapInformation.txt");
			// While the user has entered in a start and destination point
			if (!(stTxt.getText().isEmpty() && desTxt.getText().isEmpty())) {

				String first = stTxt.getText();
				String last = desTxt.getText();

				// set distance cost to true
				test.useDistanceCost = true;

				// Gets the shortest path
				Path shortest = Dijkstra.shortestPath(test, test.getVertices(test.findSymbol(first)), test.getVertices(test.findSymbol(last)));
				if (shortest == null) {
					// If null, print this
					output.setText("No Path Found!");
				} else {
					// If not null, print path
					output.setText(shortest.addressToString(test));
				}
			}
		}
	}
	private class SwingAction_3 extends AbstractAction {
		// For displaying path as addresses
		public SwingAction_3() {
			putValue(NAME, "Time Path As Addresses");
			putValue(SHORT_DESCRIPTION, "Displays Path As Addresses");
		}
		public void actionPerformed(ActionEvent e) {
			// Creates a new graph with the info in the textfile
			Graph test = new Graph("MapInformation.txt");
			// While the user has entered in a start and destination point
			if (!(stTxt.getText().isEmpty() && desTxt.getText().isEmpty())) {

				String first = stTxt.getText();
				String last = desTxt.getText();

				// set distance cost to true
				test.useDistanceCost = false;

				// Gets the shortest path
				Path shortest = Dijkstra.shortestPath(test, test.getVertices(test.findSymbol(first)), test.getVertices(test.findSymbol(last)));
				if (shortest == null) {
					// If null, print this
					output.setText("No Path Found!");
				} else {
					// If not null, print path
					output.setText(shortest.addressToString(test));
				}
			}
		}
	}
}
