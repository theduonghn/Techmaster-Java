package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Customer;
import model.Gender;
import util.LocalDateDeserializer;
import util.LocalDateSerializer;
import util.Validate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerService {
    Scanner sc = new Scanner(System.in);

    public ArrayList<Customer> getCustomerListFromFile(String filePath) {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(filePath);

            Type type = new TypeToken<ArrayList<Customer>>() {
            }.getType();

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
            gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
            Gson gson = gsonBuilder.setPrettyPrinting().create();

            customers = gson.fromJson(fileReader, type);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        }

        return customers;
    }

    public void showCustomer(Customer customer) {
        System.out.println(customer);
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
        String id;
        while (true) {
            System.out.print("Nhập mã khách hàng: ");
            id = sc.nextLine();
            if (Validate.validateCustomerIdPattern(customers, id)) {
                break;
            } else {
                System.out.println("Mã khách hàng không đúng định dạng");
            }
        }
        if (!Validate.validateCustomerIdAvailable(customers, id)) {
            System.out.println("Mã khách hàng đã được sử dụng");
            System.out.println("Thêm thông tin khách hàng thất bại");
            return null;
        }

        System.out.print("Nhập họ và tên: ");
        String fullName = sc.nextLine();

        LocalDate dateOfBirth = enterDateOfBirth();

        Gender gender = enterGender();

        System.out.print("Nhập quê quán: ");
        String hometown = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phone = sc.nextLine();

        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        Customer customer = new Customer(id, fullName, dateOfBirth, gender, hometown, phone, email);
        customers.add(customer);
        System.out.println("Thêm thông tin khách hàng thành công");
        return customer;
    }

    private LocalDate enterDateOfBirth() {
        while (true) {
            try {
                System.out.print("Nhập năm sinh: ");
                int year = Integer.parseInt(sc.nextLine());
                System.out.print("Nhập tháng sinh: ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.print("Nhập ngày sinh: ");
                int day = Integer.parseInt(sc.nextLine());
                LocalDate dateOfBirth = LocalDate.of(year, month, day);
                return dateOfBirth;
            } catch (Exception e) {
                System.out.println("Ngày tháng năm sinh không hợp lệ");
            }
        }
    }

    public void updateCustomerId(ArrayList<Customer> customers, Customer customer) {
        String id;
        while (true) {
            System.out.print("Nhập mã khách hàng mới: ");
            id = sc.nextLine();
            if (Validate.validateCustomerIdPattern(customers, id)) {
                break;
            } else {
                System.out.println("Mã khách hàng không đúng định dạng");
            }
        }
        if (!Validate.validateCustomerIdAvailable(customers, id)) {
            System.out.println("Mã khách hàng đã được sử dụng");
        } else {
            customer.setId(id);
        }
    }


    public void updateCustomerFullName(Customer customer) {
        System.out.print("Nhập họ và tên mới: ");
        String fullName = sc.nextLine();
        customer.setFullName(fullName);
    }

    public void updateCustomerDateOfBirth(Customer customer) {
        LocalDate dateOfBirth = enterDateOfBirth();
        customer.setDateOfBirth(dateOfBirth);
    }

    public void updateCustomerGender(Customer customer) {
        Gender gender = enterGender();
        customer.setGender(gender);
    }

    public void updateCustomerHometown(Customer customer) {
        System.out.print("Nhập quê quán mới: ");
        String hometown = sc.nextLine();
        customer.setHometown(hometown);
    }

    public void updateCusomerPhone(Customer customer) {
        String phone;
        while (true) {
            System.out.print("Nhập số điện thoại mới: ");
            phone = sc.nextLine();
            if (Validate.validatePhone(phone)) {
                customer.setEmail(phone);
                break;
            } else {
                System.out.println("Số điện thoại không đúng định dạng");
            }
        }
    }

    public void updateCusomerEmail(Customer customer) {
        String email;
        while (true) {
            System.out.print("Nhập email mới: ");
            email = sc.nextLine();
            if (Validate.validateEmail(email)) {
                customer.setEmail(email);
                break;
            } else {
                System.out.println("Email không đúng định dạng");
            }
        }
    }

    private Gender enterGender() {
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
        return gender;
    }

    public void deleteCustomer(ArrayList<Customer> customers, Customer customer) {
        customers.remove(customer);
    }

    public Map<Gender, Integer> countCusomersByGender(ArrayList<Customer> customers) {
        Map<Gender, Integer> count = new HashMap<>();
        for (Customer customer : customers) {
            if (count.get(customer.getGender()) == null) {
                count.put(customer.getGender(), 1);
            } else {
                count.put(customer.getGender(), count.get(customer.getGender()) + 1);
            }
        }
        return  count;
    }
}
