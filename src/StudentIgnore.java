import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class StudentIgnore {
    @IgnoreEquals()
    public int indeks;
    @IgnoreEquals
    public List<Double> oceny;
    public String imie;
    public String nazwisko;
    @IgnoreEquals
    public String stopien_studiow;


    public StudentIgnore(int indeks, String imie, String nazwisko, String stopen, ArrayList<Double> ocenyLista){
        this.indeks = indeks;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stopien_studiow = stopen;
        this.oceny = ocenyLista;
    }

    @Override
    public boolean equals(Object s) {

        Field[] fields = this.getClass().getFields();
        List<Field> fieldList = Arrays.asList(fields).stream().filter(field -> Modifier.isPublic(field.getModifiers())).collect(Collectors.toList());
        fieldList.removeIf(field -> field.getAnnotation(IgnoreEquals.class) != null);

        for (Field field : fieldList) {
            Object type = field.getType();

            if(type == int.class){
//                  JEBANA KURWA SILNIE TYPOWANA
//                Integer a = 4;
//                Integer b = 4;
//                int c = 4;
//                int d = 4;
//                System.out.println("test Integer: " + (a == b));
//                System.out.println("test int: " + (c == d));
//                System.out.println(field.get(s).getClass().getName() + "\n" +field.get(this).getClass().getName());
//                System.out.println(field.get(s) + "\n" +field.get(this));
//                System.out.println("field.get(this) != field.get(s) - "+((Integer) field.get(this) == (Integer) field.get(s)));

                Integer equal = null;
                try {
                    equal = (Integer) field.get(this) - (Integer) field.get(s);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (equal != 0) return false;
            }else if (type == String.class || type == List.class){
                try {
                    if (!field.get(this).equals(field.get(s))) return false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("Porowanie typu: "+type+" nie wspierane");
            }

        }

        return true;
    }
}