package amazonPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainWeighPage extends BasePage {


    public MainWeighPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='coins']/button")
    public List<WebElement> listOfCoins;

    @FindBy(xpath = "//div[@class='status' and text()='left']/following::div[@class='board-row'][1]/input")
    public List<WebElement> threeLeftBowlSquares;

    @FindBy(xpath = "//div[@class='status' and text()='right']/following::div[@class='board-row'][1]/input")
    public List<WebElement> threeRightBowlSquares;

    @FindBy(xpath = "//div[@class='result']//button[@id='reset']")
    public WebElement resultOperator;

    @FindBy(id ="weigh")
    public WebElement weigh;

    @FindBy(xpath ="//div/button[@id='weigh']/preceding-sibling::button" )
    public WebElement reset;


}
