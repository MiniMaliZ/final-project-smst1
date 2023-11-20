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

            if (login == 'y') {
                break;
            }
        }
        
    }
}
