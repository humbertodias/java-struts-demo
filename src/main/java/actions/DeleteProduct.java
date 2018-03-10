package actions;

import com.opensymphony.xwork2.Action;
import control.ProductDAO;
import org.apache.struts2.ServletActionContext;

public class DeleteProduct {
    
    public String execute(){
        int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
        return ProductDAO.delete(id) ? Action.SUCCESS : Action.ERROR;
    }
}
