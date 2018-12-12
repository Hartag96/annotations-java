import java.util.ArrayList;
import java.util.Arrays;

public class Main{


    public static void main(String[]args)throws IllegalAccessException{

        // 1
        StudentDefault studentDefault = new StudentDefault();
        System.out.println(studentDefault.toString());

        // 2
        ArrayList<Double> oceny1 = new ArrayList<>();
        oceny1.add(3.5);
        oceny1.add(4.5);
        StudentIgnore studentIgnore1 = new StudentIgnore(100, "Jan", "Dzban", "Mgr", oceny1);

        ArrayList<Double> oceny2= new ArrayList<>();
        oceny2.add(3.5);
        oceny2.add(4.5);
        StudentIgnore studentIgnore2 = new StudentIgnore(100, "Jan","Dzban", "Inz", oceny2);

        System.out.println("Student object equals = " + studentIgnore1.equals(studentIgnore2));

        // 3

        ArrayList<Double> oceny3 = new ArrayList<>();
        oceny3.add(2.0);
        oceny3.add(2.5);
        oceny3.add(2.0);

        ArrayList<Double> oceny4 = new ArrayList<>();
        oceny4.add(3.5);
        oceny4.add(3.5);
        oceny4.add(2.0);

        ArrayList<Double> oceny5 = new ArrayList<>();
        oceny5.add(4.0);
        oceny5.add(5.5);
        oceny5.add(5.0);

        ArrayList<Double> oceny6 = new ArrayList<>();
        oceny6.add(2.0);
        oceny6.add(2.5);
        oceny6.add(2.0);

        ArrayList<StudentCmp> list = new ArrayList<StudentCmp>();
        list.add(new StudentCmp(200, oceny3,"Jan","Dzban",true));
        list.add(new StudentCmp(101, oceny4,"Basia","Ty",false));
        list.add(new StudentCmp(200, oceny5,"Wojciech","Baran",true));
        list.add(new StudentCmp(200, oceny6,"Juri","Ofsienko",false));

        System.out.println(Arrays.toString(list.toArray()));
        list.sort(StudentCmp::compareTo);
        System.out.println(Arrays.toString(list.toArray()));
    }
}