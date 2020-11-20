/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kln.dim.BirthdayCalculator;

/**
 *
 * @author Shamika Tissera
 */
import java.time.LocalDate;
import java.time.Month;
public class IDNoToBoDGen {
    LocalDate birthday;
    String IDNo;
    String year;
    boolean isMale;
    boolean isNewNIC;
    public IDNoToBoDGen(String IDNo){
        int size = IDNo.length();
        if (size > 10){
            isNewNIC = true;
        }
        else
            isNewNIC = false;
        this.IDNo = IDNo;
        if(isNewNIC)
            newNICBoD();
        else
            oldNICBoD();
    }
    private void newNICBoD(){
        year = IDNo.substring(0, 4); //The first 4 digits corresponds to the birth year
        int numberOfDays = Integer.parseInt(IDNo.substring(4, 7));
        if(numberOfDays > 400){
            //This is the condition to check whether female
            isMale = false;
            numberOfDays -= 500; //Deduct 500 to get the accurate number of days            
        }
        else{
            //Is a male
            isMale = true;            
        }
        
        birthday = LocalDate.of(Integer.parseInt(year), 1, 1);
        birthday = birthday.plusDays(numberOfDays);
    }
    
    private void oldNICBoD(){
        year = "19" + IDNo.substring(0, 2); //The first 2 digits correspond to the birthyear
        int numberOfDays = Integer.parseInt(IDNo.substring(2, 5));
        if(numberOfDays > 400){
            //This is the condition to check whether female
            isMale = false;
            numberOfDays -= 500; //Deduct 500 to get the accurate number of days            
        }
        else{
            //Is a male
            isMale = true;            
        }
        
        birthday = LocalDate.of(Integer.parseInt(year), Month.JANUARY, 1);
        birthday = birthday.plusDays(numberOfDays);
    }
    public String getGender(){
        if(isMale)
            return "Male";
        else
            return "Female";
    }
    public LocalDate getBirthday(){
        return birthday;
    }
}
