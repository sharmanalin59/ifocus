package org.domain;
/**
 * @author : nalin sharma
 *
 */
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hike database table.
 * 
 */
@Entity
@Table(name="hike")
@NamedQuery(name="Hike.findAll", query="SELECT h FROM Hike h")
public class Hike implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hike_id")
	private int hikeId;

	@Column(name="default_hike_percentage")
	private float defaultHikePercentage;

	@Column(name="max_experience")
	private float maxExperience;

	@Column(name="mix_experience")
	private String mixExperience;

	private byte rating;

	public Hike() {
	}

	public int getHikeId() {
		return this.hikeId;
	}

	public void setHikeId(int hikeId) {
		this.hikeId = hikeId;
	}

	public float getDefaultHikePercentage() {
		return this.defaultHikePercentage;
	}

	public void setDefaultHikePercentage(float defaultHikePercentage) {
		this.defaultHikePercentage = defaultHikePercentage;
	}

	public float getMaxExperience() {
		return this.maxExperience;
	}

	public void setMaxExperience(float maxExperience) {
		this.maxExperience = maxExperience;
	}

	public String getMixExperience() {
		return this.mixExperience;
	}

	public void setMixExperience(String mixExperience) {
		this.mixExperience = mixExperience;
	}

	public byte getRating() {
		return this.rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

}