package com.tw.training.wms.service;

import com.tw.training.wms.domain.GoodsStock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tw.training.wms.repository.GoodsStockRepository;

@Component
public class GoodsStockService {
	static final Logger logger = LoggerFactory.getLogger(GoodsStockService.class);

	@Autowired
	GoodsStockRepository goodsStockRepository;

	public void subStock(long goodsId) {
		GoodsStock goodsStock = goodsStockRepository.findOne(goodsId);
		goodsStock.setStockCount(goodsStock.getStockCount()-1);
		goodsStockRepository.save(goodsStock);
		logger.debug("编号为：{}的商品库存减1", goodsId);
	}
}
