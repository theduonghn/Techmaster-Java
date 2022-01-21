package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Customer;
import model.Gender;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {
    Scanner sc = new Scanner(System.in);

    public ArrayList<Customer> getCustomerListFromFile(String filePath) {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(filePath);

            Type type = new TypeToken<ArrayList<Customer>>() {
            }.getType();

            Gson gson = new Gson();

            customers = gson.fromJson(fileReader, type);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        }

        return customers;
    }

    public void showCustomers(ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public Customer getCustomerById(ArrayList<Customer> customers, String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public ArrayList<Customer> getCustomersByGender(ArrayList<Customer> customers, Gender gender) {
        ArrayList<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getGender() == gender) {
                result.add(customer);
            }
        }
        return result;
    }

    public Customer addCustomer(ArrayList<Customer> customers) {
        System.out.print("Nhập id: ");
        String id = sc.nextLine();

        System.out.print("Nhập họ và tên: ");
        String fullName = sc.nextLine();

        Gender gender;
        while (true) {
            try {
                System.out.println("1. Nam");
                System.out.println("2. Nữ");
                System.out.print("Chọn giới tính: ");
                int choiceGender = Integer.parseInt(sc.nextLine());
                if (choiceGender == 1) {
                    gender = Gender.MALE;
                    break;
                } else if (choiceGender == 2) {
                    gender = Gender.FEMALE;
                    break;
                } else {
                    System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bạn phải nhập số");
            }
        }

        System.out.print("Nhập quê quán: ");
        String hometown = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phone = sc.nextLine();

        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        Customer customer = new Customer(id, fullName, gender, hometown, phone, email);
        customers.add(customer);
        return customer;
    }
}
