import java.util.Scanner;
public class realfinalproject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Login dengan Multi User

        System.out.println("===== LOGIN USER =====");
        String username[] = {"Sufyan", "Raihan", "Vita"};
        String password[] = {"Bagaskara", "Abdi", "Ativ"};

        String usernameLogin, passwordLogin;
        char login = 'n';
        
        while (true) {
            System.out.print("Username: ");
            usernameLogin = sc.nextLine();
            System.out.print("Password: ");
            passwordLogin = sc.nextLine();

            System.out.println();

            for (int i = 0; i < username.length; i++) {
                if (usernameLogin.equals(username[i]) && passwordLogin.equals(password[i])) {
                    System.out.println("Selamat Datang Kembali " + username[i]);
                    login = 'y';
                    break;
                } else {
                    System.out.println("Maaf Username atau Password anda Salah");
                    break;
                }
            }

            System.out.println();

            if (login == 'y') {
                break;
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

            //Global Variable

            String namaRoti[] = {"Roti Abon", "Roti Pizza", "Roti Moy", "Roti Sosis", "Roti Mily Cheese"};
            double hargaRoti[] = {7500, 6500, 7000, 7000, 6000};
            int stockRoti[] = {10, 5, 15, 13, 8};
            char keluar;
    
            // Transaksi

            if (menu == 1) {
                while (true) {
                    int kodeRoti = 0, kuantitasRoti = 0;
                    double totalHarga = 0, totalHargaDiskon = 0, uangPembeli = 0, kembalian = 0 , diskon = 0;
                    char tambahRoti, membership;

                    System.out.printf("---------------------------------------------------%n");
                    System.out.printf("| %-5s | %-18s | %-10s | %5s |%n", "KODE", "NAMA ROTI", "HARGA", "STOCK");
                    System.out.printf("---------------------------------------------------%n");

                    for (int i = 0; i < namaRoti.length; i++) {
                        System.out.printf("| %-5s | %-18s | %-10s | %05d |%n", (i + 1), namaRoti[i], hargaRoti[i], stockRoti[i]);
                    }

                    System.out.printf("---------------------------------------------------%n");

                    System.out.println();

                    while (true) {
                        System.out.print("Kode Roti: ");
                        kodeRoti = sc.nextInt();
                        System.out.print("Kuantitas Roti: ");
                        kuantitasRoti = sc.nextInt();

                        System.out.println();

                        // Pengurangan Stock
                        stockRoti[kodeRoti-1] -= kuantitasRoti;

                        totalHarga = totalHarga + (hargaRoti[kodeRoti-1] * kuantitasRoti);

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

                    System.out.println();

                    while (true) {
                        System.out.print("Uang Pembeli : ");
                        sc.nextDouble();
                        if (uangPembeli < totalHargaDiskon) {
                            break;
                        } else {
                            System.out.println("Uang Kurang dari Total Harga, Masukkan Lagi!");
                        }
                    }

                    kembalian = totalHargaDiskon - uangPembeli;
                    System.out.println(kembalian);

                    System.out.println();

                    System.out.print("Transaksi Baru ? (y/t) : ");
                    keluar = sc.next().charAt(0);

                    System.out.println();

                    if (keluar == 'y') {
                        continue;
                    } else if (keluar == 't') {
                        break;
                    }
                }
            }

            // Data Roti
            
            else if (menu == 2) {
                
            }

            // Laporan Pendapatan
            
            else if (menu == 3) {
                
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
}
