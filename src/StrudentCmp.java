import com.sun.xml.internal.bind.v2.TODO;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StudentCmp implements Comparable{
//    @CompareOrder(1)
    public int indeks;
//    @CompareOrder()
    public List<Float> oceny;
    @CompareOrder(2)
    public String imie;
    @CompareOrder(1)
    public String nazwisko;
//    @CompareOrder()
    public boolean stacjonarny;



    public StudentCmp(Integer indeks, String imie, String nazwisko, Boolean stacjonarny){

        this.indeks = indeks;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stacjonarny = stacjonarny;
    }


    @Override
    public int compareTo(Object o) {
        Field[] fields = this.getClass().getFields();
        List<Field> fieldList = Arrays.asList(fields).stream().filter(field -> Modifier.isPublic(field.getModifiers())).collect(Collectors.toList());
        fieldList.removeIf(field -> field.getAnnotation(CompareOrder.class) == null);
        System.out.println(fieldList);

        HashMap<Integer, Field> productMap = new HashMap<>();
        for (Field field : fieldList) {
            productMap.put(field.getAnnotation(CompareOrder.class).value(), field);
        }
        // Default sorted ASC by CompareOrder(_PARAM)
        System.out.println(productMap);

        for(HashMap.Entry<Integer, Field> field : productMap.entrySet()) {
            Field fieldCmp = field.getValue();
            if(fieldCmp.getType() == String.class){
                try {
                    String str1 = (String)fieldCmp.get(this);
                    String str2 = (String)fieldCmp.get(o);
                    int value = str1.compareTo(str2);

                    if (value != 0)
                        return value;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }else if(fieldCmp.getType() == Integer.class){
//                TODO Int
//                try {
//                    String str1 = (String)fieldCmp.get(this);
//                    String str2 = (String)fieldCmp.get(o);
//                    int value = str1.compareTo(str2);
//
//                    if (value != 0)
//                        return value;
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
            }
        }
        return 0;
    }
    @Override
    public String toString(){
        return "indeks: "+ this.indeks + "\t imie: " + this.imie + "\t nazwisko: " + this.nazwisko + " stacjonarny: " + this.stacjonarny + "\n";
    }
}