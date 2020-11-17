package step_Definitions;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search extends elements {
	
       
	@Given("^User Navigate to URL$")
	public void user_Navigate_to_URL() throws Throwable {
		reusable();
	}

	@When("^User enters source location  and destination location$")
	public void user_enters_source_location_and_destination_location() throws Throwable {
		d.findElement(fromplace).sendKeys(property().getProperty("fromplace"));
		List<WebElement> li = d.findElements(fromPlaceName);
		System.out.println(li.size());

		for (WebElement text : li) {
			System.out.println(text.getText());

			if (text.getText().equalsIgnoreCase(property().getProperty("Actualtext"))) {
				text.click();
			}

		}
		d.findElement(toplace).sendKeys(property().getProperty("toplace"));
		List<WebElement> li1 = d.findElements(toPlaceName);
		System.out.println(li1.size());
		for (WebElement text1 : li1) {
			System.out.println(text1.getText());

			if (text1.getText().equalsIgnoreCase(property().getProperty("Actualtext1"))) {
				text1.click();
			}
		}
	}

	@And("^user enters calender Date$")
	public void user_enters_calender_Date() throws Throwable {
		d.findElement(jrnydate).click();
		WebElement left = d.findElement(leftside);
		String name1 = left.getText();
		WebElement right = d.findElement(rightside);
		String name2 = right.getText();
		
		if (name1.equalsIgnoreCase(property().getProperty("Actualmonth"))) {
			System.out.println("leftside month is "+name1);
			WebElement Date = d.findElement(leftsidedate);
			
			String Disabled = d.findElement(leftsidedisable).getAttribute("class");
			try {
				if (Disabled.contains("disabled")) {
					System.out.println("Date is disabled " + property().getProperty("Day") + name1);

				} else {
					Date.click();
					System.out.println("Date Selected in " + property().getProperty("Day") + name1);
				}
			} catch (Exception e) {
				System.out.println("Exception " + name1 + property().getProperty("Day"));
				e.printStackTrace();

			}

		} else if (name2.equalsIgnoreCase(property().getProperty("Actualmonth"))) {
			System.out.println("rightside month is "+name2);
			WebElement Date1 = d.findElement(rightsidedate);
			String Disabled1 = d.findElement(rightsidedisable)
					.getAttribute("class");
			try {
				if (Disabled1.contains("disabled")) {
					System.out.println("Date is disabled " + property().getProperty("Day") + name2);
				} else {
					Date1.click();
					System.out.println("Date Selected in " + property().getProperty("Day") + name2);
				}
			} catch (Exception e) {
				System.out.println("Exception" + name2 + property().getProperty("Day"));
				e.printStackTrace();
			}

		}else{
			System.out.println("Invalid Month " +property().getProperty("Actualmonth"));
		}
		d.findElement(searchbtn).click();
		Thread.sleep(6000);
	}

	@Then("^Verify details of the bus$")
	public void verify_details_of_the_bus() throws Throwable {
		String Pagetitle = d.getTitle();
		try {
			WebDriverWait wait = new WebDriverWait(d, 60);
			wait.until(ExpectedConditions.visibilityOf(d.findElement(journeydate)));
			WebElement Date2 = d.findElement(journeydate);
			System.out.println("Page title is " + Pagetitle);
			System.out.println("Journey Date is " + Date2.getText());

		} catch (Exception e) {
			System.out.println("Invaild Month or Invalid Date " + property().getProperty("Actualmonth"));
			e.printStackTrace();
		}

		WebElement Routeinfo = d.findElement(routeinfo);
		System.out.println("Journey details is " + Routeinfo.getText());
		WebDriverWait wait1 = new WebDriverWait(d, 60);
		wait1.until(ExpectedConditions.visibilityOf(d.findElement(services)));
		WebElement Services = d.findElement(services);
		System.out.println("Services details is " + Services.getText());
		String text = Services.getText();
		Integer Noofservices = Integer.parseInt(text);
		System.out.println("No of services are " + Noofservices);
		if (Noofservices > 0) {
			System.out.println("services available");
			List<WebElement> buses = d.findElements(buses1);
			System.out.println("No of buses are" + buses.size());
			for (WebElement serviceName : buses) {
				System.out.println("ServiceNumbers are " + serviceName.getText());

				if (serviceName.getText().equalsIgnoreCase(property().getProperty("Service"))) {
					System.out.println("Service available");
					WebDriverWait wait2 = new WebDriverWait(d, 60);
					wait2.until(ExpectedConditions
							.visibilityOf(d.findElement(Noofseatsavbl)));
					String Nofseatsavl = d.findElement(Noofseatsavbl)
							.getAttribute("availcs");
					Integer Numberofaseats = Integer.parseInt(Nofseatsavl);
					if (Numberofaseats > 0) {
						System.out.println("No of seats available " +  Numberofaseats);
						WebElement button = d.findElement(Button);
						button.click();
						System.out.println("clicked");
						break;
					} else {
						System.out.println("No of seats available " +  Numberofaseats);
					}
				} else {
					System.out.println("Service Not available");
				}
			}

		} else {
			System.out.println("No services are available" + Noofservices);
		}

	}

}
