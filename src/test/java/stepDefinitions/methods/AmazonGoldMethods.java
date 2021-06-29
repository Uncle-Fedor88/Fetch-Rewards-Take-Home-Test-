package stepDefinitions.methods;

import utils.Driver;
import utils.UtilityMethods;
import amazonPages.MainWeighPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class AmazonGoldMethods {
    private WebDriver driver = Driver.getDriver();
    private MainWeighPage mainWeighPage = new MainWeighPage(driver);
    private static String operator;
    private static List<String> listOfCoins;
    private static String emptyCoin;


    /**
     *This method click on provided number of coin
     * @param listOfCoins
     * @param coin
     */
    public void clickOnCoin(List<WebElement> listOfCoins, String coin){
        for(WebElement c:listOfCoins){
            if(c.getText().equals(coin)){
                c.click();
                break;
            }
        }
    }

    /**
     * This method return list of coin which contains empty gold
     * @param listOfCoins
     * @param listOfLeftSquares
     * @param listOfRightSquares
     * @param operator
     * @return List<String>
     */
    public List<String> getListContainingEmptyCoin(List<String> listOfCoins, List<WebElement> listOfLeftSquares, List<WebElement> listOfRightSquares, String operator){

        switch (operator){
            case "=":
                listOfCoins.removeAll(UtilityMethods.getResult(listOfLeftSquares));
                listOfCoins.removeAll(UtilityMethods.getResult(listOfRightSquares));
                break;
            case ">":
                listOfCoins.retainAll(UtilityMethods.getResult(listOfRightSquares));
                break;
            case "<":
                listOfCoins.retainAll(UtilityMethods.getResult(listOfLeftSquares));
                break;
        }
        return listOfCoins;
    }



    public void userInsertsGoldToTheLeftAndRightBowlsAndFindsEmptyGold(){
        listOfCoins = mainWeighPage.listOfCoins
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<WebElement> listOfLeftSquares = mainWeighPage.threeLeftBowlSquares;
        List<WebElement> listOfRightSquares = mainWeighPage.threeRightBowlSquares;

        int coin = 0;

        for(int i=0;i<listOfLeftSquares.size();i++){
            listOfLeftSquares.get(i).sendKeys(listOfCoins.get(coin++));
            listOfRightSquares.get(i).sendKeys(listOfCoins.get(coin++));
        }

        mainWeighPage.weigh.click();
        UtilityMethods.timeWait(3);
        operator = mainWeighPage.resultOperator.getText();
        getListContainingEmptyCoin(listOfCoins, listOfLeftSquares, listOfRightSquares, operator);
        mainWeighPage.reset.click();

        listOfLeftSquares.get(0).sendKeys(listOfCoins.get(0));
        listOfRightSquares.get(0).sendKeys(listOfCoins.get(listOfCoins.size() - 1));

        mainWeighPage.weigh.click();
        UtilityMethods.timeWait(3);
        operator = mainWeighPage.resultOperator.getText();
        emptyCoin = getListContainingEmptyCoin(listOfCoins, listOfLeftSquares, listOfRightSquares, operator).get(0);
    }

    public void userPressOnEmptyGoldAndValidatesAlertMessage(String alertMessage){
        clickOnCoin(mainWeighPage.listOfCoins, emptyCoin);
        String actualAlertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage,actualAlertMessage);
        UtilityMethods.timeWait(2);
    }

}
