package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStep {
 
    WebDriver driver = DriverSingleton.createOrGetDriver();

    @When("Pengguna klik menu dan memilih logout")
    public void pengguna_logout() {
        driver.findElement(By.id("react-burger-menu-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutButton.click();
    }

    @Then("Pengguna berhasil logout dan kembali ke halaman login")
    public void validasi_halaman_login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        Assert.assertTrue(loginBtn.isDisplayed(), "Tombol login tidak tampil setelah logout");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html", "Tidak kembali ke halaman login");
    }
}
