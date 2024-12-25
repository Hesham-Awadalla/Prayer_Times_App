import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

public class GUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCity;
	private JTextField txtCountry;
	
	DatabaseAccess dbConnection = new DatabaseAccess();
	ApiCalls apiCall = new ApiCalls();
	
	public GUI()
	{
		// Code behind the GUI
		setTitle("Prayer Times App (Demo)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 524);
		setResizable(false);
		setIconImage(new ImageIcon(this.getClass().getResource("/free mosque icon.png")).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
		setLocationRelativeTo(null);  // Centering the window
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 119, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);  // Set the absolute layout
		setContentPane(contentPane);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCity.setBounds(87, 99, 155, 20);
		contentPane.add(txtCity);
		txtCity.setColumns(10);
		
		txtCountry = new JTextField();
		txtCountry.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCountry.setBounds(86, 139, 156, 20);
		contentPane.add(txtCountry);
		txtCountry.setColumns(10);
		
		JLabel lblAppName = new JLabel("Prayer Times App");
		lblAppName.setForeground(new Color(255, 255, 255));
		lblAppName.setFont(new Font("Andalus", Font.PLAIN, 33));
		lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppName.setBounds(60, 28, 268, 40);
		contentPane.add(lblAppName);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(new Color(0, 0, 0));
		lblCity.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCity.setBounds(31, 102, 46, 14);
		contentPane.add(lblCity);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setForeground(new Color(0, 0, 0));
		lblCountry.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCountry.setBounds(31, 142, 46, 14);
		contentPane.add(lblCountry);
		
		JLabel lblFajr1 = new JLabel("Fajr");
		lblFajr1.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblFajr1.setForeground(new Color(0, 0, 0));
		lblFajr1.setBounds(87, 195, 76, 14);
		contentPane.add(lblFajr1);
		
		JLabel lblShorouq1 = new JLabel("Shorouq");
		lblShorouq1.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblShorouq1.setForeground(new Color(0, 0, 0));
		lblShorouq1.setBounds(87, 231, 76, 14);
		contentPane.add(lblShorouq1);
		
		JLabel lblDhuhr1 = new JLabel("Dhuhr");
		lblDhuhr1.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblDhuhr1.setForeground(new Color(0, 0, 0));
		lblDhuhr1.setBounds(87, 268, 76, 14);
		contentPane.add(lblDhuhr1);
		
		JLabel lblAsr1 = new JLabel("Asr");
		lblAsr1.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblAsr1.setForeground(new Color(0, 0, 0));
		lblAsr1.setBounds(87, 308, 76, 14);
		contentPane.add(lblAsr1);
		
		JLabel lblMaghrib1 = new JLabel("Maghrib");
		lblMaghrib1.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblMaghrib1.setForeground(new Color(0, 0, 0));
		lblMaghrib1.setBounds(87, 344, 76, 20);
		contentPane.add(lblMaghrib1);
		
		JLabel lblIsha1 = new JLabel("Isha'");
		lblIsha1.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblIsha1.setForeground(new Color(0, 0, 0));
		lblIsha1.setBounds(87, 384, 76, 14);
		contentPane.add(lblIsha1);
		
		JLabel lblTemp1 = new JLabel("Temperature");
		lblTemp1.setForeground(new Color(0, 0, 0));
		lblTemp1.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblTemp1.setBounds(87, 424, 115, 14);
		contentPane.add(lblTemp1);
		
		JButton btnLocateMe = new JButton("Locate me");
		btnLocateMe.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLocateMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				var currentLocation = apiCall.getCurrentLocation();
				txtCity.setText(currentLocation.getString("city"));
				txtCountry.setText(currentLocation.getString("country_name"));
			}
		});
		btnLocateMe.setBounds(261, 99, 89, 23);
		contentPane.add(btnLocateMe);
		
		JLabel lblFajr = new JLabel("");
		lblFajr.setForeground(new Color(255, 255, 255));
		lblFajr.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblFajr.setBounds(258, 195, 102, 14);
		contentPane.add(lblFajr);
		
		JLabel lblShorouq = new JLabel("");
		lblShorouq.setForeground(new Color(255, 255, 255));
		lblShorouq.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblShorouq.setBounds(258, 231, 102, 14);
		contentPane.add(lblShorouq);
		
		JLabel lblDhuhr = new JLabel("");
		lblDhuhr.setForeground(new Color(255, 255, 255));
		lblDhuhr.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblDhuhr.setBounds(258, 268, 102, 14);
		contentPane.add(lblDhuhr);
		
		JLabel lblAsr = new JLabel("");
		lblAsr.setForeground(new Color(255, 255, 255));
		lblAsr.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblAsr.setBounds(258, 308, 102, 14);
		contentPane.add(lblAsr);
		
		JLabel lblMaghrib = new JLabel("");
		lblMaghrib.setForeground(new Color(255, 255, 255));
		lblMaghrib.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblMaghrib.setBounds(258, 347, 102, 14);
		contentPane.add(lblMaghrib);
		
		JLabel lblIshaa = new JLabel("");
		lblIshaa.setForeground(new Color(255, 255, 255));
		lblIshaa.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblIshaa.setBounds(258, 384, 102, 14);
		contentPane.add(lblIshaa);
				
		JLabel lblDate = new JLabel("");
		lblDate.setForeground(new Color(192, 192, 192));
		lblDate.setFont(new Font("Arial", Font.ITALIC, 11));
		lblDate.setBounds(7, 467, 247, 15);
		contentPane.add(lblDate);
		
		JLabel lblTemp = new JLabel("");
		lblTemp.setForeground(new Color(255, 255, 255));
		lblTemp.setFont(new Font("Andalus", Font.PLAIN, 17));
		lblTemp.setBounds(258, 424, 102, 14);
		contentPane.add(lblTemp);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				if (!txtCity.getText().isBlank() && !txtCountry.getText().isBlank())
				{
					try {
						String[] coordinates = dbConnection.connectDB(txtCity.getText().strip(), txtCountry.getText().strip());
						
						var prayerTimes = apiCall.getPrayerTimes(coordinates[0], coordinates[1]);
						
						//Print the prayer times & the temperature on the GUI
						lblFajr.setText(prayerTimes.getString("Fajr"));
						lblShorouq.setText(prayerTimes.getString("Sunrise"));
						lblDhuhr.setText(prayerTimes.getString("Dhuhr"));
						lblAsr.setText(prayerTimes.getString("Asr"));
						lblMaghrib.setText(prayerTimes.getString("Maghrib"));
						lblIshaa.setText(prayerTimes.getString("Isha"));
						lblTemp.setText(apiCall.getTemperature(coordinates[0], coordinates[1]) + " C");
						lblDate.setText(java.time.chrono.HijrahDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " AH  " + new SimpleDateFormat("dd-MM-yyyy  HH:MM").format(Calendar.getInstance().getTime()));
					} 
					catch (JSONException e1) 
					{
						e1.printStackTrace();
					}

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please, specify the city/country!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(261, 139, 89, 23);
		contentPane.add(btnSearch);
	}
}
