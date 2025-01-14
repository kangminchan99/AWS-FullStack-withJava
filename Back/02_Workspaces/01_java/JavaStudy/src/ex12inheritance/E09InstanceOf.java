package ex12inheritance;


class Box {
    public void boxWrap() {
        System.out.println("box로 포장");
    }
}

class PaperBox extends Box {
    public void paperWrap() {
        System.out.println("PaperBox로 포장");
    }
}

class GoldPaperBox extends PaperBox {
    public void goldWrap() {
        System.out.println("GoldPaperBox로 포장");
    }
}
public class E09InstanceOf {

    // wrapBox가 Box타입의 객체를 받는다
    static void wrapBox(Box b) {
        // b가 GoldPaperBox이면 goldWrap 메서드 호출
        if(b instanceof GoldPaperBox) {
            ((GoldPaperBox) b).goldWrap();
        } else if (b instanceof PaperBox) {
            ((PaperBox) b).paperWrap();
        } else if (b instanceof  Box) {
            b.boxWrap();
        }
    }

    public static void main(String[] args) {
        Box box = new Box();
        PaperBox paperBox = new PaperBox();
        GoldPaperBox goldPaperBox = new GoldPaperBox();

        wrapBox(box);
        wrapBox(paperBox);
        wrapBox(goldPaperBox);

        String str = new String("who am i");
//        wrapBox(str);
    }
}
