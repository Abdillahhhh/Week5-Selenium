package com.juaracoding.apitest.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.juaracoding.apitest.DriverSingleton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OverviewPage {
    WebDriver driver = DriverSingleton.createOrGetDriver();

    @Given("Pengguna berada di halaman ringkasan checkout")
    public void di_ringkasan() {
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
    }

    @When("Pengguna mengklik tombol Finish")
    public void klik_finish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("Pesan {string} ditampilkan")
    public void verifikasi_pesan(String pesan) {
        WebElement message = driver.findElement(By.className("complete-header"));
        Assert.assertEquals(message.getText(), pesan);
    }

}
