// Name     : Michael Monical
// Class    : 1620-001
// Program #    : 2
// Due Date     : Sept. 29, 2016
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
}
