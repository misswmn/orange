package test;

import org.junit.Test;

import java.io.*;

/**
 * @author wangmn
 * @date 2017/8/8
 */
public class TestField implements Serializable {
    private static final long serialVersionUID = -6738764310380613475L;
    private String fieldA;
    transient String fieldB;
    private static String fieldC;

    public String getFieldA() {
        return fieldA;
    }

    public void setFieldA(String fieldA) {
        this.fieldA = fieldA;
    }

    public String getFieldB() {
        return fieldB;
    }

    public void setFieldB(String fieldB) {
        this.fieldB = fieldB;
    }

    public static String getFieldC() {
        return fieldC;
    }

    public static void setFieldC(String fieldC) {
        TestField.fieldC = fieldC;
    }

    @Override
    public String toString() {
        return "fieldA=" + fieldA + "\n" + "fieldB=" + fieldB + "\n" + "fieldC=" + fieldC;
    }

    @Test
    public void test1() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/testfield"));
            TestField field = new TestField();
            field.setFieldA("fieldA");
            field.setFieldB("fieldB");
            field.setFieldC("fieldC");
            oos.writeObject(field);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/testfield"));
            TestField obj = (TestField) ois.readObject();
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

