# 📘 Study Target & Progress Tracker

Aplikasi **Study Target & Progress Tracker** adalah aplikasi desktop berbasis **Java Swing** yang dikembangkan untuk memenuhi **Ujian Akhir Praktikum (UAP)** pada mata kuliah **Pemrograman Lanjut**.

Aplikasi ini digunakan untuk mengelola target belajar dengan menerapkan konsep **Object Oriented Programming (OOP)**, **Graphical User Interface (GUI)**, **CRUD**, serta **penyimpanan data menggunakan file CSV**.

---

## ✨ Fitur Aplikasi

- Menambahkan target belajar (Create)
- Menampilkan daftar target belajar dalam bentuk tabel (Read)
- Mengedit data target belajar (Update)
- Menghapus data target belajar (Delete)
- Menandai target belajar sebagai **Selesai**
- Mengurutkan data target berdasarkan:
  - Deadline terdekat
  - Deadline terjauh
  - Status (Belum → Proses → Selesai)
- Menampilkan Dashboard Progress Belajar
- Menampilkan Riwayat Target yang Telah Selesai
- Penyimpanan data otomatis menggunakan file CSV

---

## 🛠️ Teknologi yang Digunakan

- Java SE
- Java Swing (GUI)
- File I/O
- CSV sebagai media penyimpanan data

---

## 📂 Struktur Project

```
src
├── App.java
├── model
│   └── StudyTarget.java
├── utils
│   ├── DataStore.java
│   └── FileManager.java
└── view
    ├── MainFrame.java
    ├── DashboardPanel.java
    ├── InputTargetPanel.java
    ├── ListTargetPanel.java
    ├── HistoryPanel.java
    └── RoundedButton.java

data.csv
```

---

## ▶️ Cara Menjalankan Program

1. Pastikan Java JDK 8 atau lebih baru sudah terinstal
2. Buka project menggunakan IDE (IntelliJ IDEA / NetBeans / Eclipse)
3. Jalankan file `App.java`
4. Aplikasi akan berjalan dalam bentuk GUI desktop

---

## 💾 Format Penyimpanan Data

Data disimpan dalam file `data.csv` dengan format:

```
Nama Tugas,Mata Kuliah,Deadline,Status
```

Contoh:
```
UTS Pemrograman Lanjut,Java,2025-06-10,Belum
```

---

## 🧪 Pengujian Program

Pengujian dilakukan secara manual dengan hasil sebagai berikut:

- Input data dengan format valid → berhasil disimpan
- Input data tidak valid → ditolak dengan pesan kesalahan
- Data tetap tersimpan setelah aplikasi ditutup dan dijalankan kembali
- Fitur sorting berjalan sesuai kriteria
- Fitur edit, hapus, dan update status berjalan dengan baik
- Dashboard dan history menampilkan data sesuai perubahan

---

## 📌 Keterangan

Aplikasi ini dibuat sesuai dengan ketentuan dan kriteria Modul UAP Pemrograman Lanjut serta telah melalui proses testing dan code review untuk memastikan aplikasi berjalan dengan baik dan stabil.
