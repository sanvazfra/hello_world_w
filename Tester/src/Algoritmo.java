import javax.sound.midi.Sequence;


public class Algoritmo {
	
	
	
	
	
	
	public static void main(String args[]){
		Algoritmo alg = new Algoritmo(); 
		System.out.println(alg.getLogStringQuery("    ProxyOverride    REG_SZ    192.168.3.1:3128 localhost gw11 127.0.0.0 127.0.0.1 cs100 cs200 cs300 cs400 cs500 cs600 cs700 cs900 gw13 <local>"));
		//System.out.println(alg.getLogStringQuery("    ProxyOverride    REG_SZ    <local>192.168.3.8;192.168.5.1"));
		//System.out.println(alg.getLogStringQuery("    ProxyOverride    REG_SZ    localhost;gw11;127.0.0.0;127.0.0.1;cs100;cs200;cs300;cs400;cs500;cs600;cs700;cs900;gw13;<local>"));
		//System.out.println(alg.getLogStringQuery("    ProxyOverride    REG_SZ    ;;;192.168.3.8;192.168.5.1;<local>;;;"));
	}

	public String getLogStringQuery(String logStringQuery){
		String cadena=""; //guarda cadena final
		String uno ="";//guarda subcadena anterior al signo <
		String dos = "";//guarda subcadena posterior al sigo >
		if(logStringQuery.contains("<local>")){
			cadena = logStringQuery.substring(31,logStringQuery.length()).trim();
			int x =cadena.indexOf("<");
			int y = cadena.indexOf(">");
			//extrae subcadena desde el inicio hasta un lugar anterior a <
			uno = cadena.substring(0,x); 
			//extrae cadena una posicion despues de > hasta el final de la cadena
			dos = cadena.substring((y+1),cadena.length());
			//unimos las partes para que no salga <local>
			cadena = uno + dos;
		}else{
			cadena = logStringQuery.substring(31,logStringQuery.length()).trim();
		}
		cadena = cadena.trim();
		//remplzamos los espacios en caso de haberlos por ;
		if(cadena.contains(" ")){
			cadena = cadena.replace(" ", ";");
		}
		//Eliminamos la basura al inicio y final de la cadena ";"
		for(int i=0;i<cadena.length()-1;i++){
			if(String.valueOf(cadena.charAt(cadena.length()-1)).equals(";")){
				cadena = cadena.substring(0,cadena.length()-1);
			}else if(String.valueOf(cadena.charAt(0)).equals(";")){
				cadena = cadena.substring(0+1,cadena.length());
			}else break;
		}
		return cadena;
	}

	
}
