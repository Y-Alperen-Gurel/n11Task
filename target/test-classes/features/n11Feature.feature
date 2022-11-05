@N11
Feature: Favori

  Scenario: Anasayfa title kontrolü
    When kullanici n11 ana sayfaya gider
    Then Web page title "n11 - Hayat Sana Gelir" olmali

  Scenario: Anahtar kelimeye göre ürün listeleme
    When Gecerli kullanici bilgileri ile login olunur
    And Arama alanina "Samsung" yazılır
    Then listelenen ürünlerin anahtar kelimeye uygun oldugu teyit edilir


  Scenario: Listeleme sayfaları arası gecis
    When kullanici 2. sayfayi secer
    Then Seçili sayfa ürünlerin listelendigi teyit edilir

  Scenario: Favoriye ekleme
    When üstten üçüncü ürün favoriye ekle
    And favorilerim linkine tıkla
    And Favorilerim'e tıkla
    Then Favoriye eklenen ürün favori listesinde olmalı

  Scenario: Favoriden silme
    When sil butonuna tıklayarak ürünü favoriden sil
    Then ürünün favorilerde olmamali