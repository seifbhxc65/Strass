package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oo.Restaurant;
import java.sql.*;

public class RestaurantBD {
    public ObservableList<Restaurant> getResto() {
        ObservableList<Restaurant> resto = FXCollections.observableArrayList();
    Connection c = ConnexionBD.getConnection();
        if (c != null){
            try {
                PreparedStatement ps=c.prepareStatement("SELECT * FROM `restaurant`;");
                ResultSet r = ps.executeQuery();
                while(r.next()){
                    resto.add(new Restaurant(r.getInt("id"),r.getString("nom"),r.getString("email"),Float.parseFloat(r.getString("avis")),Double.parseDouble(r.getString("latitude")),Double.parseDouble(r.getString("longitude")),r.getString("phone"),r.getString("link")));
                }
            } catch (SQLException e) { e.printStackTrace(); }
        }
        return resto;
    }
   public void delete(int Idselected){
        Connection c = ConnexionBD.getConnection();
        ObservableList< Restaurant> datalist = FXCollections.observableArrayList();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement("DELETE FROM restaurant WHERE id = ?");
                ps.setString(1,String.valueOf(Idselected));
                ps.executeUpdate();
            } catch (SQLException e){ e.printStackTrace(); }

        }
          }
   public void ajout(String nom,String email,double avis,String numtel,double lat,double lon,String link){
       Connection c = ConnexionBD.getConnection();
     //  ObservableList< Restaurant> datalist = FXCollections.observableArrayList();
       if (c != null) {
           try {
               Statement st=c.createStatement();
               String req="INSERT INTO `restaurant` (`id`, `nom`, `email`, `phone`, `avis`, `latitude`, `longitude`, `link`) VALUES (NULL,'"+ nom +"', '"+email+"', '"+numtel+"', '"+avis+"', '"+lat+"', '"+lon+"','"+link+"');";//35.81,1063
               int nbr=st.executeUpdate(req);
               if(nbr>0) {
            	   System.out.println("sucess");
               }
           } catch (SQLException e){ e.printStackTrace(); }

       }
         }
}




