package com.example.romano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConvertEmRomanoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConvertEmRomanoApplication.class, args);
    }
    @GetMapping("/romano")
    public String sayHello(@RequestParam(value = "convert", defaultValue = "World") String convert) {
        int temp = Integer.parseInt(convert);
        if (temp <= 99){
            String numRomano = ProcessarNumero(temp);
            return String.format("O número digitado em romano é %s!", numRomano);
        }else{
            return String.format("Opá amigão, por enquanto o app só aceita até 99");
        }
    }

    static String ProcessarNumero(int num){

        int tamInt = TamanhoDeDigitos(num);
        String numRomano = "";
        if (tamInt == 1) { //de zero a nove
            numRomano = UmIntParaRomano(num);
        }
        if (tamInt == 2) {
            String number = String.valueOf(num);
            String[] numberSplit = number.split("");
            //int num1 = Character.digit(numberSplit[0].charAt(0), 10);
            //int num2 = Character.digit(numberSplit[1].charAt(0), 10);

            String dec = RetornaRomano(numberSplit, tamInt);
            numRomano = dec;


        }

        return numRomano;
    }
    static String UmIntParaRomano(int i){
        String numRomano = "";
        switch (i) {
            case 0:
                numRomano = "0";
                break;
            case 1:
                numRomano = "I";
                break;
            case 2:
                numRomano = "II";
                break;
            case 3:
                numRomano = "III";
                break;
            case 4:
                numRomano = "IV";
                break;
            case 5:
                numRomano = "V";
                break;
            case 6:
                numRomano = "VI";
                break;
            case 7:
                numRomano = "VII";
                break;
            case 8:
                numRomano = "VIII";
                break;
            case 9:
                numRomano = "IX";
                break;
            default:
                break;
        }
        return numRomano;
    }
    static String UmCaractereParaRomano(String st){
        int num = Character.digit(st.charAt(0), 10);
        return UmIntParaRomano(num);
    }
    static int TamanhoDeDigitos(int n){
        String number = String.valueOf(n);
        String[] numberSplit = number.split("");
        return numberSplit.length;
    }
    static String RetornaRomano(String[] numSplit, int casasDec){
        //Esse método está aceitando números de apenas dois digitos, por enquanto.
        String resultado = "";
        switch (numSplit[0]) {
            case "1":
                if (numSplit[1] == "0") {
                    resultado = "X";
                }else{
                    if (UmCaractereParaRomano(numSplit[1]) == "0") {
                        resultado = "X";
                    } else {
                        resultado = "X" + UmCaractereParaRomano(numSplit[1]);
                    }
                }
                break;
            case "2":
                if (numSplit[1] == "0") {
                    resultado = "XX";
                }else{
                    if (UmCaractereParaRomano(numSplit[1]) == "0") {
                        resultado = "XX";
                    } else {
                        resultado = "XX" + UmCaractereParaRomano(numSplit[1]);
                    }
                }
                break;
            case "3":
                if (numSplit[1] == "0") {
                    resultado = "XXX";
                }else{
                    if (UmCaractereParaRomano(numSplit[1]) == "0") {
                        resultado = "XXX";
                    } else {
                        resultado = "XXX" + UmCaractereParaRomano(numSplit[1]);
                    }
                }
                break;
            case "4":
                if (numSplit[1] == "0") {
                    resultado = "XL";
                }else{
                    if (UmCaractereParaRomano(numSplit[1]) == "0") {
                        resultado = "XL";
                    } else {
                        resultado = "XL" + UmCaractereParaRomano(numSplit[1]);
                    }
                }
                break;
            case "5":
                if (numSplit[1] == "0") {
                    resultado = "L";
                }else{
                    if (UmCaractereParaRomano(numSplit[1]) == "0") {
                        resultado = "L";
                    } else {
                        resultado = "L" + UmCaractereParaRomano(numSplit[1]);
                    }
                }
                break;
            case "6":
                if (numSplit[1] == "0") {
                    resultado = "LX";
                }else{
                    if (UmCaractereParaRomano(numSplit[1]) == "0") {
                        resultado = "LX";
                    } else {
                        resultado = "LX" + UmCaractereParaRomano(numSplit[1]);
                    }
                }
                break;
            case "7":
                if (numSplit[1] == "0") {
                    resultado = "LXX";
                }else{
                    if (UmCaractereParaRomano(numSplit[1]) == "0") {
                        resultado = "LXX";
                    } else {
                        resultado = "LXX" + UmCaractereParaRomano(numSplit[1]);
                    }
                }
                break;
            case "8":
                if (numSplit[1] == "0") {
                    resultado = "LXXX";
                }else{
                    if (UmCaractereParaRomano(numSplit[1]) == "0") {
                        resultado = "LXXX";
                    } else {
                        resultado = "LXXX" + UmCaractereParaRomano(numSplit[1]);
                    }
                }
                break;
            case "9":
                if (numSplit[1] == "0") {
                    resultado = "XC";
                }else{
                    if (UmCaractereParaRomano(numSplit[1]) == "0") {
                        resultado = "XC";
                    } else {
                        resultado = "XC" + UmCaractereParaRomano(numSplit[1]);
                    }
                }
                break;

            default:
                break;
        }
        return resultado;
    }
}
