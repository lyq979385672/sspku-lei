package com.lyq.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lyq.bean.PmsSkuAttrValue;
import com.lyq.bean.PmsSkuImage;
import com.lyq.bean.PmsSkuInfo;
import com.lyq.bean.PmsSkuSaleAttrValue;
import com.lyq.manage.mapper.PmsSkuAttrValueMapper;
import com.lyq.manage.mapper.PmsSkuImageMapper;
import com.lyq.manage.mapper.PmsSkuInfoMapper;
import com.lyq.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.lyq.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Service(version = "1.0.0")
@Component
public class SkuServiceImpl implements SkuService {

    @Autowired(required = false)
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired(required = false)
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired(required = false)
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired(required = false)
    PmsSkuImageMapper pmsSkuImageMapper;


    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {

        // 插入skuInfo
        int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();

        // 插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }

        // 插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        // 插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);
        }


    }

    @Override
    public PmsSkuInfo getSkuById(String skuId, String ip) {
        return null;
    }

    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId) {
        return null;
    }

    @Override
    public List<PmsSkuInfo> getAllSku(String catalog3Id) {
        return null;
    }

    @Override
    public boolean checkPrice(String productSkuId, BigDecimal productPrice) {
        return false;
    }
}
