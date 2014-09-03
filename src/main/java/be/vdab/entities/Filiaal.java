package be.vdab.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="filialen")
public class Filiaal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String gemeente;

	private byte hoofdFiliaal;

	private String huisNr;

	@Temporal(TemporalType.DATE)
	private Date inGebruikName;

	private String naam;

	private int postcode;

	private String straat;

	private BigDecimal waardeGebouw;

	public Filiaal() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGemeente() {
		return this.gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	public byte getHoofdFiliaal() {
		return this.hoofdFiliaal;
	}

	public void setHoofdFiliaal(byte hoofdFiliaal) {
		this.hoofdFiliaal = hoofdFiliaal;
	}

	public String getHuisNr() {
		return this.huisNr;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public Date getInGebruikName() {
		return this.inGebruikName;
	}

	public void setInGebruikName(Date inGebruikName) {
		this.inGebruikName = inGebruikName;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getPostcode() {
		return this.postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getStraat() {
		return this.straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public BigDecimal getWaardeGebouw() {
		return this.waardeGebouw;
	}

	public void setWaardeGebouw(BigDecimal waardeGebouw) {
		this.waardeGebouw = waardeGebouw;
	}

}