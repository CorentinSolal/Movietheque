package com.eni.bo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Genre {
	@Min(value=1, message="Should be greater than 0")
	private long id;
	@NotBlank
	@Size(min=3)
	private String label;

	@NotBlank
	public Genre() {
	}

	public Genre(long id, String label) {
		this.id = id;
		this.label = label;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return label + " [id=" + id + "]";
	}

}
