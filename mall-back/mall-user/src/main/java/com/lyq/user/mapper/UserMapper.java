package com.lyq.user.mapper;

import com.lyq.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UmsMember>{

 List<UmsMember>  getAllUser();

}
