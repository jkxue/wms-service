package com.tw.training.wms.controller;

import com.tw.training.wms.WmsServiceApplication;
import com.tw.training.wms.service.GoodsStockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wms")
public class WmsController {
	static Logger logger = LoggerFactory.getLogger(WmsServiceApplication.class);

	@Autowired
	GoodsStockService goodsStockService;

	// 减库存
	@PostMapping("/subStock/{goodsId}")
	public String subStock(@PathVariable("goodsId") long goodsId) {
		goodsStockService.subStock(goodsId);
		logger.info("GoodsId: {} subStock 1", goodsId);
		return "success";
	}
}