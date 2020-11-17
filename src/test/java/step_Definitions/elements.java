package step_Definitions;

import org.openqa.selenium.By;

public class elements extends Basic{

public static   By fromplace= By.id("fromPlaceName");	
public static   By toplace= By.id("toPlaceName");
public static   By jrnydate=By.id("txtJourneyDate");
public static   By searchbtn=By.id("searchBtn");
public static	By fromPlaceName=  By.xpath("//body/ul[@id='ui-id-1']/li");
public static	By	toPlaceName=By.xpath("//body/ul[@id='ui-id-2']/li");
public static	By	leftside=By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']/div/span");
public static	By	rightside=By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']/div/span");
public static	By	leftsidedate=By.xpath("//div[contains(@class,'corner-left')]//following-sibling::table/tbody//descendant::td/*[text()='"+property().getProperty("Day")+"']");
public static	By	leftsidedisable= By.xpath("//div[contains(@class,'corner-left')]//following-sibling::table//*[text()='"+property().getProperty("Day")+"']/parent::td");
public static	By	rightsidedate=By.xpath("//div[contains(@class,'corner-right')]//following-sibling::table/tbody//descendant::td/*[text()='"+property().getProperty("Day")+"']");
public static	By	rightsidedisable=By.xpath("//div[contains(@class,'corner-right')]//following-sibling::table//*[text()='"+property().getProperty("Day")+"']/parent::td");           
public static	By	journeydate=By.xpath("//div[@id='search-result']//descendant::span[@class='journeyDateCs']");
public static	By   routeinfo=By.xpath(" //div[@id='search-result']//descendant::div[@id='fwInfoLeftId']/h1");
public static   By	services=By.xpath("//div[@id='search-result']//descendant::div[@id='fwInfoLeftId']/span/span[@id='fwTotalServicesId']");
public static   By	buses1=By.xpath("//div[@id='ForwardResults']/descendant::div[@class='srvceNO']");
public static   By	Noofseatsavbl=By.xpath("//div[@class='rSetForward']//descendant::div[contains(text(),'"+property().getProperty("Service")+"')]/parent::div/following-sibling::div/span[@class='availCs']");
public static   By	Button=By.xpath("//div[@class='rSetForward']//descendant::div[contains(text(),'"+property().getProperty("Service")+"')]/parent::div/following-sibling::div/input");


}
