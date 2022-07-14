package com.tw.training.wms.controller;

import com.tw.training.wms.WmsServiceApplication;
import com.tw.training.wms.domain.GoodsStock;
import com.tw.training.wms.service.GoodsStockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/wms")
public class WmsController {
    static Logger logger = LoggerFactory.getLogger(WmsServiceApplication.class);

    @Resource
    GoodsStockService goodsStockService;

    @PostMapping("/goods-stock")
    public ResponseEntity<GoodsStock> create(@RequestBody GoodsStock goodsStock) {
        GoodsStock savedGoodsStock = goodsStockService.create(goodsStock);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGoodsStock);
    }

    @GetMapping("/goods-stock/{goodsId}")
    public ResponseEntity<GoodsStock> queryGoodsStock(@PathVariable("goodsId") Long goodsId) {
        Optional<GoodsStock> goodsStock = goodsStockService.queryGoodsStock(goodsId);
        return goodsStock.map(ResponseEntity.status(HttpStatus.OK)::body).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/goods-stock/{goodsId}/sub-stock")
    public ResponseEntity<GoodsStock> subStock(@PathVariable("goodsId") Long goodsId, @RequestParam(value = "number") Integer number) {
        logger.info("GoodsId: {} subStock {}", goodsId, number);
        Optional<GoodsStock> goodsStock = goodsStockService.subStock(goodsId, number);
        return goodsStock.map(ResponseEntity.status(HttpStatus.OK)::body).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/goods-stock/{goodsId}/add-stock")
    public ResponseEntity<GoodsStock> addStock(@PathVariable("goodsId") Long goodsId, @RequestParam(value = "number") Integer number) {
        logger.info("GoodsId: {} addStock {}", goodsId, number);
        Optional<GoodsStock> goodsStock = goodsStockService.addStock(goodsId, number);
        return goodsStock.map(ResponseEntity.status(HttpStatus.OK)::body).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}