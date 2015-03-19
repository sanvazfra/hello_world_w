import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;



public class AlgoritmoNetworks {
	static ArrayList<String> conexionesList = new ArrayList<String>();
	String mensaje = "";
	
	public ArrayList<String> get() {
		String s = null;
		int index = 0;
		
		try {
			Process p = Runtime.getRuntime().exec(
					"netsh wlan show networks interface=\"Wi-Fi\"");

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(
					p.getErrorStream()));

			while ((s = stdInput.readLine()) != null) {
				if (index != 0 && index != 1 && index != 2 && s.length() != 0) {
					//instance.separaConexiones(s/*, index*/);
					//System.out.println(s.toString());
					if(s.contains("SSID")){
						conexionesList.add(s.substring(9,s.length()).length() == 0 ? "Red oculta" : s.substring(9,s.length()));
					}
				}
				index++;
			}
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return conexionesList;
	}
	
	public static void main(String[] args) {
		AlgoritmoNetworks an = new AlgoritmoNetworks();
		ArrayList<String> returList  = an.get();
		Iterator<String> i = returList.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
