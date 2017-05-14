// Name     : Michael Monical
// Class    : 1620-001
// Program #    : 3
// Due Date     : Oct. 20, 2016
//
// Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Michael Monical
// NUID: 9263
// EMAIL: mikemonical@gmail.com

// Partners:None

// This sets up a little manager interface the user can then use to add or remove up to ten employees. Calculting various 
// things.


import employeeType.employee.Employee;
//import employeeType.subTypes.*; Why would this not work?
import employeeType.subTypes.HourlyEmployee;
import employeeType.subTypes.CommissionEmployee;
import employeeType.subTypes.SalaryEmployee;
import exceptions.InvalidCharacterException;
import java.util.Scanner;




public class EmployeeManager {

    private Employee[] employees;
    private final int employeeMax = 10;
    private int currentEmployees;

    //Method Name     :EmployeeManager
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Constructor, creates the Employee array, sets currentEmployees to 0.

    public EmployeeManager(){
        employees = new Employee[employeeMax];
        currentEmployees = 0;
    }

    //Method Name     :addEmployee
    //Parameters      :type:int, fn:String, ln:String, m:char, g:char, en:int, ft:boolean, amount:double
    //Return Value(s) :None
    //Partners        :None
    //Description     :Takes an int representing the type of Employee to be added (1 – Hourly, 2 – Salary, 3 – Commission) 
    //                 as well as the required data to create that Employee. If one of these values is not passed output 
    //                 the line, “Invalid Employee Type, None Added”, and exit the method. If an Employee with the given 
    //                 Employee Number already exists do not add the Employee and output the line, “Duplicate Not Added”, 
    //                 and exit the method. If the array is at maximum capacity do not add the new Employee, and output 
    //                 the line, "Cannot add more Employees".


    public void addEmployee(int type, String fn, String ln, char m, char g, int en, boolean ft, double amount){


        if (currentEmployees == employeeMax)
        {
            System.out.println("Cannot add more Employees");
            return;
        }

        switch (type) {
            case 1:
                for(int i = 0;i < currentEmployees;i++){
                    if(en == employees[i].getEmployeeNumber()){
                        System.out.println("Duplicate Not Added");
                        return;
                    }

                }   employees[currentEmployees] = new HourlyEmployee(fn, ln, m, g, en, ft, amount);

                break;
            case 2:
                for(int i = 0;i < currentEmployees;i++){
                    if(en == employees[i].getEmployeeNumber()){
                        System.out.println("Duplicate Not Added");
                        return;
                    }
                    employees[currentEmployees] = new SalaryEmployee(fn, ln, m, g, en, ft, amount);
                }   break;
            case 3:
                for(int i = 0;i < currentEmployees;i++){
                    if(en == employees[i].getEmployeeNumber()){
                        System.out.println("Duplicate Not Added");
                        return;
                    }
                }   employees[currentEmployees] = new CommissionEmployee(fn, ln, m, g, en, ft, amount);
                break;
            default:
                System.out.println("Invalid Employee Type, None Added");
                break;
        }
        currentEmployees++;
    }

    //Method Name     :removeEmployee
    //Parameters      :index:int
    //Return Value(s) :None
    //Partners        :None
    //Description     :Removes an Employee located at the given index from the Employee array.

    public void removeEmployee(int index)
    {
        if(index <= 0)
        {
            return;
        }

        employees[index] = null;
        currentEmployees--;

    }

    //Method Name     :listAll
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Lists all the current Employees. Outputs there are none if there are none.

    public void listAll()
    {
        if (currentEmployees == 0)
        {
            System.out.println("No Employees.\n");
        }
        else{ 
            for(int i = 0; i < currentEmployees; i++){
                System.out.println("\n" + employees[i].toString() + "\n"); 
                //System.out.println("currentEmployees ==" + currentEmployees);
            }
        }
    }

    //Method Name     :listHourly
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Lists all the current HourlyEmployees. Outputs there are none if there are none.


    public void listHourly()
    {
        if (currentEmployees == 0)
        {
            System.out.println("No Employees.\n");
        }
        else
        {
            for(int i = 0; i < currentEmployees; i++)
            {
                if(employees[i] instanceof HourlyEmployee)
                    System.out.println("\n" + employees[i].toString() + "\n");
            }    
        }    
    }    

    //Method Name     :listSalary
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Lists all the current SalaryEmployees. Outputs there are none if there are none.



    public void listSalary()
    {
        if (currentEmployees == 0)
        {
            System.out.println("No Employees.\n");
        }
        else
        {
            for(int i = 0; i < currentEmployees; i++)
            {
                if(employees[i] instanceof SalaryEmployee)
                    System.out.println("\n" + employees[i].toString() + "\n");

            }    
        }
    }

    //Method Name     :listCommission
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Lists all the current CommissionEmployees. Outputs there are none if there are none.


    public void listCommission()
    {
        if (currentEmployees == 0)
        {
            System.out.println("No Employees.\n");
        }
        else
        {
            for(int i = 0; i < currentEmployees; i++)
            {
                if(employees[i] instanceof CommissionEmployee)
                    System.out.println("\n" + employees[i].toString() + "\n");
            }    
        }

    }

    //Method Name     :resetWeek
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Resets the week for all Employees.



    public void resetWeek(){
        for(int i = 0; i < currentEmployees; i++){
            employees[i].resetWeek();
        }
    }

    //Method Name     :calculatePayout
    //Parameters      :None
    //Return Value(s) :sum:double
    //Partners        :None
    //Description     :Returns the total weekly payout for all Employees.

    public double calculatePayout(){
        double sum = 0.0;
        for(int i = 0; i < currentEmployees; i++){
            sum += employees[i].calculateWeeklyPay(); 
        }
        return sum;
    }

    //Method Name     :getIndex
    //Parameters      :None
    //Return Value(s) :i:int
    //Partners        :None
    //Description     :Given an Employee Number, returns the index of that Employee in the array, if the Employee 
    //                 doesn’t exist retuns -1.


    public int getIndex(int empNum){
        for(int i = 0; i < currentEmployees; i++){
            if (employees[i].getEmployeeNumber() == empNum)
                return i;
        }
        return -1;
    }

    //Method Name     :annualRaises
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Applies annual raise to all current Employees.

    public void annualRaises(){
        for(int i = 0; i < currentEmployees; i++){
            employees[i].annualRaise();
        }
    }

    //Method Name     :holidayBonuses
    //Parameters      :None
    //Return Value(s) :bonus:double
    //Partners        :None
    //Description     :Outputs and returns the total holiday bonus of all Employees.


    public double holidayBonuses(){
        double bonus = 0.0;
        for(int i = 0; i < currentEmployees; i++){
            bonus += employees[i].holidayBonus();
        }
        return bonus;
    }

    //Method Name     :increaseHours
    //Parameters      :index:int, amount:double
    //Return Value(s) :None
    //Partners        :None
    //Description     :Increase the hours worked of the Employee at the given index by the given double amount.

    public void increaseHours(int index, double amount){

        HourlyEmployee Employee = (HourlyEmployee)employees[index];
        Employee.increaseHours(amount);

    }

    //Method Name     :increaseSales
    //Parameters      :index:int, amount:double
    //Return Value(s) :None
    //Partners        :None
    //Description     :Increase the sales of the Employee at the given index by the given double amount.


    public void increaseSales(int index, double amount){

        CommissionEmployee Employee = (CommissionEmployee)employees[index];
        Employee.increaseSales(amount);

    }
    
    //Method Name     :findAllBySubstring
    //Parameters      :String: find
    //Return Value(s) :Array
    //Partners        :None
    //Description     :This method will return an array of all the Employees in the EmployeeManager that contain 
    //                the substring passed. Create a new Employee array with the size of the number of current 
    //                Employees. For every Employee call upon the RabinKarp method giving the search string as 
    //                the concatenation of that Employee’s first and last name (no spaces). If the substring is 
    //                found in the Employee add that Employee to the new array. After all have been checked, 
    //                return the array.
    
    public Employee[] findAllBySubstring(String find)
    {
        String name;
        int found = 0;
        Employee[] ea = new Employee[currentEmployees]; 

        for(int i = 0 ; i < currentEmployees;i++)
        {
            name = employees[i].getFirstName() + employees[i].getLastName();
            if (RabinKarp(name, find) != -1)
            {
                //System.out.println("found " + employees[i].getFirstName());
                ea[found] = employees[i];
                found++;
            }
            
                //return ea;

        }


        return  ea;
    }
   
    //Method Name     :charNumericValue
    //Parameters      :char: c
    //Return Value(s) :int or throws InvalidCharacterException
    //Partners        :None
    //Description     :Given a character, returns the numeric value of the character, starting with A – 0 up to Z – 25. 
    //                This should treat upper and lower case the same; that is passing it ‘A’ will return 0, passing 
    //                it ‘a’ will also return 0. If a letter is not passed this method should create and throw an 
    //                InvalidCharacterException as provided.

    private int charNumericValue(char c) throws InvalidCharacterException
    {       
        //int val = Character.toUpper(c) - 65;
            switch( c )
            {
                case 'a': 
                case 'A':
                    return 0;
                case 'b': 
                case 'B':
                    return 1;
                case 'c': 
                case 'C':
                    return 2;     
                case 'd': 
                case 'D':
                    return 3;    
                case 'e': 
                case 'E':
                    return 4;
                case 'f': 
                case 'F':
                    return 5;
                case 'g': 
                case 'G':
                    return 6;
                case 'h': 
                case 'H' :
                    return 7;
                case 'i': 
                case 'I':
                    return 8;
                case 'j': 
                case 'J':
                    return 9;
                case 'k':
                case 'K':
                    return 10;
                case 'l':
                case 'L':
                    return 11;
                case 'm': 
                case 'M':
                    return 12;
                case 'n': 
                case 'N':
                    return 13;
                case 'o': 
                case 'O':
                    return 14;
                case 'p': 
                case 'P':
                    return 15;
                case 'q': 
                case 'Q':
                    return 16;
                case 'r': 
                case 'R':
                    return 17;
                case 's': 
                case 'S':
                    return 18;
                case 't': 
                case 'T':
                    return 19;
                case 'u': 
                case 'U':
                    return 20;
                case 'v': 
                case 'V':
                    return 21;
                case 'w': 
                case 'W':
                    return 22;
                case 'x': 
                case 'X':
                    return 23;
                case 'y': 
                case 'Y':
                    return 24;
                case 'z': 
                case 'Z':
                    return 25;
                default: 
                    throw new InvalidCharacterException( c );
            }
            
            
    }
    //Method Name     :stringHash
    //Parameters      :String:s
    //Return Value(s) :int:hash
    //Partners        :None
    //Description     :Given a string, return the hash value of the entire String. Use a base 26 number system to 
    //                create the hash as described in class. This will be needed only to find the hash of the 
    //                substring that is being searched for and the base case for finding all substring hashes 
    //                in the search string.

    
    private int stringHash (String s)
    {
        int hash = 0;
        int l = s.length();
        for(int i = 0; i < l; i++)
        {

           hash += charNumericValue(s.charAt(i))* (int) Math.pow(26, l - i - 1);
        }
        //System.out.println("Hashing " + s + " to " + hash);
        return hash;
    }

    //Method Name     :RabinKarpHashes
    //Parameters      :String:s, intArray:hashes, int:pos, int:length
    //Return Value(s) :int
    //Partners        :None
    //Description     :Finds the hash values of all substrings of size length in the String s, starting at index 
    //                pos and down. These values are stored in the passed hashes array. This method must be recursive, 
    //                using the technique as described in the Rabin-Karp lecture.

    private int RabinKarpHashes(String s, int[] hashes, int pos, int length )
    {
        if(pos < 0)
        {
            return 0;
        }
        //System.out.println("value of pos is: " + pos);
        //System.out.println("value of length is: " + length);
        hashes[pos] = stringHash(s.substring(pos, pos + length ));

        //System.out.println("hashing " + s.substring(pos, pos + length));

        return RabinKarpHashes(s, hashes, pos - 1, length);

        //for(int i = 0; i < s.length() - length; i++)
        // {
        //     hashes[i] = stringHash(s.substring(pos - length, pos));
        //     pos--;
        // }

        //return 1;
    }

    //Method Name     :linearSearchRecursive
    //Parameters      :String:s, intArray:hashes, int: both pos and length
    //Return Value(s) :int
    //Partners        :none
    //Description     :This is a recursive linear search. Return the position of key in the data array, or -1 
    //                if it is not present. This method must be recursive.

    private int linearSearchRecursive(int[] data, int key, int pos)
    {
        if (pos <= 0 ) 
        {
            return -1;
        }
        if(key == data[pos-1])
        {
            //System.out.println("found match " + (pos - 1));
            //System.out.println("data " + data[pos - 1]);
            //System.out.println("key " + key );
            return pos - 1; 
        } 

        return linearSearchRecursive( data, key, pos - 1);
    }
    
    //Method Name     :RabinKarp
    //Parameters      :String:name, string:find
    //Return Value(s) :int
    //Partners        :none
    //Description     :Does the preprocessing of finding the hash for the substring, find using the stringHash method 
    //                and the hashes of substrings in the search string using RabinKarpHashes method. Calls upon 
    //                linearSearchRecursive to determine if the substring hash is in the collection of hashes and 
    //                returns the result.            
    
    private int RabinKarp(String name, String find)
    {
        if (find.length() > name.length() )
        {    
            return -1;
        }
        
        int findhash = stringHash(find);
        int[] nameHashes = new int[name.length() - find.length()+1];
        RabinKarpHashes(name, nameHashes, name.length() - find.length(), find.length());
        //System.out.println("namehashes " + nameHashes.toString());
        return linearSearchRecursive(nameHashes, findhash, nameHashes.length);

    }


}
