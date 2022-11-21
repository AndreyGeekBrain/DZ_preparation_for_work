package dz.collections.handmadecollections.handmadearray;

public class HumanTest {
    String name;
    int age;
    String sex;

    public HumanTest(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public HumanTest() {
    }

    @Override
    public String toString() {
        return "HumanTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
