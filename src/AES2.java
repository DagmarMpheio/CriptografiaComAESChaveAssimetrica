
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagma
 */
public class AES2 {
    private static String ChaveSimetrica;
    private static String mensagem;
    private static SecretKey key;
    private static byte [] mensagemEncriptada;
    private static byte [] mensagemDencriptada;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("32 Caracteres = chave com 256 bits"+
                "\n24 caracteres = chave com 192 bits\n"+
                " 16 caracteres = chave com 128 bits"+
                "\n Informe uma chave :");
        ChaveSimetrica = sc.nextLine();
        key = new SecretKeySpec(ChaveSimetrica.getBytes(), "AES");
        
        try{
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            
            System.out.println("Informe a sua mensagem a ser encriptada: ");
            mensagem = sc.nextLine();
            
            mensagemEncriptada = cipher.doFinal(mensagem.getBytes());
            
            System.out.println(new String("Mensagem Encriptada: "+mensagemEncriptada));
            
            cipher.init(Cipher.DECRYPT_MODE, key);
            
            mensagemDencriptada = cipher.doFinal(mensagemEncriptada);
            
            String mensagemOriginal = new String(mensagemDencriptada);
            
            System.out.println("Mensagem Descriptada: "+mensagemOriginal);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
