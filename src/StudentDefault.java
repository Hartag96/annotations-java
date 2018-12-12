
@DefaultStudent(imie="Jan", ocena = 4, indeks = 2137)
class StudentDefault {
    public int indeks;
    public String imie;
    public int ocena;


    public StudentDefault(){
        Class c = this.getClass();
        DefaultStudent ds = (DefaultStudent)c.getAnnotation(DefaultStudent.class);

        this.indeks = ds.indeks();
        this.imie = ds.imie();
        this.ocena = ds.ocena();
    }

    @Override
    public String toString(){
        return this.indeks + " " + this.imie + " " + this.ocena;
    }
}