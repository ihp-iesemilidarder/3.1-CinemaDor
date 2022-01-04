package com.cinema.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author evaldivia
 */
public class Film implements Serializable {
	private static final long serialVersionUID = 6116144376715379942L;
	
	private Integer id;
    private String nom;
    private String sinopsi;
    private String caratula; // Camí on es troba la foto
    private Genere genere; // FICCIO, TERROR, AVENTURES, DIBUIXOS
    private Integer edatRec = 0; // Edat recomanada.0 Per tots els publics
    private LocalDate dataEstreno;
    private Boolean estreno = false;
    private List<Session> horari = new ArrayList<>();
    private double duration;
    private Boolean club;
    private int director;

    public Film(Integer id, String nom, String sinopsi) {
        this.id = id;
        this.nom = nom;
        this.sinopsi = sinopsi;
    }
    
    public Film(Integer id, String nom, String sinopsi,double duration) {
        this.id = id;
        this.nom = nom;
        this.sinopsi = sinopsi;
        this.duration = duration;
    }
    public Film(Integer id, String nom, String sinopsi,int director) {
        this.id = id;
        this.nom = nom;
        this.sinopsi = sinopsi;
        this.director = director;
    }

    public Film(Integer id, String nom, String sinopsi,double duration, int director) {
        this.id = id;
        this.nom = nom;
        this.sinopsi = sinopsi;
        this.duration = duration;
        this.director = director;
    }
    
    public Film(Integer id, String nom, String sinopsi, String caratula, Integer edatRec, Genere genere, LocalDate dataEstreno, Boolean estreno, double duration) {
        this.id = id;
        this.nom = nom;
        this.sinopsi = sinopsi;
        this.caratula = caratula;
        this.genere = genere;
        this.dataEstreno = dataEstreno;
        this.estreno = estreno;
        this.edatRec=edatRec;
        this.duration = duration;
    }
    
    public Film(Integer id, String nom, String sinopsi, String caratula, Integer edatRec, Genere genere, LocalDate dataEstreno, Boolean estreno) {
        this.id = id;
        this.nom = nom;
        this.sinopsi = sinopsi;
        this.caratula = caratula;
        this.genere = genere;
        this.dataEstreno = dataEstreno;
        this.estreno = estreno;
        this.edatRec=edatRec;
    }

    public Film(Integer id, String nom, String sinopsi, String caratula, Integer edatRec, Genere genere, LocalDate dataEstreno, Boolean estreno, double duration, int director) {
        this.id = id;
        this.nom = nom;
        this.sinopsi = sinopsi;
        this.caratula = caratula;
        this.genere = genere;
        this.dataEstreno = dataEstreno;
        this.estreno = estreno;
        this.edatRec=edatRec;
        this.duration = duration;
        this.director = director;
    }
    
    public Film(Integer id, String nom, String sinopsi, String caratula, Integer edatRec, Genere genere, LocalDate dataEstreno, Boolean estreno, int director) {
        this.id = id;
        this.nom = nom;
        this.sinopsi = sinopsi;
        this.caratula = caratula;
        this.genere = genere;
        this.dataEstreno = dataEstreno;
        this.estreno = estreno;
        this.edatRec=edatRec;
        this.director = director;
    }
    

    public Boolean getClub() {
		return club;
	}

	public void setClub(Boolean club) {
		this.club = club;
	}

	public int getDirector() {
		return director;
	}

	public void setDirector(int director) {
		this.director = director;
	}

	public Boolean getEstreno() {
        return estreno;
    }

    public void setEstreno(Boolean estreno) {
        this.estreno = estreno;
    }
    
    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSinopsi() {
        return sinopsi;
    }
    
    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
    public void setSinopsi(String sinopsi) {
        this.sinopsi = sinopsi;
    }

    public List<Session> getHorari() {
		return horari;
	}

	public void setHorari(List<Session> horari) {
		this.horari = horari;
	}

	public LocalDate getDataEstreno() {
        return dataEstreno;
    }

    public void setDataEstreno(LocalDate dataEstreno) {
        this.dataEstreno = dataEstreno;
    }
    
    public Integer getEdatRec() {
        return edatRec;
    }

    public void setEdatRec(Integer edatRec) {
        this.edatRec = edatRec;
    }
    
    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", nom=" + nom + ", sinopsi=" + sinopsi + ", caratula=" + caratula + ", genere="
				+ genere + ", edatRec=" + edatRec + ", dataEstreno=" + dataEstreno + ", estreno=" + estreno
				+ ", horari=" + horari + ", duration=" + duration + ", club=" + club + ", director=" + director + "]";
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	} 
	
}
