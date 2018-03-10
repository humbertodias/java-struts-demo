package actions;

import com.opensymphony.xwork2.Action;
import control.ProductDAO;
import java.util.List;
import model.Product;
import org.apache.struts2.ServletActionContext;

public class UpdateProduct extends Product {

    public String execute() {
        String submitType = ServletActionContext.getRequest().getParameter("submitType");

        if ("form".equals(submitType)) {
            int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
            List<Product> findById = ProductDAO.findById(id);
            if (!findById.isEmpty()) {
                Product p = findById.get(0);
                this.setId(p.getId());
                this.setName(p.getName());
                this.setPrice(p.getPrice());
                return "update";
            } else {
                return Action.ERROR;
            }

        }

        return ProductDAO.update(this) ? Action.SUCCESS : Action.ERROR;
    }

}
