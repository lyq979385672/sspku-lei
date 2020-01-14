package com.lyq.service;

import com.lyq.bean.PmsBaseCatalog1;
import com.lyq.bean.PmsBaseCatalog2;
import com.lyq.bean.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {
    String test();

    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
