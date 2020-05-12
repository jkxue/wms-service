package com.tw.training.wms.repository;

import com.tw.training.wms.domain.GoodsStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsStockRepository extends JpaRepository<GoodsStock, Long> {
}