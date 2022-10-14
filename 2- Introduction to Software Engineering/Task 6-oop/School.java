public class School
{
   public static void main (String [] args)
   {
   
      Student sally = new Student("Sally", 15, 8, 'D');
      Student sipho = new Student("Sipho", 17 , 11, 'A');
      Student rajesh = new Student("Rajesh", 19, 12, 'B');
      
      System.out.println("Students\n");
      System.out.println(sally + "\n");
      System.out.println(sipho + "\n");
      System.out.println(rajesh);


      Teacher peterTownsend = new Teacher("Peter Townsend", 25, "2015/09/01", (double) 30000.00, "Geography");
      Teacher melissaParker = new Teacher("Melissa J Parker", 61, "1998/06/01", (double) 45000.00, "Art");
      Teacher jackFrost = new Teacher("Jack Frost", 33, "2002/02/02", (double) 40000.00, "Life Sciences");

      System.out.println("\nTeachers\n");
      System.out.println(peterTownsend + "\n");
      System.out.println(melissaParker + "\n");
      System.out.println(jackFrost);


      Secretary jennyHarding = new Secretary("Jenny Harding", 46, "2012/08/01", (double) 25000.00, "Harold Carter");
      Secretary lizaWellington = new Secretary("Liza Wellington", 25, "2019/10/01", (double) 21000.00, "Steve Hunt");
      Secretary christaHolmes = new Secretary("Christa Holmes", 29, "2021/04/01", (double) 17500.00, "Sarah Janice");
		
		
      System.out.println("\nSecretaries\n");		
      System.out.println(jennyHarding. + "\n");
      System.out.println(lizaWellington + "\n");
      System.out.println(christaHolmes + "\n");
   }
}