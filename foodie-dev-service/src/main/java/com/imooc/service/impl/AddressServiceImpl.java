package com.imooc.service.impl;

import com.imooc.enums.YseOrNo;
import com.imooc.mapper.UserAddressMapper;
import com.imooc.pojo.UserAddress;
import com.imooc.pojo.bo.AddressBO;
import com.imooc.service.AddressService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserAddress> queryAll(String userId) {
        UserAddress userAddress=new UserAddress();
        userAddress.setUserId(userId);
        return   userAddressMapper.select(userAddress);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addNewUserAddress(AddressBO addressBO) {

        Integer isDefault=0;
        List<UserAddress> userAddresses = this.queryAll(addressBO.getUserId());
        if(userAddresses==null||userAddresses.isEmpty()||userAddresses.size()==0){
            isDefault=1;
        }
        UserAddress userAddress=new UserAddress();
        BeanUtils.copyProperties(addressBO, userAddress);
        userAddress.setId(Sid.nextShort());
        userAddress.setIsDefault(isDefault);
        userAddress.setCreatedTime(new Date());
        userAddress.setUpdatedTime(new Date());
        userAddressMapper.insert(userAddress);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddress(AddressBO addressBO) {
        String addressId = addressBO.getAddressId();
        UserAddress userAddress=new UserAddress();
        BeanUtils.copyProperties(addressBO, userAddress);
        userAddress.setId(addressId);
        userAddress.setUpdatedTime(new Date());
        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserAddress(String userId, String addressId) {
        UserAddress userAddress=new UserAddress();
        userAddress.setId(addressId);
        userAddress.setUserId(userId);
        userAddressMapper.delete(userAddress);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddressToBeDefault(String userId, String addressId) {
        UserAddress queryAddress=new UserAddress();
        queryAddress.setUserId(userId);
        queryAddress.setIsDefault(YseOrNo.YES.type);
        List<UserAddress> select = userAddressMapper.select(queryAddress);
        for (UserAddress address : select) {
            address.setIsDefault(YseOrNo.NO.type);
            userAddressMapper.updateByPrimaryKeySelective(address);
        }
        UserAddress defaultAddress=new UserAddress();
        defaultAddress.setUserId(userId);
        defaultAddress.setId(addressId);
        defaultAddress.setIsDefault(YseOrNo.YES.type);
        userAddressMapper.updateByPrimaryKeySelective(defaultAddress);

    }
}
