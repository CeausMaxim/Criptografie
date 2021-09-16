package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MetodaPolibius {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Encryption enc = new Encryption(reader.readLine());
        System.out.println("Зашифрованное сообщение: "+enc.getEncText());

        Description desc = new Description(enc.getEncText());
        System.out.println("Расшированное сообщение: "+desc.getDescText());
    }

    public static class Encryption {
        private String text = "";
        private String encText = "";
        protected static  char[][] key = {{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И'},
                                            {'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т'},
                                            {'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь'},
                                            {'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ё'},
                                            {'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п'},
                                            {'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'},
                                            {'ъ', 'ы', 'ь', 'э', 'ю', 'я', ' ', '.', ',', ')'},
                                            {'(', '?', '!', '_', '@', '1', '2', '3', '4', '5'},
                                            {'6', '7', '8', '9', '0', '*', '/', '+', '-', '\\'}};

        public Encryption(String text){
            this.text = text;
            findInArr(this.text);
        }

        public String getEncText(){
            return this.encText;
        }

        public void findInArr(String text){
            for(int i=0; i<text.length(); ++i){
                this.encText += charIn(text.charAt(i));
                System.out.println(text.charAt(i)+" -  "+this.encText);
            }
        }

        public String charIn(char c){
            String rez = "";
            for(int i=0; i<key.length; ++i){
                for(int j=0; j<key[i].length; ++j){
                    if(key[i][j] == c){
                        rez = rez + (i+""+j+" ");
                    }
                }
            }
            return rez;
        }
    }
}

    class Description{
        public String parseText;
        public String descText;

        public Description(String text){
            delAllSpace(text);
            outString(this.parseText);
        }

        public String getDescText(){
            return this.descText;
        }

        public void delAllSpace(String s){
            String rez = s.replaceAll(" ", "");
            this.parseText = rez;
            System.out.println(this.parseText);
        }

        public String outString(String s){
            String rez = "";
            int x, y;

            for(int i=0; i<s.length(); ++i){
                if(i%2 == 0){
                    x = Integer.parseInt(String.valueOf(s.charAt(i)));
                    y = Integer.parseInt(String.valueOf(s.charAt(i+1)));

                    System.out.println(s.charAt(i)+" "+i);
                    System.out.println(x+" "+y);

                    rez += MetodaPolibius.Encryption.key[x][y];
                }
            }
            this.descText = rez;
            return rez;
        }
    }
