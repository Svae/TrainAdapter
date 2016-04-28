package no.ntnu.item.its.osgi.train.adapter.handlers.common.readings;

public class NFCReading {

	private String hex;
	
	public NFCReading(String hex) {
		this.hex = hex;
	}
	
	public String getReading(){
		return hex;
	}
}
