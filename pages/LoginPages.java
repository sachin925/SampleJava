package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPages {

    @FindBy(how = How.ID,using = "")
    WebElement uname;

    @FindBy(how = How.ID,using = "")
    WebElement passwd_field;

    @FindBy(how = How.ID,using = "")
    WebElement loginBtn;

    @FindBy(how = How.ID,using = "")
    WebElement menu;

    public void login(String userID, String passwd){
        uname.sendKeys(userID);
        passwd_field.sendKeys(passwd);

        loginBtn.click();
    }

    public boolean isLoggedIn(){
        return menu.isDisplayed();
    }

}
