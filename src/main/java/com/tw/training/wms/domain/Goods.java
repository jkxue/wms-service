package com.tw.training.wms.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_goods")
public class Goods implements Serializable {
	private static final long serialVersionUID = -2485043500570220983L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
