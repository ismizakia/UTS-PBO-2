## Identitas
- Nama  : Ismi Zakia
- NPM  : 2210010020
- Kelas  : 5B Non Reguler Banjarmasin
# Aplikasi Catatan Harian

**Aplikasi Catatan Harian** adalah aplikasi desktop sederhana berbasis Java yang memungkinkan pengguna untuk membuat, mengedit, dan menghapus catatan melalui antarmuka grafis (GUI). Aplikasi ini dirancang menggunakan pustaka **Swing**.

## Fitur
1. **Tambah Catatan:** Pengguna dapat menambahkan catatan baru dengan judul dan isi.
2. **Edit Catatan:** Pengguna dapat mengedit catatan yang telah dibuat.
3. **Hapus Catatan:** Pengguna dapat menghapus catatan yang dipilih dari daftar.
4. **Antarmuka yang User-Friendly:** Desain menggunakan warna-warna yang nyaman dipandang.

## Teknologi yang Digunakan
- **Java Swing:** Untuk pembuatan antarmuka pengguna.
- **JTable & DefaultTableModel:** Untuk menampilkan dan mengelola data catatan.
- **JPanel & Layout Manager:** Untuk mengatur tata letak komponen.

## Struktur Antarmuka
- **Tabel Catatan:** Menampilkan daftar catatan dengan kolom `Judul` dan `Isi Catatan`.
- **Panel Input:** Tempat untuk memasukkan atau mengedit judul dan isi catatan.
- **Panel Tombol Aksi:** Terdapat tiga tombol utama:
  - **Tambah:** Menambahkan catatan baru.
  - **Ubah:** Mengedit catatan yang dipilih.
  - **Hapus:** Menghapus catatan yang dipilih.

## Cara Menggunakan
1. **Menambahkan Catatan:**
   - Masukkan teks ke dalam kolom **Judul** dan **Isi Catatan**.
   - Klik tombol **Tambah** untuk menyimpan catatan ke dalam tabel.

2. **Mengedit Catatan:**
   - Pilih catatan dari tabel.
   - Ubah teks di kolom **Judul** atau **Isi Catatan**.
   - Klik tombol **Ubah** untuk menyimpan perubahan.

3. **Menghapus Catatan:**
   - Pilih catatan dari tabel.
   - Klik tombol **Hapus** untuk menghapus catatan dari daftar.

4. **Memilih Catatan:**
   - Klik salah satu baris di tabel untuk menampilkan data catatan pada kolom **Judul** dan **Isi Catatan**.

## Cara Menjalankan Aplikasi
1. Pastikan Anda memiliki Java Development Kit (JDK) yang terinstal.
2. Simpan kode sumber ke dalam file bernama `AplikasiCatatanHarian.java`.
3. Kompilasi file dengan perintah:
   ```bash
   javac AplikasiCatatanHarian.java
