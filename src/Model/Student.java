package Model;

public class Student {

        private  Integer id;
        private  String  name;
        private  String  sex;
        private  String object;

        // create default constructor
        public Student() {
        }
        // create default constructor with parameter
        public Student(Integer id, String name, String sex, String object) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.object = object;
        }

        // create to String

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", object='" + object + '\'' +
                    '}';
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}

