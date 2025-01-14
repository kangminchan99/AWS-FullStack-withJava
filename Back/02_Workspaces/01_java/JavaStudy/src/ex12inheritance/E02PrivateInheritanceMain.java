package ex12inheritance;

// 부모 클래스
class Account {
    /*
    멤버 변수가 상속관계에 있다고 하더라도 private로 선언되면 클래스 내부에서만 접근할 수 있다.
    즉 상속받은 하위 클래스에서는 직접 접근이 불가능 하다.
     */
    private int money;

    /*
    이와 같이 개발자가 생성자를 직접 정의하면 디폴트 생성자는 추가되지 않는다. 디폴트 생성자는 개발자가 생성자를 정의하지 않았을 때만
    컴파일러에 의해 자동으로 추가된다.
     */
    public Account(int init) {
        money = init;
    }

    /*
    입금처리: protected로 선언 되었으므로 상속관계에서 접근이 가능하다.
    만약 자식 클래스와 패키지가 다르더라도 접근이 가능하다.
     */
    protected void depositMoney(int _money) {
        // 마이너스 금액은 입금 불가 처리
        if (_money < 0) {
            System.out.println("minus money");
            return;
        }
        // 금액이 양수일때만 입금처리
        money += _money;
    }

    /*
    현재는 부모와 자식클래스가 동일한 패키지에 정의되어 있으므로 접근지정자가 default라도 접근이 허용된다.
    즉 protected를 지워도 상관없다.
     */
    protected int getAccMoney() {
        return money;
    }
}

// 자식 클래스
class SavingAccount extends Account {
    /*
    인자 생성자에서 부모의 생성자를 호출하기 위한 super(x)를 사용한다.
    이때 매개변수가 하나인 부모 클래스의 생성자가 호출된다. 현재 부모클래스에는
    매개변수가 하나인 생성자가 유일하므로 만약 super(x)를 생략하면 에러가 발생한다.
     */
    public SavingAccount(int initVal) {
        /*
        해당 문장을 삭제하면 즉시 에러가 발생한다. 삭제하는 경우
        super()라는 문장, 즉 매개변수가 없는 디폴트 생성자를 호출하는
        문장이 자동으로 삽입되는데 부모 클래스에는 이런 생성자가 정듸되지 않았으므로 에러가 발생
         */
        super(initVal);
    }
    public void saveMoney(int money) {
        /*
        부모 클래스에 정의된 멤버 변수는 money는 private이므로 자식쪽에서는 보이지 않으므로 접근 불가. 따라서 접근 가능한 protected로
        선언된 메서드를 통해서 간접적으로 사용한다.
         */
        depositMoney(money);
//        super.money += money;
    }
    public void showAccountMoney(){
        System.out.println("누적 금액" + getAccMoney());
    }
}
public class E02PrivateInheritanceMain {
    public static void main(String[] args) {
        // 자식클래스를 통해 인스턴스 생성
        SavingAccount sa = new SavingAccount(10000);
        // private이므로 에러 발생
//        sa.money = 100000; -> 에러 발생
        sa.saveMoney(5000);
        sa.showAccountMoney();
        sa.saveMoney(-1000);
        sa.showAccountMoney();

        /*
        부모 클래스를 통해 인스턴스를 생성한다. 하지만 해당 인스턴스 변수를 통해서도 money에 접근할 수 없다
        현재 접근하려는 위치가 클래스 외부이기 때문이다. 즉 private 멤버는 무조건 클래스 내부에서만
        접근을 허용한다.
         */
        Account account = new Account(1000);
//        account.money = 1000; -> 에러 발생
    }
}
