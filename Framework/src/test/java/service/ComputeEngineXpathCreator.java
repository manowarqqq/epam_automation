package service;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputeEngineXpathCreator {



    public String  machineTypeInstance= "";


    @FindBy(xpath = "//*[@id='select_option_342']")
    private WebElement numberOfGPUInput;


    @FindBy(xpath = "//*[@id='select_option_349']/div")
    private WebElement gpuTypeInstance;


    @FindBy(xpath = "//*[@id='select_option_234']/div")
    private WebElement localSSDInstance;


    @FindBy(xpath = "//*[@id='select_option_181']/div")
    private WebElement datacenterLocationInctance;


    @FindBy(xpath = "//*[@id='select_option_90']/div[1]")
    private WebElement commitedUsageInstance;

}
