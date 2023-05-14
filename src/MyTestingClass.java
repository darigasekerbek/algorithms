public class MyTestingClass { //This is a sample testing class that contains a phone number and a full name.
    private int phnumber;
    private String fullname;

    public MyTestingClass(int phnumber, String fullname){
        this.phnumber = phnumber;
        this.fullname = fullname;
    }
    public int hashCode(){ //returns the hash code
        int prime = 31;
        int res = 1;
        res = prime * res + phnumber;
        res = prime * res + ((fullname == null) ? 0 : fullname.hashCode());
        return res;
    }

    @Override
    public boolean equals(Object obj) { //checks if current object is equal to the given object obj
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        MyTestingClass o = (MyTestingClass) obj;
        return phnumber == o.phnumber && fullname.equals(o.fullname);
    }
    public String toString(){ //returns string representation of the object as text
        return "MyTestingClass{" +
                "phone number" + phnumber +
                ", fullname" + fullname + "}";
    }
}
