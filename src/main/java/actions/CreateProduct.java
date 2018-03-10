/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.Action;
import control.ProductDAO;
import model.Product;

public class CreateProduct extends Product {
    
    public String execute() {
        return ProductDAO.create(this) ? Action.SUCCESS : Action.ERROR;
    }
    
}
