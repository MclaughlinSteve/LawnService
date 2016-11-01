package model;

import java.io.Serializable;


public class Position implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6729254942731603971L;
	private double latitude;
	private double longitude;
	
	public Position() {
		latitude = 0.0;
		longitude = 0.0;
	}
	
	public Position(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Position [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	

}
