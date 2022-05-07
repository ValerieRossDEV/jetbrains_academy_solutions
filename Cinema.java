package cinema2;

import java.util.Scanner;
import java.util.Arrays;

public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int numberOfRows = getRows();
        final int numberOfSeats = getSeats();
        cinemaMap(numberOfRows,numberOfSeats);
        System.out.println();
        System.out.println("Enter a row number:");
        int rowNumber = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = sc.nextInt();
        System.out.println(getPrice(numberOfRows,numberOfSeats,rowNumber,seatNumber));
        System.out.print("\n");
        reservedMap(numberOfRows,numberOfSeats,rowNumber,seatNumber);
    }
    public static int getSeats() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of seats in each row:");
        int numberSeats = sc.nextInt();
        return numberSeats;
    }
    public static int getRows() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberRows = sc.nextInt();
        return numberRows;
    }
    public static void cinemaMap(int rows, int seats) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i<=seats; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 1; i<=rows; i++) {
            for (int j = 1; j <= seats; j++) {
                if (j==1) {
                    System.out.print(i);
                }
                System.out.print(" S");
            }
            System.out.println();
        }
    }
    public static String getPrice(int rowN, int seatN, int row, int seat) {
        int frontPrice = 0;
        int backPrice = 0;
        if (rowN*seatN <=60) {
            return "Ticket price: $10";
        }
        else if (row>(rowN/2)) {
            return "Ticket price: $8";
        }
        return "Ticket price: $10";
    }
    public static void reservedMap(int rowN, int seatN, int row, int seat) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i<=seatN;i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        String[][] arr = new String[rowN][seatN+1];

        for (int i = 0; i<arr.length;i++){
            for (int j=0; j<arr[i].length;j++){
                arr[i][j] ="S ";
                if (j==0) {
                    arr[i][j]=(i+1)+" ";
                }
            }
        }
        arr[row-1][seat]="B ";
        for (int i = 0;i<arr.length;i++) {
            for (int j =0;j<arr[i].length;j++) {

                System.out.printf("%S",arr[i][j]);
            }
            System.out.println();
        }
    }
}
