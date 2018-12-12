import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

class StudentCmp implements Comparable{
//    @CompareOrder(1)
    public int indeks;
    @CompareOrder(1)
    public List<Double> oceny;
    @CompareOrder(2)
    public String imie;
    @CompareOrder(3)
    public String nazwisko;
//    @CompareOrder(1)
    public Boolean stacjonarny;


    StudentCmp(Integer indeks, ArrayList<Double> oceny, String imie, String nazwisko, Boolean stacjonarny){
        this.indeks = indeks;
        this.oceny = oceny;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stacjonarny = stacjonarny;
    }


    @Override
    public int compareTo(Object o) {
        Field[] fields = this.getClass().getFields();
        List<Field> fieldList = Arrays.stream(fields).filter(field -> Modifier.isPublic(field.getModifiers())).collect(Collectors.toList());
        fieldList.removeIf(field -> field.getAnnotation(CompareOrder.class) == null);

        HashMap<Integer, Field> productMap = new HashMap<>();
        for (Field field : fieldList) {
            productMap.put(field.getAnnotation(CompareOrder.class).value(), field);
        }
        // Default sorted ASC by CompareOrder(_PARAM)

        for(HashMap.Entry<Integer, Field> field : productMap.entrySet()) {
            Field fieldCmp = field.getValue();

            if(fieldCmp.getType() == String.class){
                try {
                    String str1 = (String)fieldCmp.get(this);
                    String str2 = (String)fieldCmp.get(o);
                    Integer value = str1.compareTo(str2);

                    if (value != 0)
                        return value;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else if(fieldCmp.getType() == Integer.class){
                try {
                    Integer val1 = (Integer)fieldCmp.get(this);
                    Integer val2 = (Integer)fieldCmp.get(o);
                    Integer value = val1 - val2;

                    if (value != 0)
                        return value;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else if(fieldCmp.getType() == Boolean.class){
                try {
                    Integer val1 = (Boolean)fieldCmp.get(this) ? 1 : 0;
                    Integer val2 = (Boolean)fieldCmp.get(o) ? 1 : 0;
                    Integer value = val1 - val2;

                    if (value != 0)
                        return value;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else if(fieldCmp.getType() == List.class) {
                try {
                    ArrayList arr1 = (ArrayList)fieldCmp.get(this);
                    Double average1 = arr1.stream().mapToDouble(a -> (double) a).average().getAsDouble();

                    ArrayList arr2 = (ArrayList)fieldCmp.get(o);
                    Double average2 = arr2.stream().mapToDouble(a -> (double) a).average().getAsDouble();
                    System.out.println(average1 +""+ average2);
                    Double value = (average1 - average2);

                    if (value != 0)
                        return (int) Math.round(value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("Unsupportedd type: " + fieldCmp.getType());
            }
        }
         return 0;
    }
    @Override
    public String toString(){
        return "\n indeks: "+ this.indeks + "\t imie: " + this.imie + "\t nazwisko: " + this.nazwisko + " stacjonarny: " + this.stacjonarny + " oczeny:\t" + this.oceny.toString();
    }
}