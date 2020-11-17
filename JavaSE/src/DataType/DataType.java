package DataType;

/**
 * @author 刘娟
 * @version 1.0
 * @since  1.8
 */

public class DataType {
    public static void main(String[] args) {
        // 整数拓展 进制
        int i =10;
        int i2 = 010;
        int i3 = 0x01;

        // 浮点数拓展  银行业务怎么表示 钱
        // BigDecimal
        // float  有限，离散，舍入误差 大约，接近但不等于
        //double
        // 最好完全避免使用浮点数比较
        float f = 0.1f; // 0.1
        double d = 1.0/10; // 0.1


        System.out.println(f == d) ; // false


        float d1 = 231231232443f;
        float d2 = d1+1;
        System.out.println(d1 ==d2); // true

        double d3 = Math.pow(2,3);

        // 字符扩展
        System.out.println("===================================================");

        char c1 = 'a';
        char c3 ='中';


    }
}
