import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class ApiCalls
{
	
	public JSONObject getPrayerTimes(String latitude, String longitude)
	{
		String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(STR."https://api.aladhan.com/v1/timings/\{currentDate}?latitude=\{latitude}&longitude=\{longitude}"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		HttpResponse<String> response = null;
		
		try 
		{
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		} 
		catch (InterruptedException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		}

		JSONObject responseJSON = new JSONObject(response.body());
	
		JSONObject data = (JSONObject) responseJSON.get("data");
		
		JSONObject prayerTimes = (JSONObject) data.get("timings");
		
		return prayerTimes;
	}
	

	public String getTemperature(String latitude, String longitude)
	{
		String key = "********************";
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(STR."http://api.weatherapi.com/v1/current.json?Key=\{key}&q=\{latitude},\{longitude}"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		HttpResponse<String> response = null;
		
		try 
		{
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		} 
		catch (InterruptedException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		}

		JSONObject responseJSON = new JSONObject(response.body());
	
		JSONObject currentData = (JSONObject) responseJSON.get("current");
		
		return currentData.get("temp_c").toString();
	}
	

	public JSONObject getCurrentLocation()
	{
		String key = "**********************";
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(STR."https://api.ipgeolocation.io/ipgeo?apiKey=\{key}"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		HttpResponse<String> response = null;
		
		try 
		{
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		} 
		catch (InterruptedException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		}

		JSONObject currentLocation = new JSONObject(response.body());
		
		return currentLocation;
	}
}
