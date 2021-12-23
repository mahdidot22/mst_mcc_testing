package com.mahdi.d.o.taha.lib.checkStyleExample;

import java.util.Scanner;

public class CheckStyleSample {

    private static final int ACCEPTABLE_HOLIDAYS = 4; // per month
    private static final int ACCEPTABLE_HOLIDAYS_100 = 100;
    private static final double SAL_PER_MONTH = 1300; // shekels  (Weekly325)
    private static final String FULL_TIME_EMPLOYEE = "FT";
    private static final String PART_TIME_EMPLOYEE = "PT";

    public static void main(String[] args) {
        person person = new person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        person.setUser_name(scanner.nextLine());
        System.out.println("Enter your Password: ");
        person.setUserPsw(scanner.nextLine());
        System.out.println("Enter your Email: ");
        person.setUserEmail(scanner.nextLine());
        System.out.println("Enter your Phone: ");
        person.setUser_Phone(scanner.nextLine());
        System.out.println("Enter your Work/Type: FT(Full Time) "
                + "|| PT(Part Time) ");
        person.setUserType(scanner.nextLine());
        System.out.println("Holidays Time is? ");
        person.setHolidays(scanner.nextInt());
        int holidaysFlag = ACCEPTABLE_HOLIDAYS - person.getHolidays();
        if (person.getUserType().equalsIgnoreCase(FULL_TIME_EMPLOYEE)) {
            if (holidaysFlag >= 0) {
                print(person.getUserName(), person.getUserEmail(), person.getUser_Phone(), String.valueOf(SAL_PER_MONTH));
            } else if ((holidaysFlag + ACCEPTABLE_HOLIDAYS_100) == 0) {
                print(person.getUserName(), person.getUserEmail(), person.getUser_Phone(), String.valueOf(0.0));
            } else {
                print(person.getUserName(), person.getUserEmail(), person.getUser_Phone(), String.valueOf(SAL_PER_MONTH));
            }
        } else if (person.getUserType().equalsIgnoreCase(PART_TIME_EMPLOYEE)) {
            if (holidaysFlag >= 0) {
                print(person.getUserName(), person.getUserEmail(), person.getUser_Phone(), String.valueOf(SAL_PER_MONTH));
            } else {
                double sal = SAL_PER_MONTH + ((SAL_PER_MONTH / 4) / 7) * holidaysFlag;
                double dis = ((SAL_PER_MONTH / 4) / 7) * holidaysFlag;
                print(person.getUserName(), person.getUserEmail(), person.getUser_Phone(), String.valueOf(sal));
                print(String.valueOf(dis));

            }
        }

    }


    public static class person{
        private String user_name;
        private String userPsw;
        private String UserEmail;
        private String User_Phone;

        public String getUserType() {
            return UserType;
        }

        public void setUserType(String userType) {
            UserType = userType;
        }

        private String UserType;
        private int holidays;

        public int getHolidays() {
            return holidays;
        }

        public void setHolidays(int holidays) {
            this.holidays = holidays;
        }

        public String getUserName() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUserPsw() {
            return userPsw;
        }

        public void setUserPsw(String userPsw) {
            this.userPsw = userPsw;
        }

        public String getUserEmail() {
            return UserEmail;
        }

        public void setUserEmail(String userEmail) {
            UserEmail = userEmail;
        }

        public String getUser_Phone() {
            return User_Phone;
        }

        public void setUser_Phone(String user_Phone) {
            User_Phone = user_Phone;
        }

    }
    protected static void print(String str1,String str2,String str3,String st4){
        System.out.println("Username: "+ str1);
        System.out.println("Email: "+ str2);
        System.out.println("Phone: "+ str3);
        System.out.println("Salary: "+ st4);
    }

    static void print(String str){
        System.out.println(str);
    }
}
