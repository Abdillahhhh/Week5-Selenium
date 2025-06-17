package com.juaracoding.apitest.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutPage {

    WebDriver driver = DriverSingleton.createOrGetDriver();

    @Given("Pengguna berada di halaman keranjang")
    public void berada_di_keranjang() {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/v1/cart.html"));
    }

    @When("Pengguna mengklik tombol Checkout")
    public void klik_checkout() {
        driver.findElement(By.className("btn_action checkout_button")).click();
    }

    @And("Pengguna mengisi data {string}, {string}, dan {string}")
    public void isi_form(String first, String last, String zip) {
        driver.findElement(By.id("first-name")).sendKeys("abdi");
        driver.findElement(By.id("last-name")).sendKeys("lah");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
    }

    @And("Pengguna mengklik tombol Continue")
    public void klik_continue() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("Halaman ringkasan checkout ditampilkan")
    public void halaman_ringkasan() {
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
    }

}
