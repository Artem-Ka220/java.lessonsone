package ru.gb.sokolov;

public class Employer {
    String name;
    String position;
    String email;
    int numberPhone;
    private int salary;
    private int age;

    public Employer(String name, String position, String email, int numberPhone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.numberPhone = numberPhone;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary >= 15000 && salary <= 200000) {
            this.salary = salary;
        } else  {
            System.out.println("У нас на предприятии меньше 15-ти и больше 200-т тысяч не платят.");
        }
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        }else {
            System.out.println("Возраст сотрудника не может быть меньше 18-ти и больше 65 лет.");
        }
    }
    public void info(){
        System.out.println("Карта с данными сотрудника.\nФИО: "+name+";\nДолжность: "+position+";\nЭлектронная почта: "+email+";\nТел. номер: "+numberPhone+";\nОклад: "+salary+";\nВозраст: "+age+".");
    }
}
