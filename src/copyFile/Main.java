package copyFile;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        copyFile("C:\\Users\\Admin\\Desktop\\rikkei_data\\Java\\A.Test\\ioBinaryFile_Serialization\\src\\copyFile\\source.txt","target.txt");
    }
    public static void copyFile(String source, String target) {
        try {
            // đọc file đầu vào theo đường dẫn
            File input = new File(source);
            // đọc file đầu ra theo đường dẫn
            File out = new File(target);
            //kiểm tra tập tin nguồn có tồn tại hay không hoặc tập tin đích đã tồn tại
            if (!input.exists() || out.exists()) {
                throw new FileNotFoundException();
            }
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(out);
            byte[] buf = new byte[1024];
            int length;
            while ((length = fis.read(buf)) > 0){
                fos.write(buf,0,length);
                System.out.println("File trong tệp đích: "+target.length());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
