package com.juaracoding.apitest.pages;

import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Tambahkan method seperti:
    public void addFirstProductToCart() {
        // Aksi klik produk pertama
    }

    public void goToCart() {
        // Aksi buka halaman keranjang
    }

    public boolean isCartItemDisplayed() {
        // Validasi produk tampil
        return true;
    }
}
