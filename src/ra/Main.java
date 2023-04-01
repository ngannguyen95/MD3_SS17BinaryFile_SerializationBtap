package ra;

import ra.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Product> listProduct = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    static String PATH_FILE = "C:\\Users\\Admin\\Desktop\\rikkei_data\\Java\\A.Test\\ioBinaryFile_Serialization\\src\\ra\\product.txt";


    public static void main(String[] args) {
        while (true) {
            System.out.println("**************Quản lí sản phẩm******************\n" +
                    "1.Thêm sản phẩm \n" +
                    "2.Hiển thị \n" +
                    "3.Tìm kiếm thông tin sản phẩm \n" +
                    "4.Thoát");
            System.out.println("Nhập vào lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void create() {
        System.out.println("Nhập số sản phẩm thêm mới:");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập vào sản phẩm thứ: " + (i + 1));
            Product newProduct = new Product();
            if (listProduct.isEmpty()) {
                newProduct.setProductId(1);
            } else {
                newProduct.setProductId(listProduct.get(listProduct.size() - 1).getProductId() + 1);
            }
            newProduct.inputData();
            listProduct.add(newProduct);
        }
        writeToFile(PATH_FILE, listProduct);
    }

    public static void show() {
        List<Product> products = readDataFromFile(PATH_FILE);
        for (Product pd : products) {
            System.out.println(pd);
        }
    }

    public static void search() {
        System.out.println("Nhập vào tên cần tìm kiếm: ");
        String nameSearch = scanner.nextLine();
        for (Product product : listProduct) {
            if (product.getProductName().equals(nameSearch)) {
                product.displayData();
            }
        }
    }

    // thực hiện ghi file
    public static void writeToFile(String path, List<Product> products) {
        File file = null;
        try {
            file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            fos.close();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // đọc file
    public static List<Product> readDataFromFile(String path) {
        List<Product> products = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File file = null;
        try {
            file = new File(path);
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                products = (List<Product>) ois.readObject();
                fis.close();
                ois.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

}
