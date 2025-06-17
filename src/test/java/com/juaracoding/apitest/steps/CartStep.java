package com.juaracoding.apitest.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.ProdukListPage;
import com.juaracoding.apitest.pages.SignInPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CartStep {
    WebDriver driver = DriverSingleton.createOrGetDriver();
    @Before
    public void loginJikaPerlu() {
    driver.get("https://www.saucedemo.com/v1/index.html");
    new SignInPage(driver).login("standard_user", "secret_sauce");
}

    @When("Pengguna menambahkan satu produk ke keranjang")
    public void tambah_produk() {
        ProdukListPage produkListPage = new ProdukListPage(driver);
        produkListPage.clickAddToCartFirstItem();
    }

    @And("Pengguna membuka halaman keranjang")
    public void buka_keranjang() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("Produk ditampilkan di halaman keranjang")
    public void verifikasi_produk_keranjang() {
    List<WebElement> items = driver.findElements(By.className("cart_item"));
    Assert.assertTrue(items.size() > 0, "Keranjang kosong.");
    }

}
