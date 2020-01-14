package com.lyq.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.lyq.bean.UmsMember;
import com.lyq.bean.UmsMemberReceiveAddress;
import com.lyq.service.UserService;
import com.lyq.user.mapper.UmsMemberReceiveAddressMapper;
import com.lyq.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Service(version = "1.0.0")
@Component
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired(required = false)
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {


        List<UmsMember> umsMembers = userMapper.selectAllUser();//userMapper.selectAllUser();
        System.out.println(umsMembers);

        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {

        // 封装的参数对象
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);


//       Example example = new Example(UmsMemberReceiveAddress.class);
//       example.createCriteria().andEqualTo("memberId",memberId);
//       List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(example);

        return umsMemberReceiveAddresses;
    }

    @Override
    public UmsMember login(UmsMember umsMember) {
        return null;
    }

    @Override
    public void addUserToken(String token, String memberId) {

    }

    @Override
    public UmsMember addOauthUser(UmsMember umsMember) {
        return null;
    }

    @Override
    public UmsMember checkOauthUser(UmsMember umsCheck) {
        return null;
    }

    @Override
    public UmsMember getOauthUser(UmsMember umsMemberCheck) {
        return null;
    }

    @Override
    public UmsMemberReceiveAddress getReceiveAddressById(String receiveAddressId) {
        return null;
    }
}
