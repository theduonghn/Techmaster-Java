package controller;

import model.Customer;
import model.Gender;
import service.CustomerService;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController {
    Scanner sc = new Scanner(System.in);
    CustomerService service = new CustomerService();
    ArrayList<Customer> customers = service.getCustomerListFromFile("customers.json");
    boolean continueProgram = true;

    public void run() {
        menu();
    }

    public void menu() {
        while (continueProgram) {
            try {
                System.out.println("--------------------");
                System.out.println("1. Xem thông tin toàn bộ khách hàng");
                System.out.println("2. Xem thông tin khách hàng nữ");
                System.out.println("3. Xem thông tin khách hàng nam");
                System.out.println("4. Thêm thông tin khách hàng");
                System.out.println("5. Tìm kiếm thông tin khách hàng");
                System.out.println("0. Thoát chương trình");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        service.showCustomers(customers);
                        break;
                    case 2:
                        service.showCustomers(service.getCustomersByGender(customers, Gender.FEMALE));
                        break;
                    case 3:
                        service.showCustomers(service.getCustomersByGender(customers, Gender.MALE));
                        break;
                    case 4:
                        System.out.println("Nhập thông tin khách hàng: ");
                        Customer newCustomer = service.addCustomer(customers);
                        System.out.println("Thông tin khách hàng vừa thêm: ");
                        service.showCustomer(newCustomer);
                        break;
                    case 5:
                        System.out.print("Nhập mã khách hàng: ");
                        String id = sc.nextLine();
                        Customer customer = service.getCustomerById(customers, id);
                        if (customer != null) {
                            menuCustomer(customer);
                        } else {
                            System.out.println("Không có khách hàng nào có mã khách hàng như trên");
                        }
                        break;
                    case 0:
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Không có lựa chọn này");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public void menuCustomer(Customer customer) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("--------------------");
                service.showCustomer(customer);
                System.out.println("1. Sửa thông tin khách hàng");
                System.out.println("2. Xoá thông tin khách hàng");
                System.out.println("0. Về menu trước");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        menuUpdate(customer);
                        break;
                    case 2:
                        service.deleteCustomer(customers, customer);
                        continueLoop = false;
                        break;
                    case 0:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Không có lựa chọn này");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public void menuUpdate(Customer customer) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("--------------------");
                service.showCustomer(customer);
                System.out.println("1. Sửa mã khách hàng");
                System.out.println("2. Sửa họ tên");
                System.out.println("3. Sửa sửa ngày sinh");
                System.out.println("4. Sửa giới tính");
                System.out.println("5. Sửa quê quán");
                System.out.println("6. Sửa số điện thoại");
                System.out.println("7. Sửa email");
                System.out.println("0. Về menu trước");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        service.updateCustomerId(customers, customer);
                        break;
                    case 2:
                        service.updateCustomerFullName(customer);
                        break;
                    case 3:
                        service.updateCustomerDateOfBirth(customer);
                        break;
                    case 4:
                        service.updateCustomerGender(customer);
                        break;
                    case 5:
                        service.updateCustomerHometown(customer);
                        break;
                    case 6:
                        service.updateCusomerPhone(customer);
                        break;
                    case 7:
                        service.updateCusomerEmail(customer);
                        break;
                    case 0:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Không có lựa chọn này");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
