package com.lyq.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.lyq.bean.PmsBaseCatalog1;
import com.lyq.bean.PmsBaseCatalog2;
import com.lyq.bean.PmsBaseCatalog3;
import com.lyq.manage.mapper.PmsBaseCatalog1Mapper;
import com.lyq.manage.mapper.PmsBaseCatalog2Mapper;
import com.lyq.manage.mapper.PmsBaseCatalog3Mapper;
import com.lyq.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(version = "1.0.0")
@Component
public class CatalogServiceImpl implements CatalogService {

    @Autowired(required = false)
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired(required = false)
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired(required = false)
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public String test(){
        String result = "Hello world!";
        return result;
    }

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {

        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s = pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);

        return pmsBaseCatalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {

        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog3s = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);

        return pmsBaseCatalog3s;
    }
}
