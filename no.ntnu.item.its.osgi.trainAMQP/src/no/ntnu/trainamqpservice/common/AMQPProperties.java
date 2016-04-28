package no.ntnu.trainamqpservice.common;

public class AMQPProperties {
	
	private String hostname = "192.168.0.196";
	private int port = 5672;
	private String exchangename = "trainAMQPtest";
	private String username = "test";
	private String password = "test";
	
	public AMQPProperties() {
	}
	
	public AMQPProperties(String hostname){
		this.hostname = hostname;
	}
	
	public AMQPProperties(String hostname, int port){
		this(hostname);
		this.port = port;
	}
	
	public AMQPProperties(String hostname, int port, String username, String password){
		this(hostname,port);
		this.username = username;
		this.password = password;
	}
	
	public AMQPProperties(String hostname, int port, String username, String password, String exchange){
		this(hostname, port, username, password);
		this.exchangename = exchange;
	}
	

	public String getHostname() {
		return hostname;
	}

	public int getPort() {
		return port;
	}

	public String getExchangename() {
		return exchangename;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public boolean equal(AMQPProperties other){
		if(!this.hostname.equals(other.getHostname())) return false;
		if(!this.exchangename.equals(other.getExchangename())) return false;
		if(!this.username.equals(other.getUsername())) return false;
		if(!this.password.equals(other.getPassword())) return false;
		if(this.port != other.getPort()) return false;
		return true;
	}

		
}
