package com.heika.test.verify.my_test;

import com.heika.test.common.VerifyUserStatus;
import com.heika.test.entities.user.UserEntity;
import com.heika.test.entities.user.UserInfoEntity;
import com.heika.test.entities.verify.VerifyUserStatusEntity;
import com.heika.test.services.user.UserInfoService;
import com.heika.test.services.user.UserService;
import com.heika.test.services.user.VerifyUserStatusService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestUserMaterial
{
    @Test(groups= {"verify"}, description = "")
    public void myTest()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("main_spring.xml");
//        UserMaterialService userMaterialService = (UserMaterialService)ctx.getBean("userMaterialService");
//        Integer id = userMaterialService.addUserMaterial(123, MaterialType.IDCARDBACK, "/test");
//        Reporter.log("id: " + id, true);
//        userMaterialService.deleteUserMaterial(id);
//
//
        UserService userService = (UserService)ctx.getBean("userService");
//        Integer userId = userService.addUser(false, Channel.BD_IMPORT, 1, false, 1, "123123", "my test",
//                new Timestamp(new Date().getTime()), UserType.COMMON, 0, new Timestamp(new Date().getTime()));
//        Reporter.log("userId: " + userId);
//        userService.deleteUser(userId);
//
        UserEntity userEntity = userService.nextUser();
        Integer userId = userService.addUser(userEntity);
        Reporter.log("userId: " + userId);

        UserInfoService userInfoService = (UserInfoService)ctx.getBean("userInfoService");
        UserInfoEntity userInfoEntity =  userInfoService.nextUserInfo(userId, "/8cc0c21f-43e3-477c-8f77-a5c1c0508512.jpg");
        userInfoService.addUserInfo(userInfoEntity);

        VerifyUserStatusService verifyUserStatusService = (VerifyUserStatusService)ctx.getBean("verifyUserStatusService");
        //VerifyUserStatusEntity verifyUserStatusEntity = verifyUserStatusService.nextUncommitVerifyUserStatus(userId);
        VerifyUserStatusEntity verifyUserStatusEntity = verifyUserStatusService.nextInquireingVerifyUserStatus(userId);
        verifyUserStatusService.addVerifyUserStatus(verifyUserStatusEntity);

        verifyUserStatusService.deleteVerifyUserStatusByUserId(userId);
        userInfoService.deleteUserInfo(userId);
        userService.deleteUser(userId);
    }
}
