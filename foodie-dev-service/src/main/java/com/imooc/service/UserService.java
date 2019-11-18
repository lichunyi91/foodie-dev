package com.imooc.service;

import com.imooc.pojo.bo.UserBO;

public interface UserService {

   public  boolean  queryUsernameIsExist(String username);

   public void createUser(UserBO userBO);
}
