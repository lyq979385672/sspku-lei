package com.lyq.service;

import com.lyq.bean.PmsSearchParam;
import com.lyq.bean.PmsSearchSkuInfo;

import java.util.List;

public interface SearchService {
    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
