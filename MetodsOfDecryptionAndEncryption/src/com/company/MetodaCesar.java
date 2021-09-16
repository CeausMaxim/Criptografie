package com.company;
import java.util.Scanner;

public class MetodaCesar {

    public static void main(String[] args) {
        System.out.println("[1 шифрование] [2 расшифровка], пожалуйста, выберите один");
        Scanner c=new Scanner(System.in);// Создать объект сканера
        String s1=c.nextLine();// Получить строку этой строки
        if(s1.equalsIgnoreCase("1")) {// Определяем, равны ли переменные s1 и A, и игнорируем размер
            System.out.println("Пожалуйста, введите простой текст:");
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            System.out.println("Пожалуйста, введите ключ: ");
            Scanner sc1=new Scanner(System.in);
            int key=sc1.nextInt();// Преобразовать следующий элемент ввода в int
            Encryption(s,key);// Вызываем метод шифрования
        }else if(s1.equalsIgnoreCase("2")) {
            System.out.println("Пожалуйста, введите зашифрованный текст:");
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            System.out.println("Пожалуйста, введите ключ: ");
            Scanner sc1=new Scanner(System.in);
            int key=sc1.nextInt();
            Decrypt(s,key);// Вызываем метод шифрования
        }
    }

    public static void Decrypt(String str, int n) {
        // расшифровываем
        int k=Integer.parseInt("-"+n);
        String string="";
        for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            
            if(c>='a'&& c<='z')// Если символ в строке строчный
            {
                c+=k%26;// мобильный ключ% 26 бит
                if(c<'a')
                    c+=26;// слева налево
                if(c>'z')
                    c-=26;// направо
            }else if(c>='A'&& c<='Z')// Если символ в строке в верхнем регистре
            {
                c+=k%26;// мобильный ключ% 26 бит
                if(c<'A')
                    c+=26;// слева налево
                if(c>'Z')
                    c-=26;// направо
            }
            string += c;// Объединяем расшифрованные символы в строку
        }
        System.out.println(str + " После расшифровки: " + string);
    }

    public static void Encryption(String str, int k) {
        // Зашифровать
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 'a' && c <= 'z')// если символ в строке строчный
            {
                c += k % 26;// ключ % 26 бит
                if (c < 'a')
                    c += 26;// слева налево
                if (c > 'z')
                    c -= 26;// направо
            } else if (c >= 'A' && c <= 'Z')// Если символ в строке в верхнем регистре
            {
                c += k % 26;// ключ % 26 бит
                if (c < 'A')
                    c += 26;// слева налево
                if (c > 'Z')
                    c -= 26;// направо
            }

            string += c;// Объединяем расшифрованные символы в строку
        }
        System.out.println(str + " После шифрования: " + string);
    }
}
