package com.heika.test.verify.cases.UI;

import com.heika.test.common.SearchUserType;
import com.heika.test.models.user.UserSearchResult;
import com.heika.test.ui.elements.factory.api.ElementFactory;
import com.heika.test.ui.verify.page.LeftPage;
import com.heika.test.ui.verify.page.UserSearch;
import com.heika.test.utils.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestSearchUser extends TestBase
{
    @Parameters({"verify_ui_search_by_nickname"})
    @Test(groups= {"UI"}, description = "")
    public void TestSearchUser(String nickName) throws Exception
    {
        Integer userId = this.getUserService().getUser(nickName).getUserId();
        updateTestDataToINQUIREING(userId);
        LeftPage navTree = ElementFactory.initElements(getWebDriver(), LeftPage.class);
        LogHelper.log("点击“用户查询”导航栏");
        navTree.switchTo("用户查询");

        UserSearch userSearch = ElementFactory.initElements(getWebDriver(), UserSearch.class);
        userSearch.search("昵称", "全部", nickName);
        Assert.assertEquals(1, userSearch.getRowCount(), "用户搜索页面，搜索昵称 '" + nickName + "'时，找到的结果不唯一！！");

        List<UserSearchResult> usersFromUI = userSearch.parseObjectsFromDataGrid(userId);
        List<UserSearchResult> usersFromDB = getUserSearchService().getUsersFromDB(SearchUserType.NICKNAME, nickName, null);
        Assert.assertEquals(usersFromDB, usersFromUI, "按照昵称 '" + nickName + "' 比较前端页面与数据库中解析出的结果，发现不同！！");
    }
}