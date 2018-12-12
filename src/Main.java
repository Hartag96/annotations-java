import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//@DefaultStudent(imie="Jan", ocena = 4, indeks = 2137)
//class  Student {
//    @IgnoreEquals()
//    public int indeks;
//    @IgnoreEquals
//    public List<Float> oceny;
//    public String imie;
//    public String nazwisko;
//    @IgnoreEquals
//    public String stopien_studiow;
//    public int ocena;
//
//    public static void main(String[] args) throws IllegalAccessException {
//        System.out.println("Hello World!");
//        Student student1 = new Student(100, "Dzban", "Mg", true);
//        student1.dane();
//
//        Student student2 = new Student(100, "Dzban", "Inz", true);
////        student2.oceny.add((float) 3.5);
//        System.out.println(student1.equals(student2));
//    }
//
//    public Student(int i, String nazwisko, String stopen, boolean b){
//        Class c = this.getClass();
//        DefaultStudent ds = (DefaultStudent)c.getAnnotation(DefaultStudent.class);
//
//        this.indeks = ds.indeks();
//        this.imie = ds.imie();
//        this.ocena = ds.ocena();
//        this.nazwisko = nazwisko;
//        this.stopien_studiow = stopen;
//        this.oceny = new ArrayList<Float>();
//        oceny.add((float) 2.5);
//        oceny.add((float) 4.5);
//    }
//    public void dane(){
//        System.out.println(this.imie + this.ocena + this.indeks);
//    }
//
//    public boolean equals(Student s) throws IllegalAccessException {
//        Field[] fields = this.getClass().getFields();
//        List<Field> fieldList = Arrays.asList(fields).stream().filter(field -> Modifier.isPublic(field.getModifiers())).collect(Collectors.toList());
//        fieldList.removeIf(field -> field.getAnnotation(IgnoreEquals.class) != null);
//
//        for (Field field : fieldList) {
//            Object type = field.getType();
//
//            if(type == int.class){
//                  JEBANA KURWA SILNIE TYPOWANA
////                Integer a = 4;
////                Integer b = 4;
////                int c = 4;
////                int d = 4;
////                System.out.println("test Integer: " + (a == b));
////                System.out.println("test int: " + (c == d));
////                System.out.println(field.get(s).getClass().getName() + "\n" +field.get(this).getClass().getName());
////                System.out.println(field.get(s) + "\n" +field.get(this));
////                System.out.println("field.get(this) != field.get(s) - "+((Integer) field.get(this) == (Integer) field.get(s)));
//
//                Integer equal = (Integer) field.get(this) - (Integer) field.get(s);
//                if (equal != 0) return false;
//            }else if (type == String.class || type == List.class){
//                if (!field.get(this).equals(field.get(s))) return false;
//            }else {
//                System.out.println("Porowanie typu: "+type+" nie wspierane");
//            }
//
//        }
//
//        return true;
//    }
//}

public class Main{


    public static void main(String[]args)throws IllegalAccessException{
        ArrayList<StudentCmp> list = new ArrayList<StudentCmp>();
        list.add(new StudentCmp(200,"Zan","Aihih",true));
        list.add(new StudentCmp(101,"Kasia","Aihih",false));
        list.add(new StudentCmp(201,"Wojciech","Baran",true));
//        System.out.println("".compareTo("bea"));

        System.out.println(Arrays.toString(list.toArray()));
        list.sort(StudentCmp::compareTo);
        System.out.println(Arrays.toString(list.toArray()));
    }
}