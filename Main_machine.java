import java.util.Scanner;

class Delay { //커피 추출의 현실감을 위하여 딜레이를 주기위해 만든 시간지연 클래스이다.
    int i, j, k;
    void Delay(int s) {
        for (k = 0 ; k < s ; k++) //강제로 많은 수를 연산하게 만들어 일정 시간 지연효과를 준다.
            for (i = 0 ; i < 100000 ; i++) // 단, 컴퓨터 마다 클럭수가 다르므로 얼만큼 지연되는지는
                for (j = 0 ; j < 10000 ; j++); // 컴퓨터에 따라 다르다. 내컴퓨터에 맞게 최적화 되었다.
    }                                         //i5-8265U @1.6Ghz upto 3.2Ghz  에서는 2초 내외의 지연효과
}
//블랙커피 제조 클래스
class BlackCoffee {
    String bean = "원두";
    String water = "물";
    String cup = "종이컵";
    void hotwater() {
        System.out.println("뜨거운" + water + "을 준비중입니다.");
        Delay d = new Delay();
        d.Delay(3);
        System.out.println("물 온도 : 97 ℃");
        d.Delay(3);
    }
    void mix() {
        System.out.println(bean + "와 " + water + "을 추출 중입니다.");
        Delay d = new Delay();
        d.Delay(3);
    }
    void fillcup() {
        System.out.println(cup + "에 담는 중입니다.");
        Delay d = new Delay();
        d.Delay(3);
    }
    void finish() {
        System.out.println("|         |"); //커피 모양 UI로 마무리
        System.out.println("|_________|");
        System.out.println("|         |");
        System.out.println("|  고오급 |");
        System.out.println("|  coffee |");
        System.out.println("└---------┘");
    }
}

//설탕커피 제조 클래스
class SugarCoffee extends BlackCoffee {
    String sugar = "설탕";
    void add() {
        System.out.println(sugar + "을 추가합니다.");
        Delay d = new Delay();
        d.Delay(3);
    }
}

//프림커피 제조 클래스
class PrimCoffee extends BlackCoffee {
    String prim = "프림";
    void add() {
        System.out.println(prim + "을 추가합니다.");
        Delay d = new Delay();
        d.Delay(3);
    }
}
public class Main_machine {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int num; //메뉴선택 변수
        String off_machine = "------자판기 종료------";
        BlackCoffee coffee1 = new BlackCoffee();  //블랙커피 제조 클래스
        SugarCoffee coffee2 = new SugarCoffee();  //설탕커피 제조 클래스
        PrimCoffee coffee3 = new PrimCoffee();    //프림커피 제조 클래스

        System.out.println("┌----------------------┐");
        System.out.println("|  고오급 커피 자판기  |");
        System.out.println("└----------------------┘");
        System.out.println("|---------메뉴---------|");
        System.out.println("| 1. 블랙커피 300원    |");
        System.out.println("| 2. 설탕커피 500원    |");
        System.out.println("| 3. 프림커피 700원    |");
        System.out.println("| 4. 동전반환          |");
        System.out.println("└----------------------┘");
        System.out.print("동전을 투입하세요 : ");
        int cash = stdin.nextInt();
        int cash1;

        while (cash >= 1) //메뉴 선택 기능 반복
        {
            System.out.println("현재 잔액 : "+cash+"원");
            System.out.print("메뉴 번호를 입력하세요 : ");
            num = stdin.nextInt();
            if (num == 1) {   //1번 커피를 선택 했을 때 작동하는 메소드
                if (cash>=300) {
                    coffee1.hotwater();
                    coffee1.mix();
                    coffee1.fillcup();
                    coffee1.finish();
                    cash = cash - 300;
                    if (cash == 0) //잔액이 0원이 되면 메뉴선택기 종료
                        break;
                }
                else{
                    System.out.println("잔액이 부족합니다.");
                    System.out.println(cash + "원이 반환 되었습니다.");
                    break;
                }
            }
            else if (num == 2){
                if (cash>=500) {
                    coffee2.hotwater();
                    coffee2.mix();
                    coffee2.add(); // 설탕 추가
                    coffee2.fillcup();
                    coffee2.finish();
                    cash = cash - 500;
                    if (cash == 0)  //잔액이 0원이 되면 메뉴선택기 종료
                        break;
                }
                else {
                    System.out.println("잔액이 부족합니다.");
                    System.out.println(cash + "원이 반환 되었습니다.");
                    break;
                }
            }
            else if (num == 3){
                if (cash>=700) {
                    coffee3.hotwater();
                    coffee3.mix();
                    coffee3.add(); //프림 추가
                    coffee3.fillcup();
                    coffee3.finish();
                    cash = cash - 700;
                    if (cash == 0)  //잔액이 0원이 되면 메뉴선택기 종료
                        break;
                }
                else {
                    System.out.println("잔액이 부족합니다.");
                    System.out.println(cash + "원이 반환 되었습니다.");
                    break;
                }
            }
            else if(num == 4) {
                System.out.println(cash + "원이 반환 되었습니다.");
                break;
            }
            else {
                System.out.println("비정상 입력 입니다.");
            }
            System.out.println("현재 잔액 : "+cash+"원");
            System.out.print("금액을 추가하세요(-1 입력시 종료) : ");
            cash1 = stdin.nextInt();
            if (cash1 == -1) {
                System.out.println(cash + "원이 반환 되었습니다.");
                cash = cash + cash1;
                break;
            }
        }
        System.out.println(off_machine); // 종료
    }
}