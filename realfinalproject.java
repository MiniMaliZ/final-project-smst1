import java.util.Scanner;
public class realfinalproject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Login dengan Multi User

        System.out.println("===== LOGIN USER =====");
        String username[] = {"Sufyan", "Raihan", "Vita"};
        String password[] = {"Bagaskara", "Abdi", "Ativ"};
        String userRole[] = {"Owner","Admin","Kasir"};

        String usernameLogin, passwordLogin;
        char login = 'n';

        // Global Variable
        String namaRoti[] = {"Roti Abon", "Roti Pizza", "Roti Moy", "Roti Sosis", "Roti Mily Cheese"};
        double hargaRoti[] = {7500, 6500, 7000, 7000, 6000};
        int stockRoti[] = {10, 5, 15, 13, 8};
        char keluar;
        int kodeRotiBeli[] = new int[1000], kuantitasRotiBeli[] = new int[1000], currentRoti = 0;
        int kodeRotiStored[] = new int[1000], kuantitasRotiStored[] = new int[1000], currentRotiStored = 0;
        double totalPendapatan = 0;
        
        while (true) {
            System.out.print("Username: ");
            usernameLogin = sc.nextLine();
            System.out.print("Password: ");
            passwordLogin = sc.nextLine();

            System.out.println();

            for (int i = 0; i < username.length; i++) {
                if (usernameLogin.equals(username[i]) && passwordLogin.equals(password[i])) {
                    System.out.println("Selamat Datang Kembali " + username[i]);
                    System.out.println("Anda Masuk Sebagai " + userRole[i]);
                    login = 'y';
                    break;
                }
            }

            if (login == 'y') {
                System.out.println();
                break;
            } else {
                System.out.println("Username atau Password Salah");
                System.out.println();
            }
        }

        // Menu

        int menu;

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Transaksi");
            System.out.println("2. Data Roti");
            System.out.println("3. Laporan Pendapatan");
            System.out.println("4. Logout");

            System.out.println();
    
            System.out.print("Masukkan Menu yang ingin dipilih (1-4) : ");
            menu = sc.nextInt();

            System.out.println();
    
            // Transaksi

            if (menu == 1) {
                while (true) {
                    int kodeRoti = 0, kuantitasRoti = 0;
                    double totalHarga = 0, totalHargaDiskon = 0, uangPembeli = 0, kembalian = 0 , diskon = 0;
                    char tambahRoti, membership;

                    printRoti(namaRoti, hargaRoti, stockRoti);

                    while (true) {
                        System.out.print("Kode Roti: ");
                        kodeRoti = sc.nextInt();
                        if (kodeRoti > namaRoti.length || kodeRoti < 1) {
                            System.out.println("Kode Roti Tidak Tersedia, Masukkan Lagi!");
                            continue;
                        }

                        System.out.print("Kuantitas Roti: ");
                        kuantitasRoti = sc.nextInt();
                        if(kuantitasRoti > stockRoti[kodeRoti-1]) {
                            System.out.println("Stock Roti Tidak Cukup, Masukkan Lagi!");
                            continue;
                        }

                        System.out.println();

                        // Pengurangan Stock
                        stockRoti[kodeRoti-1] -= kuantitasRoti;

                        totalHarga = totalHarga + (hargaRoti[kodeRoti-1] * kuantitasRoti);

                        // Cetak Struk
                        kodeRotiBeli[currentRoti] = kodeRoti;
                        kuantitasRotiBeli[currentRoti] = kuantitasRoti;

                        // Laporan
                        kodeRotiStored[currentRotiStored] = kodeRoti;
                        kuantitasRotiStored[currentRotiStored] = kuantitasRoti;

                        currentRotiStored++;

                        while (true) {
                            System.out.print("Tambah Roti ? (y/t) : ");
                            tambahRoti = sc.next().charAt(0);
                            if (tambahRoti == 'y') {
                                break;
                            } else if (tambahRoti == 't') {
                                break;
                            } else {
                                System.out.println("Input Salah, Masukkan Lagi!");
                            }
                        }

                        System.out.println();

                        if (tambahRoti == 'y') {
                            continue;
                        } else if (tambahRoti == 't') {
                            break;
                        }

                    }

                    System.out.print("Punya Member ? (y/t) : ");
                    membership = sc.next().charAt(0);

                    System.out.println();

                    if (membership == 'y') {
                        if (totalHarga > 50000 && totalHarga < 100000) {
                            diskon = 0.10;
                        } else if (totalHarga > 100000) {
                            diskon = 0.15;
                        }
                    } else if (membership == 't') {
                        if (totalHarga > 50000 && totalHarga < 100000) {
                            diskon = 0.05;
                        } else if (totalHarga > 100000) {
                            diskon = 0.10;
                        }
                    }

                    totalHargaDiskon = totalHarga - (totalHarga * diskon);
                    System.out.println("Total Harga : " + totalHarga);
                    System.out.println("Total Harga Setelah Diskon : " + totalHargaDiskon);

                    totalPendapatan += totalHargaDiskon;

                    System.out.println();

                    while (true) {
                        System.out.print("Uang Pembeli : ");
                        uangPembeli = sc.nextDouble();
                        if (uangPembeli > totalHargaDiskon) {
                            break;
                        } else {
                            System.out.println("Uang Kurang dari Total Harga, Masukkan Lagi!");
                        }
                    }

                    kembalian = uangPembeli - totalHargaDiskon;
                    System.out.println("Kembalian : " + kembalian);

                    System.out.println();

                    System.out.println("===== NOTA TRANSAKSI =====");
                        
                    System.out.printf("-------------------------------------------------------%n");
                    System.out.printf("| %-5s | %-18s | %-10s | %9s |%n", "KODE", "NAMA ROTI", "KUANTITAS", "HARGA");
                    System.out.printf("-------------------------------------------------------%n");

                    for (int i = 0; i < kodeRotiBeli.length; i++) {
                        if(kodeRotiBeli[i] == 0)
                                continue;
                        System.out.printf("| %-5s | %-18s | %-10d | %-9s |%n", (i + 1), namaRoti[kodeRotiBeli[i] - 1], kuantitasRotiBeli[i], hargaRoti[kodeRotiBeli[i] - 1] * kuantitasRotiBeli[i], " ");
                    }

                    System.out.printf("-------------------------------------------------------%n");

                    System.out.printf("| %-26s | %-10s | %-9s |%n", " ", "TOTAL", totalHarga);
                    System.out.printf("| %-26s | %-10s | %-9s |%n", " ", "KEMBALIAN", kembalian);


                    System.out.printf("-------------------------------------------------------%n");

                    System.out.print("Transaksi Baru ? (y/t) : ");
                    keluar = sc.next().charAt(0);

                    System.out.println();

                    if (keluar == 'y') {
                        kodeRotiBeli = new int[1000];
                        kuantitasRotiBeli = new int[1000];
                        continue;
                    } else if (keluar == 't') {
                        break;
                    }
                }
            }

            // Data Roti
            
            else if (menu == 2) {
                while (true) {
                    printRoti(namaRoti, hargaRoti, stockRoti);

                    System.out.println("===== MENU DATA =====");
                    System.out.println("1. Tambah Roti Baru");
                    System.out.println("2. Update Stock Roti");
                    System.out.println("3. Kembali Ke Menu Awal");

                    System.out.println();
    
                    int menuData;
    
                    System.out.print("Masukkan Menu yang ingin dipilih (1-3) : ");
                    menuData = sc.nextInt();
    
                    if (menuData == 1) {
                            String namaRotiBaru;
                            double hargaRotiBaru;
                            int stockRotiBaru;

                            sc.nextLine();
    
                            System.out.print("Nama Roti : ");
                            namaRotiBaru = sc.nextLine();
    
                            System.out.print("Harga Roti : ");
                            hargaRotiBaru = sc.nextDouble();

                            System.out.print("Stock Roti : ");
                            stockRotiBaru = sc.nextInt();

                            String namaRotiBaru2[] = new String[namaRoti.length + 1];
                            double hargaRotiBaru2[] = new double[hargaRoti.length + 1];
                            int stockRotiBaru2[] = new int[stockRoti.length + 1];

                            for (int i = 0; i < namaRoti.length; i++) {
                                namaRotiBaru2[i] = namaRoti[i];
                                hargaRotiBaru2[i] = hargaRoti[i];
                                stockRotiBaru2[i] = stockRoti[i];
                            }

                            namaRotiBaru2[namaRoti.length] = namaRotiBaru;
                            hargaRotiBaru2[hargaRoti.length] = hargaRotiBaru;
                            stockRotiBaru2[stockRoti.length] = stockRotiBaru;

                            namaRoti = namaRotiBaru2;
                            hargaRoti = hargaRotiBaru2;
                            stockRoti = stockRotiBaru2;

                            System.out.println("Penambahan Roti Baru Berhasil");
                            
                            System.out.println();

                    } else if (menuData == 2) {
                        int kodeRotiUpdate = 0, stockRotiUpdate = 0;
                        System.out.print("Kode Roti : ");
                        kodeRotiUpdate = sc.nextInt();
                        System.out.print("Stock Roti : ");
                        stockRotiUpdate = sc.nextInt();

                        stockRoti[kodeRotiUpdate-1] = stockRotiUpdate;

                        System.out.println("Stock Roti Berhasil Diupdate!");
                        System.out.println();

                    } else if (menuData == 3) {
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Menu Tidak Tersedia, Masukkan Lagi");
                        System.out.println();
                    }
                }
            }

            // Laporan Pendapatan

            else if (menu == 3) {
                System.out.println("===== DATA HARIAN =====");
                        
                    System.out.printf("-------------------------------------------%n");
                    System.out.printf("| %-5s | %-18s | %-10s |%n", "KODE", "NAMA ROTI", "KUANTITAS");
                    System.out.printf("-------------------------------------------%n");

                    int totalHarga = 0;

                    for (int i = 0; i < kodeRotiStored.length; i++) {
                        if(kodeRotiStored[i] == 0)
                            continue;
                        System.out.printf("| %-5s | %-18s | %-10d |%n", kodeRotiStored[i], namaRoti[kodeRotiStored[i] - 1], kuantitasRotiStored[i]);
                        // hargaRoti[kodeRotiStored[i] - 1] * kuantitasRotiStored[i], " "
                        // totalHarga += hargaRoti[kodeRotiStored[i] - 1] * kuantitasRotiStored[i];
                    }

                    System.out.printf("-------------------------------------------%n");
                    System.out.println("Total Pendapatan : " + totalPendapatan);
                    System.out.println();
            }

            // Moleh Sek Bolo
            
            else if (menu == 4) {

            } 
            
            // Seng nggenah lek ngelebokno angka, ojok kyk wong ndelosor ae
            
            else {
                System.out.println("Maaf Menu Tidak Tersedia, Silahkan Masukkan Angka Menu Yang Benar!");
            }
        }
    }

    static void printRoti(String[] namaRoti, double[] hargaRoti, int[] stockRoti){
        System.out.printf("---------------------------------------------------%n");
        System.out.printf("| %-5s | %-18s | %-10s | %5s |%n", "KODE", "NAMA ROTI", "HARGA", "STOCK");
        System.out.printf("---------------------------------------------------%n");

        for (int i = 0; i < namaRoti.length; i++) {
            System.out.printf("| %-5s | %-18s | %-10s | %5d |%n", (i + 1), namaRoti[i], hargaRoti[i], stockRoti[i]);
        }

        System.out.printf("---------------------------------------------------%n");

        System.out.println();
    }
}