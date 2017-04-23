package Delfi.tests.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by antons on 14/04/2017.
 */
public class TitleManager {

    public TitleManager() {
    }

    private static By firstArticleTitleDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[1]/div[1]/h3/a[1]");
    private static By secondArticleTitleDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[1]/div[2]/h3/a[1]");
    private static By thirdArticleTitleDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[2]/div[1]/h3/a[1]");
    private static By fourthArticleTitleDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[2]/div[2]/h3/a[1]");
    private static By fifthArticleTitleDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[2]/div[3]/h3/a[1]");


    private static By firstArticleTitleMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[2]/div/a[1]");
    private static By secondArticleTitleMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[3]/div/a[1]");
    private static By thirdArticleTitleMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[4]/div/a[1]");
    private static By fourthArticleTitleMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[6]/div/a[1]");
    private static By fifthArticleTitleMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[7]/div/a[1]");


    // Creating an array of first five titles selectors for desktop version
    public static By [] getDesktopTitleSelectors (){
        TestBase.logger.info("Saving first five titles Desktop version");
        By [] desktopTitleSelectors = new By[5];
        desktopTitleSelectors[0] =firstArticleTitleDesktop;
        desktopTitleSelectors[1] =secondArticleTitleDesktop;
        desktopTitleSelectors[2] =thirdArticleTitleDesktop;
        desktopTitleSelectors[3] =fourthArticleTitleDesktop;
        desktopTitleSelectors[4] =fifthArticleTitleDesktop;
        return desktopTitleSelectors;
    }

    // Creating an array of first five titles selectors for mobile version
    public static By [] getMobileTitleSelectors (){
        TestBase.logger.info("Saving first five titles Mobile version");
        By [] mobileTitleSelectors = new By[5];
        mobileTitleSelectors[0] =firstArticleTitleMobile;
        mobileTitleSelectors[1] =secondArticleTitleMobile;
        mobileTitleSelectors[2] =thirdArticleTitleMobile;
        mobileTitleSelectors[3] =fourthArticleTitleMobile;
        mobileTitleSelectors[4] =fifthArticleTitleMobile;
        return mobileTitleSelectors;
    }


    // Creating list of first five articles tiles
    public List getListOfTitles(By[] titleSelectors, WebDriver driver){
        TestBase.logger.info("Saving first five titles");
        String firstArticleTitle = driver.findElement(titleSelectors[0]).getText();
        String secondArticleTitle = driver.findElement(titleSelectors[1]).getText();
        String thirdArticleTitle = driver.findElement(titleSelectors[2]).getText();
        String fourthArticleTitle = driver.findElement(titleSelectors[3]).getText();
        String fifthArticleTitle = driver.findElement(titleSelectors[4]).getText();


        TestBase.logger.info("Creating list of titles");
        List<String> listOfTitles = new ArrayList<String>();
        listOfTitles.add(firstArticleTitle);
        listOfTitles.add(secondArticleTitle);
        listOfTitles.add(thirdArticleTitle);
        listOfTitles.add(fourthArticleTitle);
        listOfTitles.add(fifthArticleTitle);
        return listOfTitles;

    }


}
