package com.tw.training.wms.service;

import com.tw.training.wms.domain.GoodsStock;
import com.tw.training.wms.repository.GoodsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tw.training.wms.repository.GoodsStockRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GoodsStockService {
    static final Logger logger = LoggerFactory.getLogger(GoodsStockService.class);

    @Autowired
    GoodsStockRepository goodsStockRepository;

    @Autowired
    GoodsRepository goodsRepository;

    public GoodsStock create(GoodsStock goodsStock) {
        logger.info("创建商品库存{},{}：", goodsStock.getGoodsId(), goodsStock.getStockCount());
        return goodsStockRepository.save(goodsStock);
    }

    public Optional<GoodsStock> queryGoodsStock(Long goodsId) {
        return goodsStockRepository.findById(goodsId);
    }

    public Optional<GoodsStock> subStock(Long goodsId, Integer number) {
        Optional<GoodsStock> goodsStock = goodsStockRepository.findById(goodsId);

        return goodsStock.flatMap(gs -> {
            gs.setStockCount(gs.getStockCount() - number);
            GoodsStock updatedGoodsStock = goodsStockRepository.save(gs);
            logger.info("编号为：{}的商品库存扣减{}件", goodsId, number);
            return Optional.of(updatedGoodsStock);
        });
    }

    @Transactional
    public Optional<GoodsStock> addStock(Long goodsId, Integer number) {
        Optional<GoodsStock> goodsStock = goodsStockRepository.findById(goodsId);

        return goodsStock.flatMap(gs -> {
            gs.setStockCount(gs.getStockCount() + number);
            GoodsStock updatedGoodsStock = goodsStockRepository.save(gs);
            logger.info("编号为：{}的商品库存增加{}件", goodsId, number);
            return Optional.of(updatedGoodsStock);
        });
    }
}
