package oo;

import java.math.RoundingMode;
import java.math.BigDecimal;
public class Restaurant {
	 private String email;
	   private String phone;
	   private int id;
	   private String nom;
	   private String link;
	   private double avis;
	   private static int nb_resto=0;
	   private double latitude;
	   private double longitude;
	   public double distance=0;


	   public int getId() {
	       return id;
	   }
	   public void setId(int id) {
	       this.id = id;
	   }
	   public String getNom() {
	       return nom;
	   }
	   public void setNom(String nom) {
	       this.nom = nom;
	   }
	   public double getAvis() {
	       return avis;
	   }

	   public void setAvis(float avis) {
	       this.avis = avis;
	   }

	   public static int getNb_resto() {
	       return nb_resto;
	   }

	   public static void setNb_resto(int nb_resto) {
		   Restaurant.nb_resto = nb_resto;
	   }

	   public double getLongitude() {
	       return longitude;
	   }

	   public double getDistance() {
	       return distance;
	   }

	   public void setDistance(double distance) {
	       this.distance = distance;
	   }

	   public void setLongitude(double longitude) {
	       this.longitude = longitude;
	   }

	   public double getLatitude() {
	       return latitude;
	   }

	   public void setLatitude(double latitude) {
	       this.latitude = latitude;
	   }

	   public Restaurant(int id, String nom,String email, double d, double latitude, double longitude ,String num,String link) {
	       this.id = id;
	       this.nom = nom;
	       this.email = email;
	       this.avis = d;
	       this.longitude = longitude;
	       this.latitude = latitude;
	       nb_resto++;
	       this.phone=num;
	       this.link=link;   }
	   

	   public String getEmail() {
	       return email;
	   }
	   public String getLink() {
	       return link;
	   }

	   public void setEmail(String email) {
	       this.email = email;
	   }

	   public String getPhone() {
	       return phone;
	   }

	   public void setPhone(String phone) {
	       this.phone = phone;
	   }

	   public double CalculationByDistance(double initialLat, double initialLong,
	                                       double finalLat, double finalLong){
	       int R = 6371; // km (Earth radius)
	       double dLat = toRadians(finalLat-initialLat);
	       double dLon = toRadians(finalLong-initialLong);
	       initialLat = toRadians(initialLat);
	       finalLat = toRadians(finalLat);

	       double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(initialLat) * Math.cos(finalLat);
	       double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	       double a1=(R * c);
	       BigDecimal a2=new BigDecimal(a1).setScale(2,RoundingMode.HALF_UP );
	       a1=a2.doubleValue();
	       return a1;
	   }
	   public double toRadians(double deg) {
	       return (deg * (Math.PI/180));
	   }

}
