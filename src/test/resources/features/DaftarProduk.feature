Feature: Daftar Produk

  Scenario: Verifikasi daftar produk ditampilkan setelah login
    Given Pretest verifikasi, login dengan user valid
    When Verifikasi semua produk ditampilkan
    Then Daftar produk muncul lengkap dengan nama, harga, dan tombol Add to Cart

  Scenario: TC004 - Tambah produk ke keranjang
    When Pengguna menambahkan satu produk ke keranjang
    And Pengguna membuka halaman keranjang
    Then Produk ditampilkan di halaman keranjang

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario: TC005 - Isi informasi checkout
    Given Pengguna berada di halaman keranjang
    When Pengguna mengklik tombol Checkout
    And Pengguna mengisi data "Abdi", "Lah", dan "12345"
    And Pengguna mengklik tombol Continue
    Then Halaman ringkasan checkout ditampilkan

  Scenario: TC006 - Selesaikan proses checkout
    Given Pengguna berada di halaman ringkasan checkout
    When Pengguna mengklik tombol Finish
    Then Pesan "THANK YOU FOR YOUR ORDER" ditampilkan

  Scenario: TC007 - Logout dari sistem
    When Pengguna klik menu dan memilih logout
    Then Pengguna berhasil logout dan kembali ke halaman login
