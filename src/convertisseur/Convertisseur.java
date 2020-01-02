/*
 * This is my very first java swing real project
 * The project is a little program/software that can convert units(Mass,length,temperature)
 * This is the very first version,it's not really perfect but I will make it as perfect as I can in the close future
 * For any questions or upgrade please contact me : arbani.oumy@gmail.com
 * Created by Oumaima Arbani 9/27/2019
 * In code we trust
 * */
package convertisseur;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;




public class Convertisseur extends JFrame implements ItemListener,KeyListener{

	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final JComboBox<String> units;
	private JComboBox<String> fromUnit;
	private JComboBox<String> toUnit;
	private final JTextField originalValue,convertedValue;
	private final String[] unitsArray = {"Mass","Length","Temperature"};
	private final String[] measureUnitsForLength = {"Inch","Foot","Yard","Millimeter","Centimeter","Kilometer","Meter"};
	private final String[] measureUnitsForMass = {"Ounce","Pound","Milligram","Gram","Kilogram"};
	private final String[] measureUnitsForTemperature = {"Celsius","Kelvin","Fahrenheit"};
	
	
	public Convertisseur() throws HeadlessException {
		super();
		
		units = new JComboBox<String>(unitsArray);
		fromUnit = new JComboBox<String>(measureUnitsForMass);
		toUnit = new JComboBox<String>(measureUnitsForMass);
		originalValue = new JTextField("0",20);
		convertedValue = new JTextField("0",20);
		originalValue.setToolTipText("Value to convert");
		convertedValue.setToolTipText("Converted Value");
		/*
		 * Positioning
		 * */
		this.setTitle("Convertisseur");
		this.setLayout(new FlowLayout());
		this.setSize(424, 181);
		this.setResizable(false);
		this.setVisible(true);
		
		add(units,BorderLayout.NORTH);
		add(originalValue,BorderLayout.WEST);
		add(fromUnit,BorderLayout.EAST);
		add(convertedValue,BorderLayout.WEST);	
		add(toUnit,BorderLayout.EAST);
		
		/*
		 * Listners
		 * */
		units.addItemListener(this);
		originalValue.addKeyListener(this);
	}
	
	
	@Override
	/*
	 * This method is for changing the values in the combobox based on the wanted convertion 
	 */
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getStateChange()==ItemEvent.SELECTED) {
			if (units.getSelectedItem().toString().equals("Mass")) {
				fromUnit.removeAllItems();
				toUnit.removeAllItems();
				DefaultComboBoxModel<String> cbmFrom = new DefaultComboBoxModel<String>(measureUnitsForMass);
				DefaultComboBoxModel<String> cbmTo = new DefaultComboBoxModel<String>(measureUnitsForMass);
				fromUnit.setModel(cbmFrom);
				toUnit.setModel(cbmTo);
			}
			else if (units.getSelectedItem().toString().equals("Length")) {
				fromUnit.removeAllItems();
				toUnit.removeAllItems();
				DefaultComboBoxModel<String> cbmFrom = new DefaultComboBoxModel<String>(measureUnitsForLength);
				DefaultComboBoxModel<String> cbmTo = new DefaultComboBoxModel<String>(measureUnitsForLength);
				fromUnit.setModel(cbmFrom);
				toUnit.setModel(cbmTo);
			}
			else if (units.getSelectedItem().toString().equals("Temperature")) {
				fromUnit.removeAllItems();
				toUnit.removeAllItems();
				DefaultComboBoxModel<String> cbmFrom = new DefaultComboBoxModel<String>(measureUnitsForTemperature);
				DefaultComboBoxModel<String> cbmTo = new DefaultComboBoxModel<String>(measureUnitsForTemperature);
				fromUnit.setModel(cbmFrom);
				toUnit.setModel(cbmTo);
			}
			originalValue.setText("0");
			convertedValue.setText("0");
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (originalValue.getText()!="") {
			convertedValue.setText(String.valueOf(UnitConverter()));
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (originalValue.getText()!="") {
			convertedValue.setText(String.valueOf(UnitConverter()));
		}
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!(Character.isDigit(c) || c=='.'|| c=='e') ) {
			e.consume();
		}
				
	}
	/*This method if for converting*/
	public double UnitConverter() {
		double value = (originalValue!=null && originalValue.getText() !=null && !originalValue.getText().equals("")) ? Double.parseDouble(originalValue.getText()) : 0;
		double result = 0;
		String selectedFrom = (String) fromUnit.getSelectedItem();
		String selectedTo = (String) toUnit.getSelectedItem();
		if(selectedFrom==selectedTo) {
			result = value;
		}
		/*
		 * If the user has selected the mass
		 * */
		if(units.getSelectedItem().toString().equals("Mass")){              
			
			if (selectedFrom=="Ounce") {
				switch (selectedTo) {
				case "Pound":
					result = value/16;
					break;
				case "Milligram":
					result = value*28349.523;
					break;
				case "Gram":
					result = value*28.35;
					break;
				case "Kilogram":
					result = value/35.274;
					break;

				default:
					break;
				}
			}
			else if (selectedFrom == "Pound") {
				switch (selectedTo) {
				case "Ounce":
					result = value*16;
					break;
				case "Milligram":
					result = value*453592.37;
					break;
				case "Gram":
					result = value*453.592;
					break;
				case "Kilogram":
					result = value/2.205;
					break;

				default:
					break;
				}
				
			}
			else if (selectedFrom == "Milligram") {
				switch (selectedTo) {
				case "Ounce":
					result = value/28349.523;
					break;
				case "Pound":
					result = value/453592.37;
					break;
				case "Gram":
					result = value*1000;
					break;
				case "Kilogram":
					result = value*1e+6;
					break;
			}
		}
			else if (selectedFrom == "Gram") {
				switch (selectedTo) {
				case "Ounce":
					result = value/28.35;
					break;
				case "Pound":
					result = value/453.592;
					break;
				case "Milligram":
					result = value*1000;
					break;
				case "Kilogram":
					result = value/1000;
					break;
				}
			}
				else if (selectedFrom == "Kilogram") {
					switch (selectedTo) {
					case "Ounce":
						result = value*35.274;
						break;
					case "Pound":
						result = value*2.205;
						break;
					case "Milligram":
						result = value*1e+6;
						break;
					case "Gram":
						result = value*1000;
						break;
					}
				}
		}
		
		
		/***************************************
		 * If the user has selected the temperature
		 * **************************************/
		else if(units.getSelectedItem().toString().equals("Temperature")){              
			if (selectedFrom=="Celsius") {
				switch (selectedTo) {
				case "Kelvin":
					result = value+273.15;
					break;
				case "Fahrenheit":
					result = (value*9/5)+32;
					break;
				}
			}
			else if (selectedFrom == "Kelvin") {
				switch (selectedTo) {
				case "Celsius":
					result = value-273.15;
					break;
				case "Fahrenheit":
					result = ((value-273.15)*9/5)+32;
					break;
				}
				
			}
			else if (selectedFrom == "Fahrenheit") {
				switch (selectedTo) {
				case "Celsius":
					result = (value-32)*(5/9);
					break;
				case "Kelvin":
					result = (value-32)*(5/9)+273.15;
					break;
				}
			}
		}
		
		/***************************************
		 * 
		 * If the user has selected the length
		 * 
		 * **************************************/
		
		else if(units.getSelectedItem().toString().equals("Length")){              
			
			if (selectedFrom=="Inch") {
				switch (selectedTo) {
				case "Foot":
					result = value/12;
					break;
				case "Yard":
					result = value/36;
					break;
				case "Millimeter":
					result = value*25.4;
					break;
				case "Centimeter":
					result = value*2.54;
					break;
				case "Meter":
					result = value/39.37;
					break;
				case "Kilometer":
					result = value/39370.079;
					break;
				}
			}
			else if (selectedFrom == "Foot") {
				switch (selectedTo) {
				case "Inch":
					result = value*12;
					break;
				case "Yard":
					result = value/3;
					break;
				case "Millimeter":
					result = value*304.8;
					break;
				case "Centimeter":
					result = value*30.48;
					break;
				case "Meter":
					result = value/3.281;
					break;
				case "Kilometer":
					result = value/3280.84;
					break;
				}
				
			}
			else if (selectedFrom == "Yard") {
				switch (selectedTo) {
				case "Foot":
					result = value*3;
					break;
				case "Inch":
					result = value*36;
					break;
				case "Millimeter":
					result = value*914.4;
					break;
				case "Centimeter":
					result = value*91.44;
					break;
				case "Meter":
					result = value/1.094;
					break;
				case "Kilometer":
					result = value/1093.613;
					break;
			}
		}
			else if (selectedFrom == "Millimeter") {
				switch (selectedTo) {
				case "Foot":
					result = value/304.8;
					break;
				case "Yard":
					result = value/914.4;
					break;
				case "Inch":
					result = value/25.4;
					break;
				case "Centimeter":
					result = value/10;
					break;
				case "Meter":
					result = value/1000;
					break;
				case "Kilometer":
					result = value/1e+6;
					break;
				}
			}
				else if (selectedFrom == "Centimeter") {
					switch (selectedTo) {
					case "Foot":
						result = value/30.48;
						break;
					case "Yard":
						result = value/91.44;
						break;
					case "Millimeter":
						result = value*10;
						break;
					case "Inch":
						result = value/2.54;
						break;
					case "Meter":
						result = value/100;
						break;
					case "Kilometer":
						result = value/100000;
						break;
					}
				}
				else if (selectedFrom == "Meter") {
					switch (selectedTo) {
					case "Foot":
						result = value*3.281;
						break;
					case "Yard":
						result = value*1.094;
						break;
					case "Millimeter":
						result = value*1000;
						break;
					case "Inch":
						result = value*39.37;
						break;
					case "Centimeter":
						result = value*100;
						break;
					case "Kilometer":
						result = value/1000;
						break;
					}
				}
				else if (selectedFrom == "Kilometer") {
					switch (selectedTo) {
					case "Foot":
						result = value*3280.84;
						break;
					case "Yard":
						result = value*1093.613;
						break;
					case "Millimeter":
						result = value*1e+6;
						break;
					case "Inch":
						result = value*39370.079;
						break;
					case "Centimeter":
						result = value*10000;
						break;
					case "Meter":
						result = value*1000;
						break;
					}
				}
		}
		return result;
		
	}
	
}
