package day20.Exception;

/**
 * 自定义异常
 */
public class Demo2 {
    public static void main(String[] args) {
        try {
            th(null);
        } catch (MyException e) {
            System.out.println("fhuri");
            // 打印堆栈信息，错误信息
            e.printStackTrace();
        }
    }

    /**
     * throws MyException--抛出异常
     * @param name
     * @throws MyException
     */
    public static void th(String name) throws MyException{
        if(name == null){
            // 抛出异常后，后面的代码不在执行
            throw new MyException("name不能为空");
        }

        System.out.println(name);
    }
}






