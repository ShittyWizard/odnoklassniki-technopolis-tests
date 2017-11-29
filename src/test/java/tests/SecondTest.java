import org.junit.Assert;
import org.junit.Test;

import java.core.*;
import java.model.TestBot;

public class SecondTest extends TestBase {
    private final String GROUP_NAME = " ";
    private final String GROUP_DESCRIPTION = " ";

    @Test
    public void testGroupCreation() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("technopolisBot4", "technopolisBot16"));
        new UserMainPage(driver).clickGroupsOnToolbar();
        GroupMainPage groupMainPage = new GroupMainPage(driver);
        groupMainPage.clickCreateGroup();
        groupMainPage.clickBoardGroup();
        groupMainPage.typeGroupName(GROUP_NAME);
        groupMainPage.typeGroupDescription(GROUP_DESCRIPTION);
        groupMainPage.clickCreateButton();

        //Проверка создания группы с заданным названием и описанием
        CurrentGroupPage currentGroupPage = new CurrentGroupPage(driver);
        Assert.assertEquals(GROUP_NAME, currentGroupPage.getGroupName());
        Assert.assertEquals(GROUP_DESCRIPTION, currentGroupPage.getGroupDescription());
    }
}