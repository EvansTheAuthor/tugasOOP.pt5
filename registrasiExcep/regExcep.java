package pertemuan5.registrasiExcep;
import java.util.Scanner;

public class regExcep {
    static class InvalidNameException extends Exception {
        public InvalidNameException(String message) {
            super(message);
        }
    }

    static void validateName(String name) throws InvalidNameException{
        if(name.isEmpty()){
            throw new InvalidNameException("Name cannot be blank");
        }

        for(char c:name.toCharArray()){
            if(!Character.isLetter(c)){
                throw new InvalidNameException("Name only can be written with letter");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
         String name="";
        int age=0;

        try {
            System.out.print("Enter your name: ");
            name=scanner.nextLine();
            validateName(name);
            System.out.print("Age: ");
            age=scanner.nextInt();

            if(age<0){
                throw new IllegalArgumentException("Age cannot be negative");
            }

            System.out.println("Registration succesfull!");
            System.out.println("Name: "+name+", "+age+" y.o.");
        }catch(InvalidNameException ex){
            System.out.println("Error --> "+ex.getMessage());
        } catch(IllegalArgumentException ex){
            System.out.println("Error --> "+ex);
        }finally{
            scanner.close();
        }
    }
}
