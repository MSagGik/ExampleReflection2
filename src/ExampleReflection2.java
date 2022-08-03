import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ExampleReflection2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // считывание с консоли названия двух классов и одного метода (пример: Person java.lang.String setName)
        Scanner scanner = new Scanner(System.in);
        // пример строки: "Название_класса1 Название_класса2 Название_метода"
        Class classObject1 = Class.forName(scanner.next()); // считывание первого слова (Название_класса1)
        Class classObject2 = Class.forName(scanner.next()); // считывание второго слова (Название_класса2)
        String methodName = scanner.next(); // считывание третьего слова (Название_метода)
        // получение данного метода у первого класса и передача данному методу объекта второго класса
        Method m = classObject1.getMethod(methodName, classObject2);
        // создание объекта первого класса
        Object o1 = classObject1.newInstance();
        // создание конструктора второго класса который принимает на вход строковые значения
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");
        // вызов метода объекта о1 с аргументом о2
        m.invoke(o1, o2);
        // вывод на экран о1
        System.out.println(o1);
    }
}
