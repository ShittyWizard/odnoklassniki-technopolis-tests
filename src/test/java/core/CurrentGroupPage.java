package java.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrentGroupPage extends HelperBase {

    public CurrentGroupPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) driver -> driver.getCurrentUrl().matches("https://ok\\.ru/group/\\d+")
                || driver.getCurrentUrl().matches("https://www\\.ok\\.ru/group/\\d+"));
    }

    //Получить название группы
    public String getGroupName() {
        return driver.findElement(By.xpath("//span[contains(@class, 'mctc_name_holder')]")).getText();
    }

    //Получить описание группы
    public String getGroupDescription() {
        return driver.findElement(By.xpath("//div[contains(@class, 'group-info_desc')]")).getText();
    }

    //Клик по "Разместить товар"
    public void clickAddStub() {
        click(By.xpath("//span[contains(@class, 'add-stub_tx')]"));
    }

    //Клик по вкладке "Товары"
    public void clickMarket() {
        click(By.xpath("//a[contains(@href, 'market')]"));
    }

    //Клик на "Создать новую тему"
    public void clickPostingForm() {
        click(By.xpath("//div[contains(@class, 'posting-form_itx_w')]"));
    }

    //Ввод текста для создания нового поста
    public void inputNewPost(String message) {
        type(message, By.id("posting_form_text_field"));
    }
}
