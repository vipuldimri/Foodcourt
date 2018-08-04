/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author dimri
 */
public class FoodCourtFactory {
      public static FoodCourtMainInterface GetInstance()
    {
         return new FoodCourtMainImplementation();
    }
}
