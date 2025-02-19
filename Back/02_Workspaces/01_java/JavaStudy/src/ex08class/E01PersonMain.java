package ex08class;
/*
추상화(Abstraction): 현실 세계의 사물을 클래스로 형상화하는 것을 말한다.
Person클래스는 사람의 일반적인 속성을 클래스로 추상화한것이다.
클래스 선언시 class예약어를 사용한다. 클래스명의 첫글자는 반드시 대문자를 사용해야항ㄴ다.
또한 public 접근 지정자는 하나의 java파일에 한번만 사용할 수 있다.
public 클래스명은 파일명과 동일해야 하기 때문이다.
 */
class Person {
    /*
    멤버변수: 클래스에서 주로 속성(데이터)를 표현한다. 사람을 추상화한 클래스이므로 나이, 이름 등으로 정의된다.
     */
    String name = "minchan";
    int age = 55;
    String gender = "man";
    String jop = "etc";

    /*
    멤버 메서드: 클래스에서 객체의 동작을 표현한다. 클래스 외부에서 호출할때는 참조변수를 통해 .(닷)으로 접근한다. 또한 멤버
    변수는 멤버 메서드 내에서 즉시 사용할 수 있다.
     */
    void eat() {
        System.out.printf("%s가 식사를한다 %n", name);
    }

    /*
    넓은 지역(클래스)에서 생성된 멤버 변수는 좁은 지역(멤버 메서드)에서 사용할 수 있으므로 별도의
    전달없이 아래와 같이 출력문에서 사용할 수 있다.
     */
    void sleep() {
        System.out.printf("나이가 %d인 %s가 자고있다.%n", age, name);
    }
}
public class E01PersonMain {
    public static void main(String[] args) {
        /*
        Person클래스를 통해 인스턴스를 생성한다. 생성 시 할당된 주소값을 반환하고,
        좌측항의 참조변수가 그값을 할당받게 된다.
         */
        Person person = new Person();
        System.out.println(person); // 참조값이 출력된다 (ex08class.Person@30f39991)

        // 인스턴스 변수를 통해 멤버 메서드를 호출할 수 있다.
        person.eat();
        person.sleep();

        // 인스턴스 생성 직후 참조변수를 사용하지 않아도 호출할 수 있다.
        new Person().eat();
        new Person().sleep();
    }
}

