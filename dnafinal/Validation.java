/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnafinal;

import java.util.regex.Pattern;

/**
 *
 * @author HimaTech
 */
public class Validation {
    public static void main(String[] args) {
        String username="vijethadjain@gmail.com";
            //String patternEmail="(([a-zA-Z0-9])*([._0-9a-zA-Z])*[@]([a-zA-Z])[.]([co||com||in]))";
        String patternEmail="([a-zA-Z0-9])*([._0-9a-zA-Z])*[@]([a-zA-Z0-9])+[.][a-z]{2,3}";
               if(Pattern.matches(patternEmail, username))
                    {
                        System.out.println("Match");
                    }
               else
               {
                      System.out.println("Dosn't Match");
                   
               }
    }
}
