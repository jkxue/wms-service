package com.tw.training.wms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_goods_stock")
public class GoodsStock implements Serializable {
	private static final long serialVersionUID = -2485043500570220853L;

	@Id
	@GeneratedValue
	@Column(name = "goods_id")
	private Long goodsId;

	@Column(name = "stock_count")
	private int stockCount;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

}
