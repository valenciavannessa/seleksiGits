package seleksigits;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import static jdk.nashorn.internal.objects.NativeArray.reverse;

/**
 *
 * @author ASUS
 */
public class SeleksiGits {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
//        System.out.println("========NOMOR 1======");
//        System.out.println("Input : ");
//        int no1 = input.nextInt();
//        
//        String output = nomor1(no1);
//        System.out.println("Output : " + output);
//        
//        System.out.println("========NOMOR 2======");
//        System.out.println("Jumlah pemain : ");
//        int jml_pemain = input.nextInt();
//        
//        System.out.println("Daftar skor (terbesar - terkecil) : ");
//        Scanner skor = new Scanner(System.in);
//        int[] array_skor = new int[jml_pemain];
//        
//        for(int i = 0; i < jml_pemain; i++) {
//            if(skor.hasNextInt()) {
//                array_skor[i] = skor.nextInt();
//            }
//        }
//
//        System.out.println("Jumlah permainan yang diikuti : ");
//        int jml_game = input.nextInt();
//        
//        System.out.println("Skor yang didapat : ");
//        Scanner skor_game = new Scanner(System.in);
//        int[] array_skor_game = new int[jml_game];
//        
//        for(int i = 0; i < jml_game; i++) {
//            if(skor_game.hasNextInt()) {
//                array_skor_game[i] = skor_game.nextInt();
//            }
//        }
//        
//        String hasil = nomor2(jml_pemain,array_skor, jml_game, array_skor_game);
//        System.out.println("Output : " + hasil);
        
        System.out.println("========NOMOR 3======");
        System.out.println("Input : ");
        String no3 = input.nextLine();
        
        String result = checkBalancedBracket(no3);
        System.out.println(result);
    }
    
    
    public static String nomor1(int n) {
        if(n < 1) {
            String error = "Input kurang dari 1";
            return error;
        }
        
        StringBuilder hasil =  new StringBuilder();
        int term = 1;
        
        for(int i = 1; i <= n; i++){
            term += i - 1;
            hasil.append(term).append("-");
        }
        
        return hasil.deleteCharAt(hasil.length() - 1).toString();
    }
    
    public static String nomor2(int jml_pemain, int[] array_skor, int jml_game, int[] array_skor_game){
        int i = 0, j = 0, k = 0;
        int[] array_gabungan = new int[jml_pemain + jml_game];
        
        while(i < jml_pemain) {
            array_gabungan[k++] = array_skor[i++];
        }
        while(j < jml_game) {
            array_gabungan[k++] = array_skor_game[j++];
        }
        
        Integer[] array_fix_objects = Arrays.stream(array_gabungan).boxed().toArray(Integer[]::new);
        Arrays.sort(array_fix_objects, Collections.reverseOrder());
        
        for (int p=0; p < jml_pemain + jml_game; p++) {
            array_gabungan[p] = array_fix_objects[p];
        }
        
        int[] array_fix = hapusDuplikat(array_gabungan);
        
        String hasil = cariIndex(array_skor_game, array_fix);
        return hasil;
    }
    
    public static int[] hapusDuplikat(int array[]) {
        int n = array.length;
        int[] temp = new int[n];
        int j = 0;
        
        for (int i = 0; i < n-1; i++) {
            if(array[i] != array[i+1]){
                temp[j++] = array[i];
            }
        }
        temp[j++] = array[n-1];
        
        return temp;
    } 
    
    public static String cariIndex(int array1[],int array2[]) {        
        int len1 = array1.length;
        int len2 = array2.length;
        int i = 0, j = 0;
        StringBuilder result =  new StringBuilder();
        int term = 1;
        
        for(i = 0; i < len1; i++){
            for(j = 0; j < len2; j++){
                if(array1[i] == array2[j]) {
                    term =  j + 1;
                    result.append(term).append(" ");
                }
            }
        }
                
        return result.toString();
    }
    
    public static String nomor3(String kurung) {
        
        return "";
    }
    
    public static String checkBalancedBracket(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder explanation = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                // Jika karakter adalah buka kurung, tambahkan ke dalam stack
                stack.push(currentChar);
            } else {
                // Jika karakter adalah tutup kurung
                if (stack.isEmpty()) {
                    explanation.append("String ").append(currentChar).append(" tidak memiliki pasangan buka.\n");
                    return "NO\n" + explanation.toString();
                }

                char topChar = stack.pop();
                if (currentChar == ')' && topChar != '(' ||
                    currentChar == ']' && topChar != '[' ||
                    currentChar == '}' && topChar != '{') {
                    explanation.append("String ").append(input).append(" tidak seimbang untuk karakter yang diapit.").append(currentChar).append(" ").append(topChar);
                    return "NO\n" + explanation.toString();
                }
            }
        }

        // Pastikan stack kosong setelah memproses semua karakter
        if (!stack.isEmpty()) {
            explanation.append("Bracket ").append(stack.pop()).append(" tidak memiliki pasangan tutup.\n");
            return "NO\n" + explanation.toString();
        }

        return "YES";
    }
}
