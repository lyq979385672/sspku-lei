package com.lyq.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lyq.bean.UmsMember;
import com.lyq.bean.UmsMemberReceiveAddress;
import com.lyq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference(version = "1.0.0")
    UserService userService;

    @RequestMapping("getReceiveAddressByMemberId")
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId){

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(memberId);

        return umsMemberReceiveAddresses;
    }


    @RequestMapping("/getAllUser")

   public List<UmsMember> getAllUser(){

        List<UmsMember> umsMembers = userService.getAllUser();
        System.out.println(umsMembers);

        return umsMembers;
    }

    @RequestMapping("/index")

    public String index(){
        return "hello user";
    }



}
