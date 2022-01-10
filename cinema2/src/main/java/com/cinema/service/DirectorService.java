package com.cinema.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cinema.bd.BDConnectionMySQL;
import com.cinema.dto.Director;
import com.cinema.dto.Film;
import com.cinema.dto.Genere;
import com.cinema.dto.Session;

public class DirectorService {
	

	public DirectorService() {}

	// LListat de pel·lícules
	public List<Director> getListDirectors() {
        
		BDConnectionMySQL bd = new BDConnectionMySQL();
        List<Director> list = new ArrayList<>();
        try {
        	String query = "select * from director";            
            Connection connexio = bd.getConnection();
            Statement sentencia = connexio.createStatement();
            ResultSet resultat  = sentencia.executeQuery(query);
                  
            if (resultat!=null) {
	            while (resultat.next()) {
					int id = resultat.getInt("DIR_ID");
					String name = resultat.getString("DIR_NAME");
					String surname = resultat.getString("DIR_SURNAME");
					
					Director director = new Director( Integer.valueOf(id), 
												   name,
												   surname);
					System.out.println( director.toString() );
					list.add(director);
	            }
            }
            sentencia.close();
            connexio.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
        
    }
	
	// Llista filtrada per genere
	public Director getListDirectors(Integer idDirector) {
		
		BDConnectionMySQL bd = new BDConnectionMySQL();
		Director director = null;
		try {
			String query = "select * from director";
			if (idDirector!=null) {
				query = "SELECT * FROM director WHERE DIR_ID = ?";
			}          
			Connection connexio = bd.getConnection();
			PreparedStatement sentencia= connexio.prepareStatement(query);
			// Configuram el pàrametre d'entrada gènere
			if (idDirector!=null) {
				sentencia.setString(1, idDirector.toString());
			}
			ResultSet resultat  = sentencia.executeQuery();
			if (resultat!=null) {
				while (resultat.next()) {
					int id = resultat.getInt("DIR_ID");
					String name = resultat.getString("DIR_NAME");
					String surname = resultat.getString("DIR_SURNAME");
					
					director = new Director( Integer.valueOf(id), 
												   name,
												   surname); 
					
					System.out.println( director.toString() );
				}
			}
			sentencia.close();
			connexio.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return director;
	}

	public List<Film> getListFilmsbyTitle(String titleFilter) {
		
		BDConnectionMySQL bd = new BDConnectionMySQL();
		List<Film> list = new ArrayList<>();
		try {
			String query = "select * from film";
			if (titleFilter!=null) {
				query = "SELECT * FROM film WHERE flm_title LIKE ?";
			}          
			Connection connexio = bd.getConnection();
			PreparedStatement sentencia= connexio.prepareStatement(query);
			// Configuram el pàrametre d'entrada gènere
			if (titleFilter!=null) {
				sentencia.setString(1, "%"+titleFilter.toString()+"%");
			}
			ResultSet resultat  = sentencia.executeQuery();
			if (resultat!=null) {
				while (resultat.next()) {
					int id = resultat.getInt("flm_id");
					String title = resultat.getString("flm_title");
					String synopsis = resultat.getString("flm_synopsis"); 
					String cover = resultat.getString("flm_cover"); 
					String genre = resultat.getString("flm_genre"); 
					Integer age_rating = resultat.getInt("flm_age_rating");							
					Date release = resultat.getDate("flm_date_release");
					Boolean premiere = resultat.getBoolean("flm_premiere");
					double duration = resultat.getDouble("flm_duration");
					
					Film peli = new Film( Integer.valueOf(id), 
												   title, 
												   synopsis, 
												   cover, 
												   age_rating, 
												   Genere.valueOf(genre), 
												   convertToLocalDate(release), 
												   premiere,
												   duration); 
					
					System.out.println( peli.toString() );
					list.add(peli);
				}
			}
			sentencia.close();
			connexio.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	
	// Llista de sessions d'una pel·lícula
	public List<Session> getListSessions(int idFilm) {
		
		BDConnectionMySQL bd = new BDConnectionMySQL();
		List<Session> list = new ArrayList<>();
		try {
			String query = "SELECT * FROM session WHERE ses_id_film = ?";  
			Connection connexio = bd.getConnection();
			PreparedStatement sentencia= connexio.prepareStatement(query);
			// Configuram el pàrametre d'entrada
			sentencia.setInt(1, idFilm);

			ResultSet resultat  = sentencia.executeQuery();
			
			if (resultat!=null) {
				while (resultat.next()) {
					int id = resultat.getInt("ses_id_film");
					String hora_inici = resultat.getString("ses_hour_ini");
					String hora_fi = resultat.getString("ses_hour_end"); 
					int butacas = resultat.getInt("ses_club_armchair");
					Session session = new Session( id, hora_inici, hora_fi,butacas); 
					System.out.println( session.toString() );
					list.add(session);
					
				}
			}
			sentencia.close();
			connexio.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	// Llista filtrada per genere
	public List<Film> getListFilmsInsegura(Genere gen) {
		
		BDConnectionMySQL bd = new BDConnectionMySQL();
		List<Film> list = new ArrayList<>();
		try {
			String query = "select * from film where flm_genre='"+ gen.toString() +"'";            
			Connection connexio = bd.getConnection();
			Statement sentencia = connexio.createStatement();
			ResultSet resultat  = sentencia.executeQuery(query);
			
			if (resultat!=null) {
				while (resultat.next()) {
					int id = resultat.getInt("id");
					String title = resultat.getString("title");                
					list.add(new Film( Integer.valueOf(id), title, ""));
				}
			}
			sentencia.close();
			connexio.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	// Recupera una pel·lícula
	public Film getFilm(int filtreId) {
		
		BDConnectionMySQL bd = new BDConnectionMySQL();
		Film peli = null;
		try {
			String query = "SELECT * FROM film WHERE flm_id = ?";        
			Connection connexio = bd.getConnection();
			PreparedStatement sentencia= connexio.prepareStatement(query);
			
			// Configuram el pàrametre d'entrada gènere
			sentencia.setInt(1, filtreId);
	
			ResultSet resultat  = sentencia.executeQuery();
			
			if (resultat!=null) {
				resultat.next();
				int id = resultat.getInt("flm_id");
				String title = resultat.getString("flm_title");
				String synopsis = resultat.getString("flm_synopsis"); 
				String cover = resultat.getString("flm_cover"); 
				String genre = resultat.getString("flm_genre"); 
				Integer age_rating = resultat.getInt("flm_age_rating");							
				Date release = resultat.getDate("flm_date_release");
				Boolean premiere = resultat.getBoolean("flm_premiere");
				double duration = resultat.getDouble("flm_duration");
				peli = new Film( Integer.valueOf(id), 
											   title, 
											   synopsis, 
											   cover, 
											   age_rating, 
											   Genere.valueOf(genre), 
											   convertToLocalDate(release), 
											   premiere,
											   duration); 
				
				// Recuperam l'horari de la pel·lícula de la BD
				List<Session> horari = getListSessions(id);
				peli.setHorari(horari);
				
			}
			sentencia.close();
			connexio.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return peli;
	}
	
	private LocalDate convertToLocalDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
}
