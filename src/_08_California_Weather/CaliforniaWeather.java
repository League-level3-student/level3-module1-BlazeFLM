package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a temperature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fontana, Glendale, Escondido, Del Mar, ...
 * 		
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton cityButton = new JButton("Search for a city");
	JButton weatherButton = new JButton("Specify a weather condition");
	JButton tempButton = new JButton("Search by min and max temperatures");
	JTextField field = new JTextField(20);

	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

	void start() {

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(cityButton);
		panel.add(weatherButton);
		panel.add(tempButton);
		panel.add(field);
		weatherButton.addActionListener(this);
		cityButton.addActionListener(this);
		tempButton.addActionListener(this);
		frame.add(panel);
		frame.pack();

		// All city keys have the first letter capitalized of each word
		String cityName = Utilities.capitalizeWords("National City");
		WeatherData datum = weatherData.get(cityName);

		if (datum == null) {
			System.out.println("Unable to find weather data for: " + cityName);
		} else {
			System.out.println(
					cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String input = field.getText();
		if(input == null || input.equals("")) {
			return;
		}
		input = Utilities.capitalizeWords(input);
		if (e.getSource() == cityButton) {
			
			WeatherData data = weatherData.get(input);

			if (data == null) {
				JOptionPane.showMessageDialog(null, "Unable to find weather data for :" + input);
			} else {
				JOptionPane.showMessageDialog(null, input + " is " + data.weatherSummary + " with a temp of " + data.temperatureF + " F");
			}
		}

		if (e.getSource() == weatherButton) {
			String weather = "";
			for (String w : weatherData.keySet()) {
				if(weatherData.get(w).weatherSummary.equalsIgnoreCase(input)) {
					weather += w + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, weather);
		}
		
		if(e.getSource() == tempButton) {
			String weather = "";
			String[] values = input.split(",");
			float min = Float.parseFloat(values[0]);
			float max = Float.parseFloat(values[1]);
			for(String w : weatherData.keySet()) {
				if(weatherData.get(w).temperatureF < max && weatherData.get(w).temperatureF > min) {
					weather += w + " " + weatherData.get(w).temperatureF + " " + weatherData.get(w).weatherSummary + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, weather);
		}

	}
}
