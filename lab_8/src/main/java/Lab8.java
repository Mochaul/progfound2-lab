import java.util.Scanner;
import company.*;

class Lab8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] row;
        boolean exitFlag = false;
        
        int threshold = Integer.parseInt(in.nextLine());
        Company company = new Company("TAMPAN", threshold);

        while (true){
            // TAMBAH_KARYAWAN <TIPE> <NAMA_KARYAWAN> <GAJI_AWAL>
            // STATUS <NAMA_KARYAWAN>
            // TAMBAH_BAWAHAN <NAMA_YANG_MENAMBAHKAN> <NAMA_YANG_DITAMBAHKAN>
            row = in.nextLine().split(" ");
            switch(row[0]){
                case "TAMBAH_KARYAWAN":
                    System.out.println(company.addEmployee(row[2], row[1], Integer.parseInt(row[3])));    
                    break;
                case "STATUS":
                    System.out.println(company.status(row[1]));
                    break;
                case "TAMBAH_BAWAHAN":
                    System.out.println(company.recruit(row[1], row[2]));
                    break;
                case "GAJIAN":
                    company.payday();
                    break;
                case "exit":
                    exitFlag = true;
                    break;
                case "help":
                    System.out.printf("\navailable commands:\n" +
                                      "TAMBAH_KARYAWAN <TIPE> <NAMA_KARYAWAN> <GAJI_AWAL>\n" +
                                      "STATUS <NAMA_KARYAWAN>\n" +
                                      "TAMBAH_BAWAHAN <NAMA_YANG_MENAMBAHKAN> <NAMA_YANG_DITAMBAHKAN>\n" +
                                      "exit\n\n");
                    break;
                default:
                    System.out.println("invalid command. enter 'help' for list available commands");
            }
            if (exitFlag) break;
        }

    }
}