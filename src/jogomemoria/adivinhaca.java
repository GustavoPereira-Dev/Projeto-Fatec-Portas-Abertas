package model.estrutura;

import java.util.Scanner;
import java.util.Random;

public class adivinhaca
{
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    private int chute;
    private int num;

    public adivinhaca()
    {
        this.chute = chute;
        this.num = num;
    }

    public int gerarNum(int num)
    {
        num = random.nextInt(101);
        return num;
    }

    public int receberChute(int chute)
    {
        System.out.println("Chute de 0 a 100: ");
        chute = input.nextInt();
        return chute;
    }

    public void jogar()
    {
        int nume = 0;
        int chut = 105;

        nume = gerarNum(nume);
        chut = receberChute(chut);

        while(chut != num)
        {
            if(chut == nume)
            {
                System.out.println("Acertou.");
                break;
            }
            else if(chut > nume)
            {
                System.out.println("O número é menor.");
            }
            else if(chut < nume)
            {
                System.out.println("O número é maior.");
            }
            chut = receberChute(chut);
        }
    }
}
