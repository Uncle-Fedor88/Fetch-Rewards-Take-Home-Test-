package utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class UtilityMethods {


    /**
     * This method converts WebElements to String List
     * @param bowlSquares
     * @return List<String>
     */
    public static List<String> getResult(List<WebElement> bowlSquares){
        return bowlSquares
                .stream()
                .map(el->el.getAttribute("value"))
                .filter(e->!e.isEmpty())
                .collect(Collectors.toList());
    }


    /**
     *This method waits particular wait
     * @param timeInSec
     */
    public static void timeWait(long timeInSec){
        try {
            Thread.sleep(timeInSec*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



}
